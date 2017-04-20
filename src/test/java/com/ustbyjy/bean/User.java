package com.ustbyjy.bean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/4/17
 * Time: 17:34
 */
public class User {
    private int id;
    private Integer _id;
    private String name;
    private String _name;
    private int age;
    private Integer _age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public Integer get_age() {
        return _age;
    }

    public void set_age(Integer _age) {
        this._age = _age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", _id=" + _id +
                ", name='" + name + '\'' +
                ", _name='" + _name + '\'' +
                ", age=" + age +
                ", _age=" + _age +
                '}';
    }
}
