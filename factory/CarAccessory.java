package factory;
import java.util.concurrent.atomic.AtomicInteger;

public class CarAccessory extends Detail {
    public static AtomicInteger producedAccessoryCount = new AtomicInteger(0);
    CarAccessory() {
        super();
        producedAccessoryCount.incrementAndGet();
    }
}
