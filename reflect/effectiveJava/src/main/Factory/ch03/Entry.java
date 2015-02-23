package main.Factory.ch03;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by yangshenneng on 15/1/9.
 */
public class Entry {
    public static void main(String[] args) {
        testComplex();
        badExtendTest();
        rightExtendTest();
        extendRunTest();
    }

    public static void testComplex() {
        Complex c = new Complex(1.0, 2.0);
        Complex d = c.add(new Complex(3.1, 3.2));
        System.out.println(d);
    }

    public static void badExtendTest() {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());// why 6 not 3?super.addAll do 3 times add
    }

    public static void rightExtendTest() {
        RightInstrumentedHashSet<String> s = new RightInstrumentedHashSet<String>(new HashSet<String>());
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }

    public static void extendRunTest() {
        Sub sub = new Sub();
        sub.overrideMe();
    }

}
