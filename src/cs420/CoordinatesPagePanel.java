package cs420;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoordinatesPagePanel extends JPanel {
    private static final int CELL_SIZE = 40;
    private static final int GRID_SIZE = 20;

    JTextField xField = new JTextField(5);
    JTextField yField = new JTextField(5);

    private int dotX = -1; // X-coordinate of the dot
    private int dotY = -1; // Y-coordinate of the dot

    public CoordinatesPagePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel gridPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g);
                if (dotX != -1 && dotY != -1) {
                    drawDot(g, dotX, dotY);
                }
            }
        };
        gridPanel.setPreferredSize(new Dimension(CELL_SIZE * GRID_SIZE, CELL_SIZE * GRID_SIZE));
        add(gridPanel, BorderLayout.CENTER);

        JPanel xAxisPanel = new JPanel(new GridLayout(1, GRID_SIZE));
        for (int i = 1; i <= GRID_SIZE; i++) {
            JLabel label = new JLabel(String.valueOf(i));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            xAxisPanel.add(label);
        }
        add(xAxisPanel, BorderLayout.SOUTH);

        JPanel yAxisPanel = new JPanel(new GridLayout(GRID_SIZE, 1));
        for (int i = GRID_SIZE; i > 0; i--) {
            JLabel label = new JLabel(String.valueOf(i));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            yAxisPanel.add(label);
        }
        add(yAxisPanel, BorderLayout.WEST);
        xField.addActionListener(e -> addCoordinate());
        yField.addActionListener(e -> addCoordinate());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("X:"));
        inputPanel.add(xField);
        inputPanel.add(new JLabel("Y:"));
        inputPanel.add(yField);

        add(inputPanel, BorderLayout.NORTH);
    }
    

    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        int cellWidth = getWidth() / GRID_SIZE;
        int cellHeight = getHeight() / GRID_SIZE;

        // Draw horizontal lines and labels
        for (int i = 0; i < GRID_SIZE; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y); // Horizontal lines
            int labelY = y + cellHeight / 2; // Adjusted label Y-coordinate
            g.drawString(String.valueOf(GRID_SIZE - i), cellWidth / 4, labelY); // Draw label
        }

        // Draw vertical lines and labels
        for (int i = 0; i < GRID_SIZE; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight()); // Vertical lines
            int labelX = x + cellWidth / 2; // Adjusted label X-coordinate
            g.drawString(String.valueOf(i + 1), labelX, getHeight() - cellHeight / 4); // Draw label
        }
    }

    private void drawDot(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        int dotSize = CELL_SIZE / 2;
        int dotX = x * CELL_SIZE;
        int dotY = getHeight() - (y + 1) * CELL_SIZE;
        g.fillOval(dotX, dotY, dotSize, dotSize);
    }

    private void addCoordinate() {
        // Retrieve coordinates from text fields
        String xText = xField.getText();
        String yText = yField.getText();

        // Check if both x and y coordinates are provided
        if (!xText.isEmpty() && !yText.isEmpty()) {
            try {
                // Parse coordinates as integers
                int x = Integer.parseInt(xText);
                int y = Integer.parseInt(yText);

                // Store the dot coordinates
                dotX = x;
                dotY = y;

                // Customize the message
                String message = "Coordinates (" + x + ", " + y + ") were entered.";

                // Get the top-level window ancestor
                Window topLevelWindow = SwingUtilities.getWindowAncestor(this);
                if (topLevelWindow instanceof JFrame) {
                    // If the ancestor is a JFrame, cast it and use it
                    JFrame topFrame = (JFrame) topLevelWindow;
                    JOptionPane.showMessageDialog(topFrame, message);
                } else if (topLevelWindow instanceof JDialog) {
                    // If the ancestor is a JDialog, cast it and use it
                    JDialog topDialog = (JDialog) topLevelWindow;
                    JOptionPane.showMessageDialog(topDialog, message);
                } else {
                    // Handle other cases (this shouldn't happen in typical Swing applications)
                    JOptionPane.showMessageDialog(null, message);
                }

                // Request a repaint to update the dot position
                repaint();

                // Clear the text fields for next input
                xField.setText("");
                yField.setText("");
            } catch (NumberFormatException ex) {
                // Handle invalid input format
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                JOptionPane.showMessageDialog(topFrame, "Invalid coordinates. Please enter integers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Handle case when either x or y (or both) are not provided
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JOptionPane.showMessageDialog(topFrame, "Please enter both X and Y coordinates.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
