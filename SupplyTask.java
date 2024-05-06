import java.lang.reflect.InvocationTargetException;

public class SupplyTask<T extends Detail> extends Task {
    private final Storage<T> storage;
    private final Class<T> itemT;
    private static int delay;
    public SupplyTask(String n, Storage<T> st, Class<T> it, int d) {
        super(n);
        storage = st;
        itemT = it;
        delay = d;
    }
    @Override
    public void perform() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(delay);
                T it = itemT.getDeclaredConstructor().newInstance();
                storage.put(it);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
