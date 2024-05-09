package factory;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Product {
    protected int id;
    protected static AtomicInteger globalID = new AtomicInteger(0);
    public Product() {
        id = globalID.getAndIncrement();
    }
    public int getId() {
        return id;
    }
}
