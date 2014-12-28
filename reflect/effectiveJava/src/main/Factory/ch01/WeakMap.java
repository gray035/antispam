package main.Factory.ch01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by yangshenneng on 14/12/28.
 */
public class WeakMap {
    public static void main(String[] args) throws InterruptedException {
        Map weakMap = new WeakHashMap();
        Map map = new HashMap();
        String a = new String("a");
        String b = new String("b");
        map.put(a,"aaa");
        map.put(b,"bbb");
        weakMap.put(a,"aaa");
        weakMap.put(b,"bbb");
        map.remove(a);
        a = null;
        b = null;
        System.out.println(map.get(b));
        System.gc();
        Thread.sleep(500);
        Iterator i = map.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry en = (Map.Entry)i.next();
            System.out.println("map:"+en.getKey()+":"+en.getValue());
        }

        Iterator j = weakMap.entrySet().iterator();
        while (j.hasNext()) {
            Map.Entry en = (Map.Entry)j.next();
            System.out.println("weakmap:"+en.getKey()+":"+en.getValue());

        }
    }
}
