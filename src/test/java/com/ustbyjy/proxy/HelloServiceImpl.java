package com.ustbyjy.proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/9/12
 * Time: 15:44
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.err.println("hello " + name);
    }
}
