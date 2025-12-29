import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class RREFSolverGUI extends JFrame {

    // UI Components
    private JTextField rowsField, colsField;
    private JPanel matrixPanel; // The container for the matrix grid
    private JTextField[][] matrixCells; // To store references to the grid inputs
    private JButton solveButton;
    private int m = 0; // rows
    private int n = 0; // cols

    public RREFSolverGUI() {
        setTitle("Automated Linear System Solver (RREF)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center on screen
        setLayout(new BorderLayout(10, 10));

        // --- TOP PANEL: Configuration ---
        JPanel configPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        configPanel.setBorder(new EmptyBorder(10, 10, 0, 10));

        configPanel.add(new JLabel("Rows (m ≤ 10):"));
        rowsField = new JTextField("3", 3);
        configPanel.add(rowsField);

        configPanel.add(new JLabel("Cols (n ≤ 10):"));
        colsField = new JTextField("4", 3);
        configPanel.add(colsField);

        JButton generateButton = new JButton("Generate Matrix");
        generateButton.setFocusable(false);
        configPanel.add(generateButton);

        add(configPanel, BorderLayout.NORTH);

        // --- CENTER PANEL: The Matrix Grid ---
        // We use a wrapper panel to keep the matrix centered and prevent it from stretching weirdly
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        matrixPanel = new JPanel();
        centerWrapper.add(matrixPanel);
        
        // Add a ScrollPane in case the matrix is large (though 10x10 usually fits)
        add(new JScrollPane(centerWrapper), BorderLayout.CENTER);

        // --- BOTTOM PANEL: Actions ---
        JPanel actionPanel = new JPanel(new FlowLayout());
        actionPanel.setBorder(new EmptyBorder(10, 10, 20, 10));

        solveButton = new JButton("Convert to RREF");
        solveButton.setEnabled(false); // Disabled until matrix is generated
        solveButton.setFont(new Font("Arial", Font.BOLD, 14));
        solveButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        solveButton.setForeground(Color.WHITE);
        solveButton.setFocusable(false);
        
        JButton resetButton = new JButton("Reset");
        resetButton.setFocusable(false);

        actionPanel.add(solveButton);
        actionPanel.add(resetButton);
        add(actionPanel, BorderLayout.SOUTH);

        // --- EVENT LISTENERS ---

        // 1. Generate Button Action
        generateButton.addActionListener(e -> generateMatrixGrid());

        // 2. Solve Button Action
        solveButton.addActionListener(e -> solveMatrix());

        // 3. Reset Button Action
        resetButton.addActionListener(e -> {
            matrixPanel.removeAll();
            matrixPanel.revalidate();
            matrixPanel.repaint();
            solveButton.setEnabled(false);
            rowsField.setText("");
            colsField.setText("");
        });
    }

    /**
     * Creates the grid of JTextFields based on user input for Rows and Cols.
     */
    private void generateMatrixGrid() {
        try {
            m = Integer.parseInt(rowsField.getText().trim());
            n = Integer.parseInt(colsField.getText().trim());

            if (m < 1 || m > 10 || n < 1 || n > 10) {
                JOptionPane.showMessageDialog(this, "Rows and Columns must be between 1 and 10.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Clear previous grid
            matrixPanel.removeAll();
            matrixPanel.setLayout(new GridLayout(m, n, 5, 5)); // Grid layout with gaps

            matrixCells = new JTextField[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    JTextField cell = new JTextField();
                    cell.setHorizontalAlignment(JTextField.CENTER);
                    cell.setPreferredSize(new Dimension(60, 30)); // Fixed size for cells
                    matrixCells[i][j] = cell;
                    matrixPanel.add(cell);
                }
            }

            solveButton.setEnabled(true);
            matrixPanel.revalidate();
            matrixPanel.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid integers for dimensions.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Reads values from the grid, performs Gaussian Elimination, and updates the grid.
     */
    private void solveMatrix() {
        double[][] matrix = new double[m][n];

        // 1. Read Inputs
        try {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    String text = matrixCells[i][j].getText().trim();
                    if (text.isEmpty()) {
                        matrix[i][j] = 0.0; // Default to 0 if empty
                    } else {
                        matrix[i][j] = Double.parseDouble(text);
                    }
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Matrix must contain only numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. Perform RREF
        convertToRREF(matrix);

        // 3. Update Grid with Results
        DecimalFormat df = new DecimalFormat("#.###"); // Format to 3 decimal places
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                double val = matrix[i][j];
                // Clean up -0.0 display issues
                if (Math.abs(val) < 1e-9) val = 0.0;
                
                matrixCells[i][j].setText(df.format(val));
                matrixCells[i][j].setBackground(new Color(230, 255, 230)); // Light green to indicate solution
            }
        }
        
        JOptionPane.showMessageDialog(this, "Matrix transformed to RREF successfully!");
    }

    /**
     * Standard Gauss-Jordan Elimination Logic
     */
    public static void convertToRREF(double[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int lead = 0;

        for (int r = 0; r < rowCount; r++) {
            if (colCount <= lead) return;

            int i = r;
            while (Math.abs(matrix[i][lead]) < 1e-9) {
                i++;
                if (rowCount == i) {
                    i = r;
                    lead++;
                    if (colCount == lead) return;
                }
            }

            // Swap rows
            double[] temp = matrix[i];
            matrix[i] = matrix[r];
            matrix[r] = temp;

            // Divide row by pivot
            double val = matrix[r][lead];
            for (int j = 0; j < colCount; j++) {
                matrix[r][j] /= val;
            }

            // Subtract from other rows
            for (int k = 0; k < rowCount; k++) {
                if (k != r) {
                    double factor = matrix[k][lead];
                    for (int j = 0; j < colCount; j++) {
                        matrix[k][j] -= factor * matrix[r][j];
                    }
                }
            }
            lead++;
        }
    }

    public static void main(String[] args) {
        // Run on Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> new RREFSolverGUI().setVisible(true));
    }
}