import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempConverter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null); // Absolute layout
        frame.add(panel);

        // Celsius Label and Field
        JLabel label = new JLabel("Celsius:");
        label.setBounds(10, 25, 70, 25);
        panel.add(label);

        JTextField txtcel = new JTextField();
        txtcel.setBounds(90, 25, 100, 25);
        panel.add(txtcel);

        // Fahrenheit Label and Field
        JLabel label2 = new JLabel("Fahrenheit:");
        label2.setBounds(10, 75, 80, 25);
        panel.add(label2);

        JTextField txtfah = new JTextField();
        txtfah.setBounds(90, 75, 100, 25);
        txtfah.setEditable(false); // Make it read-only
        panel.add(txtfah);

        // Convert Button
        JButton convert = new JButton("Convert");
        convert.setBounds(10, 120, 100, 30);      
        panel.add(convert);

        // Add the logic
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(txtcel.getText());
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    txtfah.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
                }
            }
        });

        // Set visible LAST so all components show up immediately
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}