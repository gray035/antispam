package main.Factory.ch06;

import java.util.Scanner;

/**
 * Created by yangshenneng on 15/2/23.
 */
public class Entry {
    static Planet planet;

    public static void main(String[] args) {
        enumTest();
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入一个人在地球上的重量：");
        earthTest(scanner.next());

        double x, y;
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        operationTest(x, y);
    }

    public static void enumTest() {
        planet = Planet.MERCURY;
        switch (planet) {
            case MERCURY: System.out.println(planet.surfaceWeight(planet.mass())); break;
            case VENUS: System.out.println(planet.surfaceWeight(planet.mass())); break;
        }
    }

    //输入一个地球上的物体质量显示在其他星球的质量
    public static void earthTest(String weight) {
        double earthWeight = Double.parseDouble(weight);
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for(Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
        }
    }

    public static void operationTest(double x, double y) {
        for(BasicOperation op : BasicOperation.values()) {
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
        }
    }
}
