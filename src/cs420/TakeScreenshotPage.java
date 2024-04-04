package cs420;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TakeScreenshotPage extends JPanel {
	
    public TakeScreenshotPage() {
        setBackground(Color.WHITE);

        JButton takeSceenshotBtn = new JButton("Take Screenshot");
        takeSceenshotBtn.setBounds(462, 6, 124, 59);
        takeSceenshotBtn.setPreferredSize(new Dimension(50, 50));
        takeSceenshotBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        setLayout(null);
        add(takeSceenshotBtn);
        
        JButton LandBtn = new JButton("Emergency Land");
        LandBtn.setBackground(new Color(255, 99, 71));
        LandBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement the logic for emergency landing here
            }
        });
        LandBtn.setBounds(335, 405, 140, 50);
        add(LandBtn);

        JButton ReturnBtn = new JButton("Return To Base");
        ReturnBtn.setBounds(130, 405, 140, 50);
        add(ReturnBtn);
        
        
        JPanel liveFeedPanel = new JPanel();
        liveFeedPanel.setBackground(Color.LIGHT_GRAY);
        liveFeedPanel.setBounds(50, 80, 500, 300); // Adjust the bounds as needed
        add(liveFeedPanel);
    }
}
