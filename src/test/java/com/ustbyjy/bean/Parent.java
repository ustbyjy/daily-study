package com.ustbyjy.bean;

public class Parent {
    private static Integer sId = genId();

    private String name = genName();

    static {
        System.out.println(2);
    }

    {
        System.out.println(6);
    }

    public Parent() {
        System.out.println(7);
    }

    private static Integer genId() {
        System.out.println(1);
        return 1;
    }

    private String genName() {
        System.out.println(5);
        return "5";
    }
}
