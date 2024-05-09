import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static JTextField producedCarCount;
    private static JTextField carsInStorage;
    private static JTextField producedBodyCount;
    private static JTextField carBodiesInStorage;
    private static JTextField producedMotorCount;
    private static JTextField motorsInStorage;
    private static JTextField producedAccessoryCount;
    private static JTextField accessoriesInStorage;

    public static void main(String[] args) throws InterruptedException {

        CarFactory factory = new CarFactory();

        JFrame frame = new JFrame("CarFactory");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(510, 830); // размеры окна
        frame.setLocationRelativeTo(null); // окно - в центре экрана

        JPanel panel = (JPanel)frame.getContentPane();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        producedCarCount = new JTextField("Total cars produced: " + factory.getProducedCarCount());
        carsInStorage = new JTextField("Cars in storage: " + factory.getCarStorageItemCount());
        producedBodyCount = new JTextField("Total bodies produced: " + factory.getProducedBodyCount());
        carBodiesInStorage = new JTextField("Cars bodies in storage: " + factory.getBodyStorageItemCount());
        producedMotorCount = new JTextField("Total motors produced: " + factory.getProducedMotorCount());
        motorsInStorage = new JTextField("Motors in storage: " + factory.getMotorStorageItemCount());
        producedAccessoryCount = new JTextField("Total accessories: " + factory.getProducedAccessoryCount());
        accessoriesInStorage = new JTextField("Accessories in storage: " + factory.getAccessoryStorageItemCount());

        producedCarCount.setBounds(130,50, 250,40);
        carsInStorage.setBounds(130,105, 250,40);
        producedBodyCount.setBounds(130,160, 250,40);
        carBodiesInStorage.setBounds(130,215, 250,40);
        producedMotorCount.setBounds(130,270, 250,40);
        motorsInStorage.setBounds(130,325, 250,40);
        producedAccessoryCount.setBounds(130,380, 250,40);
        accessoriesInStorage.setBounds(130,435, 250,40);

        producedCarCount.setFont(new Font("Arial", Font.PLAIN, 20));
        carsInStorage.setFont(new Font("Arial", Font.PLAIN, 20));
        producedBodyCount.setFont(new Font("Arial", Font.PLAIN, 20));
        carBodiesInStorage.setFont(new Font("Arial", Font.PLAIN, 20));
        producedMotorCount.setFont(new Font("Arial", Font.PLAIN, 20));
        motorsInStorage.setFont(new Font("Arial", Font.PLAIN, 20));
        accessoriesInStorage.setFont(new Font("Arial", Font.PLAIN, 20));
        producedAccessoryCount.setFont(new Font("Arial", Font.PLAIN, 20));

        panel.add(producedCarCount);
        panel.add(carsInStorage);
        panel.add(producedBodyCount);
        panel.add(carBodiesInStorage);
        panel.add(producedMotorCount);
        panel.add(motorsInStorage);
        panel.add(producedAccessoryCount);
        panel.add(accessoriesInStorage);

        ////////////////////////////////////////////////
        JFrame frame2 = new JFrame("Settings");
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setSize(600, 650);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        panel1.setPreferredSize(new Dimension(400, 150));
        panel1.setBackground(new Color(224, 255, 255));
        panel2.setPreferredSize(new Dimension(400, 150));
        panel2.setBackground(new Color(175, 238, 238));
        panel3.setPreferredSize(new Dimension(400, 150));
        panel3.setBackground(new Color(64, 224, 208));
        panel4.setPreferredSize(new Dimension(400, 150));
        panel4.setBackground(new Color(0, 206, 209));

        // Создаем Box для размещения JPanel
        Box box = Box.createVerticalBox();
        box.add(panel1);
        box.add(Box.createVerticalStrut(10)); // Промежуток между панелями
        box.add(panel2);
        box.add(Box.createVerticalStrut(10));
        box.add(panel3);
        box.add(Box.createVerticalStrut(10));
        box.add(panel4);

        MySlider slider1 = new MySlider(panel1, factory.getDealerTask());
        MySlider slider2 = new MySlider(panel2, factory.getSupplierBodyTask());
        MySlider slider3 = new MySlider(panel3, factory.getSupplierMotorTask());
        MySlider slider4 = new MySlider(panel4, factory.getSupplierAccessoryTask());

        // Добавляем Box в JFrame
        frame2.getContentPane().add(box);

        // Делаем JFrame видимым
        frame2.setVisible(true);

        ///////////////////////////////////////////////
        frame.setVisible(true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                producedCarCount.setText("Total cars produced: " + factory.getProducedCarCount());
                carsInStorage.setText("Cars in storage: " + factory.getCarStorageItemCount());
                producedBodyCount.setText("Total bodies produced: " + factory.getProducedBodyCount());
                carBodiesInStorage.setText("Cars bodies in storage: " + factory.getBodyStorageItemCount());
                producedMotorCount.setText("Total motors produced: " + factory.getProducedMotorCount());
                motorsInStorage.setText("Motors in storage: " + factory.getMotorStorageItemCount());
                producedAccessoryCount.setText("Total accessories: " + factory.getProducedAccessoryCount());
                accessoriesInStorage.setText("Accessories in storage: " + factory.getAccessoryStorageItemCount());
            }
        };
        Timer timer = new Timer("Timer");
        timer.schedule(task, 0, 200);


        Thread.sleep(30000);
        factory.stopFactory();
    }
}