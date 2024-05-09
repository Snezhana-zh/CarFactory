package factory;
import java.util.concurrent.atomic.AtomicInteger;

public class CarBody extends Detail {
    public static AtomicInteger producedBodyCount = new AtomicInteger(0);
    CarBody() {
        super();
        producedBodyCount.incrementAndGet();
    }
}
