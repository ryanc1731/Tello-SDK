package tello.cs420;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BasicFxnsPage extends JPanel {
    public BasicFxnsPage() {
        
        setBackground(new Color(175, 214, 230));
        
        JButton takeoffBtn = new JButton("Take Off");
        takeoffBtn.setBounds(600, 50, 124, 59);
        takeoffBtn.setPreferredSize(new Dimension(50, 50));
        takeoffBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        setLayout(null);
        add(takeoffBtn);
        

        JButton left = new JButton("L");
        left.setBounds(30, 200, 100, 50);
        add(left);
        
        JButton right = new JButton("R");
        right.setBounds(140, 200, 100, 50);
        add(right);
        
        JButton up = new JButton("U");
        up.setBounds(95, 150, 100, 50);
        add(up);

        JButton down = new JButton("D");
        down.setBounds(95, 250, 100, 50);
        add(down);

        
        JButton LandBtn = new JButton("Emergency Land");
        LandBtn.setBackground(new Color(255, 99, 71));
        LandBtn.setBounds(400, 580, 140, 50);
        add(LandBtn);

        JButton ReturnBtn = new JButton("Return To Base");
        ReturnBtn.setBounds(200, 580, 140, 50);
        add(ReturnBtn);

                
        JPanel liveFeedPanel = new JPanel();
        liveFeedPanel.setBackground(Color.LIGHT_GRAY);
        liveFeedPanel.setBounds(280, 160, 470, 340);
        add(liveFeedPanel);
    }
}
       
