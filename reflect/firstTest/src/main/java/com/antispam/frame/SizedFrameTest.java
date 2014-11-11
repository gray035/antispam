package main.java.com.antispam.frame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yangshenneng on 14/11/10.
 */
public class SizedFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new SizedFrame();
                frame.setTitle("my image");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class SizedFrame extends JFrame {
    public SizedFrame() {
        add(new SayHello());
        pack();
    }
}

class SayHello extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        g.drawString("hello world",MESSAGE_X,MESSAGE_Y);
    }

    public Dimension getPreferredSize() {
        return  new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}