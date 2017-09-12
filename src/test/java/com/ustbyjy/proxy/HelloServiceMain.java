package com.ustbyjy.proxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/9/12
 * Time: 15:50
 */
public class HelloServiceMain {

    public static void main(String[] args) {
        HelloServiceProxy helloHandler = new HelloServiceProxy();
        HelloService proxy = (HelloService) helloHandler.bind(new HelloServiceImpl());
        proxy.sayHello("张三");

        HelloServiceCgLib helloHandler2 = new HelloServiceCgLib();
        HelloService proxy2 = (HelloService) helloHandler2.getInstance(new HelloServiceImpl());
        proxy2.sayHello("李四");
    }
}
