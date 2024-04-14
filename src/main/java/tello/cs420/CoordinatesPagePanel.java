package tello.cs420;

import javax.swing.*;
import java.awt.*;

public class CoordinatesPagePanel extends JPanel {
    private static final int GRID_SIZE = 20;
    private static final int CELL_SIZE = 40;

    JTextField xField = new JTextField(5);
    JTextField yField = new JTextField(5);

    private int dotX = -1;
    private int dotY = -1; 

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

        int marginX = (getWidth() - GRID_SIZE * cellWidth) / 2;
        int marginY = (getHeight() - GRID_SIZE * cellHeight) / 2;

        for (int i = 0; i < GRID_SIZE; i++) {
            int y = marginY + i * cellHeight;
            g.drawLine(marginX, y, getWidth() - marginX, y); 
            int labelY = y + cellHeight / 2; 
            g.drawString(String.valueOf(GRID_SIZE - i - 1), marginX / 2, labelY); 
        }
        for (int i = 0; i < GRID_SIZE; i++) {
            int x = marginX + i * cellWidth;
            g.drawLine(x, marginY, x, getHeight() - marginY); 
            int labelX = x + cellWidth / 2; 
            g.drawString(String.valueOf(i), labelX, getHeight() - marginY / 2);
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
        String xText = xField.getText();
        String yText = yField.getText();

        if (!xText.isEmpty() && !yText.isEmpty()) {
            try {
                int x = Integer.parseInt(xText);
                int y = Integer.parseInt(yText);

                dotX = x;
                dotY = y;

                String message = "Coordinates (" + x + ", " + y + ") were entered.";

                Window topLevelWindow = SwingUtilities.getWindowAncestor(this);
                if (topLevelWindow instanceof JFrame) {
                    JFrame topFrame = (JFrame) topLevelWindow;
                    JOptionPane.showMessageDialog(topFrame, message);
                } else if (topLevelWindow instanceof JDialog) {
                    JDialog topDialog = (JDialog) topLevelWindow;
                    JOptionPane.showMessageDialog(topDialog, message);
                } else {
                    JOptionPane.showMessageDialog(null, message);
                }
                repaint();
                showCoordinatePopup(x, y);
                xField.setText("");
                yField.setText("");
            } catch (NumberFormatException ex) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                JOptionPane.showMessageDialog(topFrame, "Invalid coordinates. Please enter integers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JOptionPane.showMessageDialog(topFrame, "Please enter both X and Y coordinates.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    private void showCoordinatePopup(int x, int y) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Coordinates (" + x + ", " + y + ") were entered.");
        panel.add(label);
    
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        int parentX = parentWindow.getX();
        int parentY = parentWindow.getY();
        int parentWidth = parentWindow.getWidth();
        int parentHeight = parentWindow.getHeight();
        int popupWidth = 600;
        int popupHeight = 400;
        int popupX = parentX + (parentWidth - popupWidth) / 2 + 400;
        int popupY = parentY + (parentHeight - popupHeight) / 2;
        JDialog popup = new JDialog(parentWindow, "Live Feed", Dialog.ModalityType.APPLICATION_MODAL);
        popup.getContentPane().add(panel);
        popup.setSize(popupWidth, popupHeight);
        popup.setLocation(popupX, popupY);
        popup.setVisible(true);

        
    }
    
}