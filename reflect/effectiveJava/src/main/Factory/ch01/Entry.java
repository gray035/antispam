package main.Factory.ch01;

import main.api.ch01.Provider;
import main.api.ch01.Service;

/**
 * Created by yangshenneng on 14/12/26.
 */
public class Entry {
    public static void main(String[] args) {
        Services.registerDefaultProvider(DEFAULT_PROVIDER);
        Services.registerProvider("comp", COMP_PROVIDER);
        Services.registerProvider("armed", ARMED_PROVIDER);

        Service s1 = Services.newInstance();
        Service s2 = Services.newInstance("comp");
        Service s3 = Services.newInstance("armed");
        System.out.printf("%s %s %s\n", s1, s2, s3);
        int a = 1;
        int b = 2;
        System.out.println(s1.sum(a, b));
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
                    return a + b;
                }
            };
        }
    };


    private static Provider ARMED_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service() {
                @Override
                public String toString() {
                    return "Armed service";
                }

                @Override
                public int sum(int a, int b) {
                    return a + b;
                }
            };
        }
    };
}
