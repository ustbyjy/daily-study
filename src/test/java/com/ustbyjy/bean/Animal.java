package com.ustbyjy.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/7/13
 * Time: 10:09
 */
public class Animal {
    @XStreamAlias("name")
    private String name;
    @XStreamAlias("age")
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Animal setAge(int age) {
        this.age = age;
        return this;
    }
}
