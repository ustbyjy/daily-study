package com.ustbyjy.bean;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/7/13
 * Time: 10:09
 */
public class Pets {
    @XStreamImplicit(itemFieldName = "pet")
    private List<Animal> animalList;

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
