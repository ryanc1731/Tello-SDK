package tello.cs420;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
   
public class MainScreen {

    public MainScreen() {
        JFrame frame = new JFrame("My Frame");
        frame.getContentPane().setBackground(new Color(112, 128, 144));
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel MainPage = new JPanel();
        MainPage.setBackground(new Color(255, 140, 75));
        MainPage.setLayout(null);
        frame.getContentPane().add(MainPage);
        
        
                JButton btn1 = new JButton("Enter Coordinates");
                btn1.setBounds(330, 260, 140, 29);
                MainPage.add(btn1);
                
                
                JLabel titleLabel = new JLabel("SEARCH AND RESCUE");
                titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
                titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
                titleLabel.setBounds(283, 10, 227, 26);
                MainPage.add(titleLabel);
                
                JButton btnNewButton = new JButton("Scan Parameter");
                MainPage.add(btnNewButton);
                btnNewButton.setBounds(330, 230, 140, 29);
                
                JButton prBtn = new JButton("Previous Results");
                MainPage.add(prBtn);
                prBtn.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                prBtn.setBounds(330, 320, 140, 29);
            
                
                JButton ssBtn = new JButton("Live Feed");
                MainPage.add(ssBtn);
                ssBtn.setBounds(330, 290, 140, 29);
                
                JButton BasicBtn = new JButton("Basic Functions");
                MainPage.add(BasicBtn);
                BasicBtn.setBounds(330, 200, 140, 29);
                
                
                JLabel lblNewLabel = new JLabel("New label");
                lblNewLabel.setIcon(new ImageIcon("Photos/fire2.jpg"));
                lblNewLabel.setBounds(364, 48, 70, 65);
                MainPage.add(lblNewLabel);
                
                JButton Land = new JButton("Emergency Land");
                Land.setBackground(new Color(255, 99, 71));
                Land.setBounds(450, 398, 140, 50);
                MainPage.add(Land);
                
                JButton Return = new JButton("Return To Base");
                Return.setBounds(240, 398, 140, 50);
                MainPage.add(Return);
                
                JPanel CoordinatesPanel = new JPanel();
                CoordinatesPanel.setBackground(new Color(192, 192, 192));
                frame.getContentPane().add(CoordinatesPanel, BorderLayout.NORTH);
                btn1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        showCoordinatesPage(frame);
                    }
                });

                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        showScanPerimeterPage(frame);
                    }
                });
                ssBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        showScreenshot(frame);
                    }
                });
                prBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        showPrevious(frame);
                    }
                });
                BasicBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        showBasicFxns(frame);
                    }
                });
                frame.setVisible(true);
            }
	
    private static void showCoordinatesPage(JFrame parentFrame) {
        JDialog dialog = new JDialog(parentFrame, "Coordinates Page", true);
        dialog.getContentPane().setLayout(new BorderLayout());

        CoordinatesPagePanel coordinatesPagePanel = new CoordinatesPagePanel();
        dialog.getContentPane().add(coordinatesPagePanel, BorderLayout.CENTER);

        dialog.setSize(800, 800);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    private static void showScanPerimeterPage(JFrame parentFrame) {
        ScanPerimeterPagePanel scanPerimeterPagePanel = new ScanPerimeterPagePanel();

        JDialog dialog = new JDialog(parentFrame, "Scan Perimeter Page", true);
        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add(scanPerimeterPagePanel, BorderLayout.CENTER);
        dialog.setSize(800, 650);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);

        scanPerimeterPagePanel.repaint();
    }
    private static void showScreenshot(JFrame parentFrame) {
    	TakeScreenshotPage takeScreenshotPage = new TakeScreenshotPage();

        JDialog dialog = new JDialog(parentFrame, "Live Feed & Screenshot Page", true);
        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add(takeScreenshotPage, BorderLayout.CENTER);
        dialog.setSize(800, 700);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);   
    }
    private static void showPrevious(JFrame parentFrame) {
    	PreviousResults previousResults = new PreviousResults();

        JDialog dialog = new JDialog(parentFrame, "Previous Results", true);
        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add(previousResults, BorderLayout.CENTER);
        dialog.setSize(800, 700);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
    private static void showBasicFxns(JFrame parentFrame) {
    	BasicFxnsPage basicfxns = new BasicFxnsPage();

        JDialog dialog = new JDialog(parentFrame, "Basic Functions", true);
        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add(basicfxns, BorderLayout.CENTER);
        dialog.setSize(800, 700);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}