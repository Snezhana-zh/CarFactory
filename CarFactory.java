import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class CarFactory {
    private static final Logger logger = Logger.getLogger(CarFactory.class.getName());
    private Properties properties;

    private final Storage<CarMotor> motorStorage;
    private final Storage<CarBody> carBodyStorage;
    private final Storage<CarAccessory> accessoryStorage;
    private final Storage<Car> carStorage;

    private final ThreadPool workerThreadPool;
    private final ThreadPool supplierThreadPool;
    private final ThreadPool dealerThreadPool;

    public static Controller controller;

    public CarFactory() {
        logger.info("CAR FACTORY :: STARTING");
        try {
            properties = new Properties();
            properties.load(this.getClass().getResourceAsStream("config2"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // create storages
        carBodyStorage = new Storage<>(Integer.parseInt(properties.getProperty("CarBodyStorageCapacity")), "CarBodyStorage");
        motorStorage = new Storage<>(Integer.parseInt(properties.getProperty("MotorStorageCapacity")), "MotorStorage");
        accessoryStorage = new Storage<>(Integer.parseInt(properties.getProperty("AccessoryStorageCapacity")), "AccessoryStorage");
        carStorage = new Storage<>(Integer.parseInt(properties.getProperty("CarStorageCapacity")), "CarStorage");

        int supplierDelay = Integer.parseInt(properties.getProperty("SupplierDelay"));
        int dealerDelay = Integer.parseInt(properties.getProperty("DealerDelay"));

        int dealerCount = Integer.parseInt(properties.getProperty("NumberOfDealers"));
        int workerCount = Integer.parseInt(properties.getProperty("NumberOfWorkers"));
        int supplierCount = Integer.parseInt(properties.getProperty("NumberOfSuppliers"));

        // create thread pools
        supplierThreadPool = new ThreadPool(supplierCount * 3);
        workerThreadPool = new ThreadPool(workerCount);
        dealerThreadPool = new ThreadPool(dealerCount);

        Task supplierTaskBody = new SupplyTask<CarBody>("supplierTaskBody", carBodyStorage, CarBody.class, supplierDelay);
        Task supplierTaskAccessory = new SupplyTask<CarAccessory>("supplierTaskAccessory", accessoryStorage, CarAccessory.class, supplierDelay);
        Task supplierTaskMotor = new SupplyTask<CarMotor>("supplierTaskMotor", motorStorage, CarMotor.class, supplierDelay);
        Task workerTask = new WorkerTask("workerTask", carBodyStorage, accessoryStorage, motorStorage, carStorage);
        Task dealerTask = new DealerTask("dealerTask", dealerDelay);

        controller = new Controller(carStorage);

        // start production
        Thread factory = new Thread(() -> {
            for (int i = 0; i < supplierCount; ++i) {
                supplierThreadPool.addTask(supplierTaskBody);
                supplierThreadPool.addTask(supplierTaskAccessory);
                supplierThreadPool.addTask(supplierTaskMotor);
            }
            for (int i = 0; i < dealerCount; ++i) {
                dealerThreadPool.addTask(dealerTask);
            }
            for (int i = 0; i < workerCount; ++i) {
                workerThreadPool.addTask(workerTask);
            }
        });
        factory.start();
    }
    public void stopFactory() {
        logger.info("FACTORY :: STOPPING WORKING");
        dealerThreadPool.shutdown();
        supplierThreadPool.shutdown();
        workerThreadPool.shutdown();
        logger.info("FACTORY :: FINISHED WORKING");
    }
    public int getCarStorageItemCount() {
        return carStorage.getItemCount();
    }
    public AtomicInteger getProducedCarCount() {
        return Car.producedCarCount;
    }
    public int getBodyStorageItemCount() {
        return carBodyStorage.getItemCount();
    }
    public AtomicInteger getProducedBodyCount() {
        return CarBody.producedBodyCount;
    }
    public int getMotorStorageItemCount() {
        return motorStorage.getItemCount();
    }
    public AtomicInteger getProducedMotorCount() {
        return CarMotor.producedMotorCount;
    }
    public int getAccessoryStorageItemCount() {
        return accessoryStorage.getItemCount();
    }
    public AtomicInteger getProducedAccessoryCount() {
        return CarAccessory.producedAccessoryCount;
    }
}
