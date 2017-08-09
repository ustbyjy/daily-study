package com.ustbyjy.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/7/13
 * Time: 10:02
 */
@XStreamAlias("person")
public class PersonBean {
    @XStreamAlias("firstName")
    @XStreamAsAttribute
    private String firstName;
    @XStreamAlias("lastName")
    private String lastName;

    @XStreamAlias("telPhone")
    private PhoneNumber tel;
    @XStreamAlias("faxPhone")
    private PhoneNumber fax;

    // 测试一个标签下有多个同名标签
    @XStreamAlias("friends")
    private Friends friend;

    // 测试一个标签下循环对象
//    @XStreamAlias("pets")
//    private Pets pet;

    @XStreamImplicit(itemFieldName = "animal")
    List<Animal> animals;


    public String getFirstName() {
        return firstName;
    }

    public PersonBean setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonBean setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PhoneNumber getTel() {
        return tel;
    }

    public PersonBean setTel(PhoneNumber tel) {
        this.tel = tel;
        return this;
    }

    public PhoneNumber getFax() {
        return fax;
    }

    public PersonBean setFax(PhoneNumber fax) {
        this.fax = fax;
        return this;
    }

    public Friends getFriend() {
        return friend;
    }

    public PersonBean setFriend(Friends friend) {
        this.friend = friend;
        return this;
    }

//    public Pets getPet() {
//        return pet;
//    }
//
//    public PersonBean setPet(Pets pet) {
//        this.pet = pet;
//        return this;
//    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public PersonBean setAnimals(List<Animal> animals) {
        this.animals = animals;
        return this;
    }
}