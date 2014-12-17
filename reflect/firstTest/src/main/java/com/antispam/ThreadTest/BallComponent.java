package main.java.com.antispam.ThreadTest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangshenneng on 14/12/18.
 */
public class BallComponent extends JPanel {
    private static final int DEAFUALT_WIDTH = 450;
    private static final int DEAFUALT_HEIGHT = 350;

    private List<Ball> balls = new ArrayList<Ball>();

    public void add(Ball b) {
        balls.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEAFUALT_WIDTH, DEAFUALT_HEIGHT);
    }

}
