package main.java.com.antispam.robot;

import javax.swing.*;

/**
 * Created by yangshenneng on 14/11/16.
 */
public class ButtonFrame extends JFrame{
    public ButtonFrame() {
        JPanel buttonpanel = new JPanel();
        JButton red = new JButton("red");
        buttonpanel.add(red);
        JButton yellow = new JButton("yellow");
        buttonpanel.add(yellow);
        JButton blue = new JButton("blue");
        buttonpanel.add(blue);
        add(buttonpanel);
        pack();
    }
}
