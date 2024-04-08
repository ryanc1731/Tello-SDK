package tello;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ScanPerimeterPagePanel extends JPanel {
    private static final int CELL_SIZE = 40;
    private static final int GRID_SIZE = 15; // Adjust the grid size as needed
    private int droneX = 0; // Initial position of the drone
    private int droneY = 0;

    public ScanPerimeterPagePanel() {
        setBackground(Color.WHITE);

        JButton gridSearchButton = new JButton("Grid Search");
        gridSearchButton.setBounds(635, 6, 124, 59);
        gridSearchButton.setPreferredSize(new Dimension(50, 50));
        gridSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGridSearch();
            }
        });
        setLayout(null);
        add(gridSearchButton);
        
        JButton LandBtn = new JButton("Emergency Land");
        LandBtn.setBackground(new Color(255, 99, 71));
        LandBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement the logic for emergency landing here
            }
        });
        LandBtn.setBounds(635, 350, 140, 50);
        add(LandBtn);

        JButton ReturnBtn = new JButton("Return To Base");
        ReturnBtn.setBounds(635, 405, 140, 50);
        add(ReturnBtn);

        // Add key bindings for arrow keys
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = getInputMap(condition);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");

        actionMap.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveDrone(droneX - 1, droneY);
            }
        });
        actionMap.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveDrone(droneX + 1, droneY);
            }
        });
        actionMap.put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveDrone(droneX, droneY - 1);
            }
        });
        actionMap.put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveDrone(droneX, droneY + 1);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawDrone(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i <= GRID_SIZE; i++) {
            int x = i * CELL_SIZE;
            int y = i * CELL_SIZE;
            g.drawLine(0, y, GRID_SIZE * CELL_SIZE, y); // Horizontal lines
            g.drawLine(x, 0, x, GRID_SIZE * CELL_SIZE); // Vertical lines
        }
    }

    private void drawDrone(Graphics g) {
        g.setColor(Color.RED);
        int droneSize = CELL_SIZE / 2; // Size of the drone
        g.fillOval(droneX * CELL_SIZE + CELL_SIZE / 4, droneY * CELL_SIZE + CELL_SIZE / 4, droneSize, droneSize);
    }

    public void startGridSearch() {
        for (int y = 0; y < GRID_SIZE; y++) {
            // Move the drone right until it reaches the end of the row
            for (int x = 0; x < GRID_SIZE; x++) {
                moveDrone(x, y);
                sleep(); // Add a short delay to make the movement visible
            }
            // Move the drone down one row after reaching the end of the row
            moveDrone(0, y + 1);
            sleep(); // Add a short delay to make the movement visible
        }
    }

    private void moveDrone(int newX, int newY) {
        // Check if the new position is within the grid bounds
        if (newX >= 0 && newX < GRID_SIZE && newY >= 0 && newY < GRID_SIZE) {
            droneX = newX;
            droneY = newY;
            repaint(); // Repaint the panel to update the drone's position
        }
    }
    private void sleep() {
        try {
            Thread.sleep(100); // Adjust the delay (in milliseconds) as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}