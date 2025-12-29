import java.awt.*;
import javax.swing.*;

public class LabelTest extends JFrame {
    private JLabel label1, label2, label3;

    public LabelTest() {
        super("Testing JLabel");

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // label1: Text only
        label1 = new JLabel("Label with text");
        label1.setToolTipText("This is label1");
        container.add(label1);

        // label2: Text and Icon
        // Note: You would need a valid image file path for the Icon
        Icon bug = new ImageIcon(getClass().getResource("bug.gif")); 
        label2 = new JLabel("Label with text and icon", bug, SwingConstants.LEFT);
        label2.setToolTipText("This is label2");
        container.add(label2);

        // label3: Text and Icon, text at bottom
        label3 = new JLabel();
        label3.setText("Label with icon and text at bottom");
        label3.setIcon(bug);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("This is label3");
        container.add(label3);

        setSize(275, 170);
        setVisible(true);
    }

    public static void main(String[] args) {
        LabelTest application = new LabelTest();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}