package com.ustbyjy.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/7/13
 * Time: 10:05
 */
@XStreamAlias("phoneNumber")
public class PhoneNumber {
    @XStreamAlias("code")
    private int code;
    @XStreamAlias("number")
    private String number;

    public int getCode() {
        return code;
    }

    public PhoneNumber setCode(int code) {
        this.code = code;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public PhoneNumber setNumber(String number) {
        this.number = number;
        return this;
    }
}