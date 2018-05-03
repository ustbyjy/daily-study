package com.ustbyjy.bean;

public class Children extends Parent {
    private static Integer sId = genId();

    private String name = genName();

    static {
        System.out.println(4);
    }

    {
        System.out.println(9);
    }

    public Children() {
        System.out.println(10);
    }

    private static Integer genId() {
        System.out.println(3);
        return 3;
    }

    private String genName() {
        System.out.println(8);
        return "8";
    }
}
