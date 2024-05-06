import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

public class PooledThread extends Thread {
    private final ArrayDeque<Task> taskQueue;
    // public final AtomicBoolean wasShutDown = new AtomicBoolean(false);
    private static final Logger logger = Logger.getLogger(PooledThread.class.getName());

    public PooledThread(String name, ArrayDeque<Task> t) {
        super(name);
        taskQueue = t;
    }
    public void interruptPooledThread() {
        // wasShutDown.set(true);
        this.interrupt();
    }
    /*
    // suppler => put on storage if capacity > cur_count
    // worker => get from all storages if size > 0
    // dealer => controller => get from car storage
     */
    public void performTask(Task task) throws InterruptedException {
        logger.info("POOLED THREAD :: STARTED TASK: " + task.getTaskName());
        try {
            task.perform();
        } catch (InterruptedException e) {
            logger.info("POOLED THREAD :: THREAD: " + getName() +
                    " TASK WAS INTERRUPTED: " + task.getTaskName());
            // wasShutDown.set(true);
            throw e;
        }
        logger.info("POOLED THREAD :: FINISHED TASK: " + task.getTaskName());
    }

    public void run() {
        Task toExecute;
        //while (!wasShutDown.get()) {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (taskQueue) {
                if (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        logger.info("POOLED THREAD :: THREAD WAS INTERRUPTED: " + getName());
                        break;
                    }
                    continue;
                } else {
                    toExecute = taskQueue.remove();
                }
            }
            logger.info(getName() + " :: GOT THE JOB: " + toExecute.getTaskName());
            try {
                performTask(toExecute);
            } catch (InterruptedException e) {
                logger.info("POOLED THREAD :: THREAD WAS INTERRUPTED: " + getName());
                break;
            }
        }
        logger.info(getName() + " :: END EXECUTION........................");
    }
}
