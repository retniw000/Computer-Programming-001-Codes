import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * A simple 20x20 pixel art application using a grid of JButtons.
 */
public class PixelArtGUI extends JFrame {

    private final int GRID_SIZE = 20;
    private final JButton[][] gridButtons = new JButton[GRID_SIZE][GRID_SIZE];
    private Color currentColor = Color.BLACK; // Start with black

    public PixelArtGUI() {
        // --- 1. Set up the Main Window (JFrame) ---
        setTitle("20x20 Pixel Art");
        setSize(800, 800); // Window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- 2. Create the Pixel Grid Panel (Center) ---
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

        // Create the 400 buttons (20x20)
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                JButton pixelButton = new JButton();
                pixelButton.setBackground(Color.WHITE); // Default pixel color
                pixelButton.setOpaque(true); // Necessary for background color to show on some systems
                
                // Add a thin border to see the grid lines
                pixelButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                
                // Make buttons non-focusable to avoid the annyoing selection border
                pixelButton.setFocusable(false);

                // *** This is the main logic ***
                // Add an action listener to each button
                pixelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // When clicked, set the button's background to the currently selected color
                        JButton clickedButton = (JButton) e.getSource();
                        clickedButton.setBackground(currentColor);
                    }
                });

                // Add the button to the panel and store it in our array
                gridPanel.add(pixelButton);
                gridButtons[i][j] = pixelButton;
            }
        }

        // --- 3. Create the Color Palette Panel (Bottom) ---
        JPanel colorPalette = new JPanel();
        colorPalette.setLayout(new FlowLayout());

        // Add some color-picker buttons
        colorPalette.add(createColorButton(Color.BLACK));
        colorPalette.add(createColorButton(Color.RED));
        colorPalette.add(createColorButton(Color.GREEN));
        colorPalette.add(createColorButton(Color.BLUE));
        colorPalette.add(createColorButton(Color.YELLOW));
        colorPalette.add(createColorButton(Color.ORANGE));
        colorPalette.add(createColorButton(Color.CYAN));
        
        // Add an "Erase" button (which is just a white color button)
        JButton eraseButton = createColorButton(Color.WHITE);
        eraseButton.setText("Erase");
        eraseButton.setForeground(Color.BLACK); // Make text visible
        colorPalette.add(eraseButton);

        // Add a "Clear All" button
        JButton clearAllButton = new JButton("Clear All");
        clearAllButton.setFocusable(false);
        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Loop through all buttons and reset them to white
                for (int i = 0; i < GRID_SIZE; i++) {
                    for (int j = 0; j < GRID_SIZE; j++) {
                        gridButtons[i][j].setBackground(Color.WHITE);
                    }
                }
            }
        });
        colorPalette.add(clearAllButton);

        // --- 4. Add Panels to the Main Window ---
        add(gridPanel, BorderLayout.CENTER);
        add(colorPalette, BorderLayout.SOUTH);
    }

    /**
     * Helper method to create a color-selection button.
     * When this button is clicked, it sets the main `currentColor`.
     */
    private JButton createColorButton(Color color) {
        JButton colorButton = new JButton();
        colorButton.setBackground(color);
        colorButton.setOpaque(true);
        colorButton.setBorderPainted(false);
        colorButton.setPreferredSize(new Dimension(50, 50)); // Make the color swatch square
        colorButton.setFocusable(false);

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = color; // Set the "brush" color
            }
        });

        return colorButton;
    }

    /**
     * Main method to run the application.
     */
    public static void main(String[] args) {
        // Ensure the GUI is created on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PixelArtGUI().setVisible(true);
            }
        });
    }
}