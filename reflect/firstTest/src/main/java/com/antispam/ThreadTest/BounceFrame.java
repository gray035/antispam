package main.java.com.antispam.ThreadTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by yangshenneng on 14/12/17.
 */
public class BounceFrame extends JFrame{
    private BallComponent component;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;
    private Random random = new Random();

    public BounceFrame() {
        setTitle("Bounce");

        component = new BallComponent();
        add(component, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                addBall();
            }
        });
        addButton(buttonPanel, "Close", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    private void addBall() {
        double x = random.nextDouble();
        double y = random.nextDouble();
        x = x * 150;
        y = y * 150;
        Ball ball = new Ball(x, y);
        component.add(ball);
        Runnable r = new BallRunnable(ball, component);
        Thread t = new Thread(r);
        t.start();
    }

    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }
}
