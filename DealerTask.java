public class DealerTask extends Task {
    private static int delay;
    public DealerTask(String n, int d) {
        super(n);
        delay = d;
    }

    @Override
    public void perform() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()){
            Thread.sleep(delay);
            CarFactory.controller.dealerRequest();
        }
    }
}
