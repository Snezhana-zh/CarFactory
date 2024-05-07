import java.lang.reflect.InvocationTargetException;

public class WorkerTask extends Task {
    private final Storage<Car> carStorage;
    private final Storage<CarAccessory> carAccessoryStorage;
    private final Storage<CarMotor> carMotorStorage;
    private final Storage<CarBody> carBodyStorage;

    public WorkerTask(String n, Storage<CarBody> cb, Storage<CarAccessory> ca, Storage<CarMotor> cm, Storage<Car> c) {
        super(n);
        carStorage = c;
        carAccessoryStorage = ca;
        carMotorStorage = cm;
        carBodyStorage = cb;
    }
    @Override
    public void perform() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            CarBody cb = carBodyStorage.get();
            CarAccessory ca = carAccessoryStorage.get();
            CarMotor cm = carMotorStorage.get();
            // Car it = Car.class.getDeclaredConstructor(CarAccessory.class,CarBody.class,CarMotor.class).newInstance(ca,cb,cm);
            carStorage.put(new Car(ca, cb, cm));
            // carStorage.put(it);
        }
    }
}
