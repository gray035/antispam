package main.Factory.ch01;

import main.api.ch01.Provider;
import main.api.ch01.Service;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by yangshenneng on 14/12/26.
 */
public class Entry {
    public static void main(String[] args) {
        //serviceProvide();
        //testNutritionFacts3();
        //testElvis();
        testPerson();
    }

    private static void testPerson() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1962, Calendar.JANUARY, 1);
        Person p = new Person(gmtCal.getTime());
        if(p.isBabyBoomer()) {
            System.out.println("yes");
        }
    }

    //全局共享一个实例
    public static void testElvis() {
        Elvis instance1 = Elvis.getInstance();
        instance1.setName("ysn");
        System.out.println(instance1);
        Elvis instance2 = Elvis.getInstance();
        instance2.setName("who");
        System.out.println(instance1);
    }

    //模拟服务提供和调用
    public static void serviceProvide() {
        Services.registerDefaultProvider(DEFAULT_PROVIDER);
        Services.registerProvider("comp", COMP_PROVIDER);

        Service s1 = Services.newInstance();
        Service s2 = Services.newInstance("comp");
        System.out.printf("%s %s\n", s1, s2);
        int a = 1;
        int b = 2;
        System.out.println(s1.sum(a, b));
        System.out.println(s2.sum(a, b));
    }

    private static Provider DEFAULT_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Default service";
                }

                @Override
                public int sum(int a, int b) {
                    return a + b;
                }
            };
        }
    };


    private static Provider COMP_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Complementary service";
                }

                @Override
                public int sum(int a, int b) {
                    return a * b;
                }
            };
        }
    };

    //builder模式
    public static void testNutritionFacts3() {
        NutritionFacts3 nutritionFacts3 = new NutritionFacts3.Builder(240, 8).build();
        System.out.println(nutritionFacts3.getServingSize() + " / " + nutritionFacts3.getFat());
    }

}
