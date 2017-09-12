package com.ustbyjy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/9/12
 * Time: 15:45
 */
public class HelloServiceProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("################我是JDK动态代理################");

        Object result = null;

        System.err.println("我准备说hello...");
        result = method.invoke(target, args);
        System.err.println("我说过hello了...");

        return result;
    }
}
