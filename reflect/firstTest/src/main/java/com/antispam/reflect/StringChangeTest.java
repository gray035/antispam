package main.java.com.antispam.reflect;

import java.lang.reflect.Field;

/**
 * String是不可变类，赋值也常常是新建类，只有通过反射来改变却不新建对象
 * Created by yangshenneng on 15/1/7.
 */
public class StringChangeTest {

    public static void main(String[] args) throws Exception {
        testReflection();
    }

    public static void testReflection() throws Exception {

        //创建字符串"Hello World"， 并赋给引用s
        String s = "Hello World";

        System.out.println("s = " + s);	//Hello World

        //获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");

        //改变value属性的访问权限
        valueFieldOfString.setAccessible(true);

        //获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(s);

        //改变value所引用的数组中的第5个字符
        value[5] = '_';

        System.out.println("s = " + s);  //Hello_World
    }
}
