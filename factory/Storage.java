package factory;
import java.util.ArrayDeque;
import java.util.logging.Logger;

public class Storage<T extends Product> {
    private final ArrayDeque<T> items;
    private final int capacity;
    private final String storageName;
    private static final Logger logger = Logger.getLogger(Storage.class.getName());
    private final Object monitor = new Object();
    public int getStorageCapacity() {
        return capacity;
    }
    public int getItemCount(){
        return items.size();
    }
    public Storage(int size, String name){
        storageName = name;
        capacity = size;
        items = new ArrayDeque<>();
        logger.info(storageName + " :: CREATED");
    }
    public T get () throws InterruptedException {
        synchronized (monitor) {
            while (true) {
                try {
                    logger.info(storageName + " SIZE " + items.size());
                    if (!items.isEmpty()) {
                        T item = items.getLast();
                        items.remove();
                        logger.info(storageName + " :: PASSING PRODUCT");
                        monitor.notify();
                        return item;
                    } else {
                        logger.info(storageName + " :: WAITING FOR A SPARE");
                        monitor.wait();
                        logger.info(storageName + " :: WOKE UP");
                    }
                } catch (InterruptedException e) {
                    logger.info(storageName + " :: INTERRUPTED IN WAIT");
                    throw e;
                }
            }
        }
    }

    public void put(T newItem) throws InterruptedException {
        synchronized (monitor) {
            while (true) {
                try {
                    logger.info(storageName + " SIZE " + items.size());
                    if (items.size() < capacity) {
                        logger.info(storageName + " :: GOT NEW ITEM :: " + newItem.getClass().getName() + " id: " + newItem.getId());
                        items.add(newItem);
                        logger.info(storageName + " :: NOTIFIED");
                        monitor.notify();
                        return;
                    } else {
                        logger.info(storageName + " :: STORAGE IS FULL");
                        monitor.wait();
                        logger.info(storageName + " :: WOKE UP");
                    }
                } catch (InterruptedException e) {
                    logger.info(storageName + " :: INTERRUPTED IN WAIT");
                    throw e;
                }
            }
        }
    }
}
