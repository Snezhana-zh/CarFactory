import javax.swing.*;
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

        // CarFactory factory = new CarFactory();

        JFrame frame = new JFrame("CarFactory");
        // frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(510, 830); // размеры окна
        frame.setLocationRelativeTo(null); // окно - в центре экрана

//        JPanel panel = (JPanel) frame.getContentPane();
//        panel.setLayout(null);
//        panel.setBackground(Color.WHITE);

//        producedCarCount = new JTextField("Total cars produced: " + factory.getProducedCarCount());
//        carsInStorage = new JTextField("Cars in storage: " + factory.getCarStorageItemCount());
//        producedBodyCount = new JTextField("Total bodies produced: " + factory.getProducedBodyCount());
//        carBodiesInStorage = new JTextField("Cars bodies in storage: " + factory.getBodyStorageItemCount());
//        producedMotorCount = new JTextField("Total motors produced: " + factory.getProducedMotorCount());
//        motorsInStorage = new JTextField("Motors in storage: " + factory.getMotorStorageItemCount());
//        producedAccessoryCount = new JTextField("Total accessories: " + factory.getProducedAccessoryCount());
//        accessoriesInStorage = new JTextField("Accessories in storage: " + factory.getAccessoryStorageItemCount());
//
//        producedCarCount.setBounds(130,50, 250,40);
//        carsInStorage.setBounds(130,105, 250,40);
//        producedBodyCount.setBounds(130,160, 250,40);
//        carBodiesInStorage.setBounds(130,215, 250,40);
//        producedMotorCount.setBounds(130,270, 250,40);
//        motorsInStorage.setBounds(130,325, 250,40);
//        producedAccessoryCount.setBounds(130,380, 250,40);
//        accessoriesInStorage.setBounds(130,435, 250,40);
//
//        producedCarCount.setFont(new Font("Arial", Font.PLAIN, 20));
//        carsInStorage.setFont(new Font("Arial", Font.PLAIN, 20));
//        producedBodyCount.setFont(new Font("Arial", Font.PLAIN, 20));
//        carBodiesInStorage.setFont(new Font("Arial", Font.PLAIN, 20));
//        producedMotorCount.setFont(new Font("Arial", Font.PLAIN, 20));
//        motorsInStorage.setFont(new Font("Arial", Font.PLAIN, 20));
//        accessoriesInStorage.setFont(new Font("Arial", Font.PLAIN, 20));
//        producedAccessoryCount.setFont(new Font("Arial", Font.PLAIN, 20));
//
//        panel.add(producedCarCount);
//        panel.add(carsInStorage);
//        panel.add(producedBodyCount);
//        panel.add(carBodiesInStorage);
//        panel.add(producedMotorCount);
//        panel.add(motorsInStorage);
//        panel.add(producedAccessoryCount);
//        panel.add(accessoriesInStorage);

        JPanel panel2 = new JPanel();

        JLabel label = new JLabel("hhhhh");

        panel2.setBackground(Color.WHITE);

        JSlider slider = new JSlider(0,100,50);
        slider.setPreferredSize(new Dimension(400,100));

        //slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setPaintLabels(true);

        panel2.add(slider);
        panel2.add(label);
        frame.add(panel2);
        // frame.pack();
        frame.setVisible(true);
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                producedCarCount.setText("Total cars produced: " + factory.getProducedCarCount());
//                carsInStorage.setText("Cars in storage: " + factory.getCarStorageItemCount());
//                producedBodyCount.setText("Total bodies produced: " + factory.getProducedBodyCount());
//                carBodiesInStorage.setText("Cars bodies in storage: " + factory.getBodyStorageItemCount());
//                producedMotorCount.setText("Total motors produced: " + factory.getProducedMotorCount());
//                motorsInStorage.setText("Motors in storage: " + factory.getMotorStorageItemCount());
//                producedAccessoryCount.setText("Total accessories: " + factory.getProducedAccessoryCount());
//                accessoriesInStorage.setText("Accessories in storage: " + factory.getAccessoryStorageItemCount());
//            }
//        };
//        Timer timer = new Timer("Timer");
//        timer.schedule(task, 0, 200);
//
//
//        Thread.sleep(15000);
//        factory.stopFactory();
    }
}