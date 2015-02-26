package main.Factory.ch08;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by yangshenneng on 15/2/26.
 */
public class TreeTest {
    public static void main(String[] args) {
        Class<?> cl = null;
        try {
            cl = Class.forName("java.util.HashSet");
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found");
            System.exit(1);
        }

        Set<String> s = null;
        try {
            s = (Set<String>) cl.newInstance();
        } catch (IllegalAccessException e) {
            System.err.println("Class not accessible");
            System.exit(1);
        } catch (InstantiationException e) {
            System.err.println("Class not instantiable");
            System.exit(1);
        }
        s.addAll(Arrays.asList("1","2").subList(0,2));
        System.out.println(s);
    }
}
