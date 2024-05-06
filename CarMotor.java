import java.util.concurrent.atomic.AtomicInteger;

public class CarMotor extends Detail {
    public static AtomicInteger producedMotorCount = new AtomicInteger(0);
    CarMotor() {
        super();
        producedMotorCount.incrementAndGet();
    }

}
