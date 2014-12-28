package main.Factory.ch02;


import java.awt.Color;

/**
 * Created by yangshenneng on 14/12/28.
 */
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        if(color == null)
            throw new NullPointerException();
        point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    public boolean equals(Object o) {
        if(!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    //extend Point 这样颜色会和坐标孤立
    public boolean equalex(Object o) {

        if(!(o instanceof Point))
            return false;

        if(!(o instanceof ColorPoint)) {
            return o.equals(this);
        }

        return super.equals(o);
    }
}
