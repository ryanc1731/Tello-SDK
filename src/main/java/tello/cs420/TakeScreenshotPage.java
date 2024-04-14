package tello.cs420;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TakeScreenshotPage extends JPanel {
	
    public TakeScreenshotPage() {
        setLayout(null);
    

        JButton takeSceenshotBtn = new JButton("Take Screenshot");
        takeSceenshotBtn.setBounds(570, 15, 124, 59);
        takeSceenshotBtn.setPreferredSize(new Dimension(50, 50));

        setLayout(null);
        add(takeSceenshotBtn);
        
        JButton LandBtn = new JButton("Emergency Land");
        LandBtn.setBackground(new Color(255, 99, 71));
        LandBtn.setBounds(450, 600, 140, 50);
        add(LandBtn);

        JButton ReturnBtn = new JButton("Return To Base");
        ReturnBtn.setBounds(250, 600, 140, 50);
        add(ReturnBtn);
        
        
        JPanel liveFeedPanel = new JPanel();
        liveFeedPanel.setBackground(Color.LIGHT_GRAY);
        liveFeedPanel.setBounds(50, 100, 700, 450); 
        add(liveFeedPanel);
    
        ImageIcon backgroundImageIcon = new ImageIcon("Photos/abstract.jpg"); 
            JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
            backgroundImageLabel.setBounds(0, 0, backgroundImageIcon.getIconWidth(), backgroundImageIcon.getIconHeight());
            add(backgroundImageLabel);
    }
}
