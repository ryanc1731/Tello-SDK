package tello.cs420;

import java.awt.*;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;


public class PreviousResults extends JPanel {

    public PreviousResults() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);


        JLabel screenshot = new JLabel("Saved Screenshots");
        screenshot.setBounds(10, 10, 200, 30);
        screenshot.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        add(screenshot);

        JLabel coord = new JLabel("Previous Coordinates Entered");
        coord.setBounds(10, 370, 400, 30); 
        coord.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        add(coord);
    }
}

