package main.java.com.antispam.ThreadTest;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by yangshenneng on 14/12/18.
 */
public class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x ;
    private double y ;
    private double dx = 1;
    private double dy = 1;

    public Ball(double x,double y) {
        this.x = x;
        this.y = y;
    }

    public void move(Rectangle2D bounds) {
        x += dx;
        y += dy;
        if(x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if(x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if(y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if(y + YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}
