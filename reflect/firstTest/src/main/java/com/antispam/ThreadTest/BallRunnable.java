package main.java.com.antispam.ThreadTest;

import java.awt.*;

/**
 * Created by yangshenneng on 14/12/18.
 */
public class BallRunnable implements Runnable {
    private Ball ball;
    private Component component;
    public static final int STEPS = 1000;
    public static final int DELAY = 5;

    public BallRunnable(Ball a,Component component1) {
        ball = a;
        component = component1;
    }

    public void run() {
        try {
            for(int i = 1; i <= STEPS; i++) {
                ball.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
