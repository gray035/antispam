package main.java.com.antispam.reflect;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by yangshenneng on 15/2/1.
 */
public class ReflectCpTest {
    public static void main( String[] args ) throws IOException, ClassNotFoundException
    {
        try {
            Class baseRequestClazz = Class.forName("org.apache.http.message.BasicHttpEntityEnclosingRequest");//得到class，需要引入jar包
            Constructor baseRequestCon = baseRequestClazz.getDeclaredConstructor(String.class, String.class);//得到构造函数
            baseRequestCon.setAccessible(true);

            Object[] baseRequestParams = {new String("A"), new String("B")};
            Object baseRequestInstance = baseRequestCon.newInstance(baseRequestParams);//根据构造函数得到一个实例

            Class httpRequestClazz = Class.forName("org.apache.http.HttpRequest");//得到httprequst的class，为了得到构造函数的参数
            Class httpWrapperClazz = Class.forName("org.apache.http.impl.client.RequestWrapper");//构造函数的class
            Constructor httpWrapperCon = httpWrapperClazz.getDeclaredConstructor(httpRequestClazz);
            Object httpWrapperInstance = httpWrapperCon.newInstance(baseRequestInstance);//根据构造函数得到一个实例

            Method method = httpWrapperClazz.getMethod("containsHeader", String.class);//申明class的中的方法
            Object obj = method.invoke(httpWrapperInstance,"day");//invoke 根据实例和方法得到方法的返回值（必为object）
//http://javaweb.cc/JavaAPI1.6/
            System.out.println(obj.toString());
            System.out.println(obj.getClass());
            if ((Boolean)obj) //其实就是boolean直接强转
                System.out.println("yes");
            else
                System.out.println("no");
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
