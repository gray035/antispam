package main.Factory.ch02;

/**
 * Created by yangshenneng on 14/12/28.
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if(!(o instanceof java.awt.Point))
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}
