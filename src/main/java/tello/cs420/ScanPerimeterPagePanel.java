package tello.cs420;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class ScanPerimeterPagePanel extends JPanel {
    private static final int CELL_SIZE = 40;
    private static final int GRID_SIZE = 15;
    private boolean[][] scannedCells = new boolean[GRID_SIZE][GRID_SIZE]; 
    private int currentX = 0;
    private int currentY = GRID_SIZE - 1;
    private Timer timer;

    public ScanPerimeterPagePanel() {
        setLayout(null);


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
        LandBtn.setBounds(635, 430, 140, 50);
        add(LandBtn);

        JButton ReturnBtn = new JButton("Return To Base");
        ReturnBtn.setBounds(635, 500, 140, 50);
        add(ReturnBtn);

        timer = new Timer(900, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scannedCells[currentX][currentY] = true; 
                repaint(); 
                if (currentX == GRID_SIZE - 1 && currentY == 0) {
                    timer.stop(); 
                } else {
                    if (currentX < GRID_SIZE - 1) {
                        currentX++; 
                    } else {
                        currentX = 0;
                        currentY--; 
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackgroundImage(g);
        drawScannedCells(g);
        drawGrid(g);
    }
    private void drawBackgroundImage(Graphics g) {
        Image backgroundImage = new ImageIcon("Photos/warehouse-design-example.png").getImage();
        int imageWidth = 600; 
        int imageHeight = 600; 
        g.drawImage(backgroundImage, 0, 0, imageWidth, imageHeight, this);
    }

    
    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int x = 0; x <= GRID_SIZE; x++) {
            g.drawLine(x * CELL_SIZE, 0, x * CELL_SIZE, GRID_SIZE * CELL_SIZE);
        }
        for (int y = 0; y <= GRID_SIZE; y++) {
            g.drawLine(0, y * CELL_SIZE, GRID_SIZE * CELL_SIZE, y * CELL_SIZE);
        }
    }

    private void drawScannedCells(Graphics g) {
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                if (scannedCells[x][y]) {
                    g.setColor(new Color(160, 255, 160));
                    g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }

    public void startGridSearch() {
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                scannedCells[x][y] = false;
            }
        }
        currentX = 0;
        currentY = GRID_SIZE - 1;
        timer.start();
    }
    
}
