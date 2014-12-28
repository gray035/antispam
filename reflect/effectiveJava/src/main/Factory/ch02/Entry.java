package main.Factory.ch02;

import java.awt.Color;

/**
 * Created by yangshenneng on 14/12/28.
 */
public class Entry {

    public static void main(String[] args) {
        testEquals();
    }

    public static void testEquals() {
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLACK);

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));
    }
}
