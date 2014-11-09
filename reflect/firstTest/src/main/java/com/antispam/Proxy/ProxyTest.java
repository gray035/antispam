package main.java.com.antispam.Proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by yangshenneng on 14/11/9.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1];

        for(int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null,new Class[]{Comparable.class},handler);//second 表示被代理的类(需要是个接口)
            Field[] fields = proxy.getClass().getDeclaredFields();
            for(Field f : fields) {
                System.out.print(f + " ");
            }
            System.out.println();
            Method[] methods = proxy.getClass().getDeclaredMethods();
            for(Method m : methods) {
                System.out.print(m + " ");
            }
            System.out.println();
            Class<?>[] interfaces = proxy.getClass().getInterfaces();
            for(Class<?> in : interfaces) {
                System.out.print(in.getName() + " ");
            }
            elements[i] = proxy;
        }

        Integer key = new Random().nextInt(elements.length) + 1;

        int result = Arrays.binarySearch(elements,key);
        if(result >= 0) {
            System.out.println(elements[result]);
        }
    }
}

class TraceHandler implements InvocationHandler {
    private Object target;
    public TraceHandler(Object t) {
        target = t;
    }

    public Object invoke(Object proxy, Method m,Object[] args) throws Throwable { //自动调用
        System.out.print(target);

        System.out.print("." + m.getName() + "(");
        if(args != null) {
            for(int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if(i < args.length - 1)
                    System.out.print(", ");
            }
        }
        System.out.println(")");

        return m.invoke(target,args);
    }
}
