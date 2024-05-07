public class DealerTask extends Task {
    private static int delay;
    private final Storage<Car> carStorage;

    public DealerTask(String n, int d, Storage<Car> cs) {
        super(n);
        delay = d;
        carStorage = cs;
    }

    @Override
    public void perform() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()){
            Thread.sleep(delay);
            //carStorage.get();
            CarFactory.controller.dealerRequest();
        }
    }
}
