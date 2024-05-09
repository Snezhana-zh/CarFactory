import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import factory.*;

public class MySlider implements ChangeListener {
    private JLabel label;
    private JSlider slider;
    private Task task;

    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("Value: " + slider.getValue());
        task.setDelay(slider.getValue());
    }
    MySlider(JPanel panel, Task t) {
        task = t;
        slider = new JSlider(0,6000, 2000);
        label = new JLabel();
        label.setFont(new Font("Arial", Font.PLAIN, 28));

        slider.setBackground(Color.WHITE);
        slider.setPreferredSize(new Dimension(400,100));
        slider.setMinorTickSpacing(500);
        slider.setMajorTickSpacing(1000);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setPaintLabels(true);

        label.setText("Value: " + slider.getValue());
        slider.addChangeListener(this);

        panel.add(label);
        panel.add(slider);
    }
}
