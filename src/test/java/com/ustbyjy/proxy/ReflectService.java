package com.ustbyjy.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/9/12
 * Time: 15:19
 */
public class ReflectService {

    public void sayHello(String name) {
        System.err.println("hello " + name);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Object service = Class.forName(ReflectService.class.getName()).newInstance();

        Method method = service.getClass().getMethod("sayHello", String.class);

        method.invoke(service, "zhangsan");
    }
}
