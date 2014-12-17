package main.java.com.antispam.ThreadTest;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yangshenneng on 14/12/17.
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setTitle("fuck");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
