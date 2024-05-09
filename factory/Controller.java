package factory;
import java.util.logging.Logger;

public class Controller {
    private final Storage<Car> carStorage;
    private static final Logger logger = Logger.getLogger(Car.class.getName());
    public Controller(Storage<Car> storage) {
        carStorage = storage;
    }
    public void dealerRequest() throws InterruptedException {
        Car car = carStorage.get();
        logger.info("\n\nWAS CREATED A CAR (CAR ID: " + car.getId() + ", BODY ID: " + car.getCarBody().getId() +
                ", MOTOR ID: " + car.getCarMotor().getId() + ", ACCESSORY ID: " + car.getCarAccessory().getId() + ")\n");
    }
}
