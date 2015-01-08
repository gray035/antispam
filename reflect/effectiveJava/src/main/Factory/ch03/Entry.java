package main.Factory.ch03;

/**
 * Created by yangshenneng on 15/1/9.
 */
public class Entry {
    public static void main(String[] args) {
        testComplex();
    }

    public static void testComplex() {
        Complex c = new Complex(1.0, 2.0);
        Complex d = c.add(new Complex(3.1, 3.2));
        System.out.println(d);
    }
}
