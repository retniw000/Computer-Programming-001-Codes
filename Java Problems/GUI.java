import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Checkbox Example");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Using null layout is okay for absolute positioning
        frame.setLayout(null); 

        // Starting position
        int x = 125;
        int y = 125;
        // The height of the checkbox is 25, so we need a larger increment
        int yIncrement = 30; // 5 pixels of space between checkboxes

        for (int i = 0; i < 5; i++) {
            JCheckBox checkbox = new JCheckBox("Option " + (i + 1));
            frame.add(checkbox);
            // x stays the same, y increases by 30 to stack them vertically
            checkbox.setBounds(x, y, 100, 25); // Set size (100 wide to hold label, 25 high)
            y += yIncrement; // Move the starting Y position down for the next checkbox
        }
        
        frame.setVisible(true); 
    }
}