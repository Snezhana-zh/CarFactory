package factory;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Controller {
    private final Storage<Car> carStorage;
    private static final Logger logger = Logger.getLogger("logger");
    public Controller(Storage<Car> storage) {
        carStorage = storage;
    }
    public void dealerRequest() throws InterruptedException {
        Car car = carStorage.get();
        if (CarFactory.logsave) {
            try {
                FileHandler fh = new FileHandler("logfile.log", true);
                logger.addHandler(fh);
                logger.setUseParentHandlers(false);
                fh.setFormatter(new SimpleFormatter());
                logger.info("\n\nWAS CREATED A CAR (CAR ID: " + car.getId() + ", BODY ID: " + car.getCarBody().getId() +
                        ", MOTOR ID: " + car.getCarMotor().getId() + ", ACCESSORY ID: " + car.getCarAccessory().getId() + ")\n");
                fh.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "FH error", e);
            }
        }
    }
}
