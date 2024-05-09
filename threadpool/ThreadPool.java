package threadpool;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import factory.*;
public class ThreadPool {
    private final ArrayDeque<Task> taskQueue = new ArrayDeque<>();
    private final Set<PooledThread> availableThreads = new HashSet<>();
    private static final Logger logger = Logger.getLogger(ThreadPool.class.getName());
    private static int idThread = 0;

    public ThreadPool(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            availableThreads.add(new PooledThread("Performer " + idThread++, taskQueue));
        }
        for (PooledThread tr : availableThreads) {
            tr.start();
        }
    }
    public void addTask(Task t) {
        synchronized (taskQueue) {
            logger.fine("THREAD POOL :: ADDING NEW TASK " + t.getTaskName());
            taskQueue.add(t);
            taskQueue.notifyAll();
        }
    }
    public void shutdown(){
        logger.info("THREAD POOL :: SHUTTING DOWN POOL... INTERRUPTING THREADS");
        for (PooledThread pt : availableThreads) {
            pt.interruptPooledThread();
            logger.info("THREAD POOL :: INTERRUPTED " + pt.getName());
        }
//        for (PooledThread pt : availableThreads) {
//            try {
//                pt.join();
//                logger.info("THREAD POOL :: FINISHED " + pt.getName());
//            } catch (InterruptedException e){
//                logger.info("THREAD POOL :: INTERRUPTED WHILE JOINING " + pt.getName());
//            }
//        }
        logger.info("THREAD POOL :: SHUTDOWN COMPLETED");
    }
}
