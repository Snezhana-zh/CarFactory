package factory;
import java.util.concurrent.atomic.AtomicInteger;

public class Car extends Product {
    private final CarAccessory carAccessory;
    private final CarBody carBody;
    private final CarMotor carMotor;
    public static AtomicInteger producedCarCount = new AtomicInteger(0);

    public Car(CarAccessory carAccessory, CarBody carBody, CarMotor carMotor) {
        super();
        this.carAccessory = carAccessory;
        this.carBody = carBody;
        this.carMotor = carMotor;
        producedCarCount.incrementAndGet();
    }
    public CarAccessory getCarAccessory() {
        return carAccessory;
    }
    public CarMotor getCarMotor() {
        return carMotor;
    }
    public CarBody getCarBody() {
        return carBody;
    }
}
