package main.java.com.antispam.jstorm;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by yangshenneng on 14/12/14.
 */
public class TestRTMap {
    static RotatingMap<Integer,String> map = new RotatingMap<Integer, String>(3);

    static String[] number = {"0","1","2","3","4","5","6","7"};

    static void query() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int ans = cin.nextInt();
            if(map.containsKey(ans)) {
                System.out.println(map.get(ans));
            } else {
                System.out.println("no");
            }
            if(ans == 100)
                return;
        }
    }

    public static void main(String[] args) throws Exception{
        Random random = new Random();
        int test = 10;
        while(test -- > 0) {
            int now = random.nextInt(7);
            System.out.println(now);
            map.put(now,number[now]);
            if(map.size() > 1) {
                System.out.println("rotate");
                map.rotate();
            }
            query();
        }
    }
}
