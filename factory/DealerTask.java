package factory;
import java.util.logging.Logger;

public class DealerTask extends Task {
    private static int delay;
    private static final Logger logger = Logger.getLogger(Storage.class.getName());

    public DealerTask(String n, int d) {
        super(n);
        delay = d;
    }

    public void setDelay(int d) {
        delay = d;
        logger.info("\n\nCHANGE DELAY_________________" + delay);
    }

    @Override
    public void perform() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()){
            Thread.sleep(delay);
            CarFactory.controller.dealerRequest();
        }
    }
}
