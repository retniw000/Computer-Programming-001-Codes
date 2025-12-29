import java.awt.event.*;
import javax.swing.*;

public class GUIExercise implements ActionListener {

    // Components moved to class level
    private static JLabel label3;
    private static JTextField txtfield;
    private static JPasswordField pswfield;
    private static JButton loginBtn;
    private static JButton signupBtn;

    // Parallel arrays to store credentials (initialized with size 10 for this exercise)
    private static String[] usernames = new String[10];
    private static String[] passwords = new String[10];
    private static int userCount = 0; // Keeps track of how many users are registered

    public static void main(String[] args) {
        // Pre-fill one user for testing
        usernames[0] = "Admin";
        passwords[0] = "1234";
        userCount = 1;

        JFrame frame = new JFrame("Login & Sign-up System");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null); 
        frame.add(panel);

        JLabel label = new JLabel("User:");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        txtfield = new JTextField(20);
        txtfield.setBounds(100, 20, 165, 25);
        panel.add(txtfield);

        JLabel label2 = new JLabel("Password:");
        label2.setBounds(10, 50, 80, 25);
        panel.add(label2);

        pswfield = new JPasswordField();
        pswfield.setBounds(100, 50, 165, 25);
        panel.add(pswfield);

        // Login Button
        loginBtn = new JButton("Login");
        loginBtn.setBounds(10, 90, 100, 25);
        loginBtn.addActionListener(new GUIExercise());
        panel.add(loginBtn);

        // Sign-up Button
        signupBtn = new JButton("Sign-up");
        signupBtn.setBounds(120, 90, 100, 25);
        signupBtn.addActionListener(new GUIExercise());
        panel.add(signupBtn);

        label3 = new JLabel("Status: Waiting...");
        label3.setBounds(10, 130, 300, 25);
        panel.add(label3);

        frame.setVisible(true);
    }

    // This method now returns a boolean if it finds the user
    boolean searchUser(String user, String pass) {
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(user) && passwords[i].equals(pass)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = txtfield.getText();
        String passInput = new String(pswfield.getPassword());

        // Check which button was clicked
        if (e.getSource() == loginBtn) {
            if (searchUser(userInput, passInput)) {
                label3.setText("Login successful!");
                JOptionPane.showMessageDialog(null, "Welcome, " + userInput + "!");
            } else {
                label3.setText("Invalid username or password.");
            }
        } 
        else if (e.getSource() == signupBtn) {
            if (userInput.isEmpty() || passInput.isEmpty()) {
                label3.setText("Fields cannot be empty!");
            } else if (userCount < usernames.length) {
                usernames[userCount] = userInput;
                passwords[userCount] = passInput;
                userCount++;
                label3.setText("User registered! Total users: " + userCount);
                JOptionPane.showMessageDialog(null, "Account created for " + userInput);
            } else {
                label3.setText("Storage full! Cannot add more users.");
            }
        }
    }
}