package com.ustbyjy;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanjingyang
 * Date: 2017/3/13
 * Time: 15:12
 */
public class CommonTest {

    @Test
    public void test() {
        System.out.println("balance: " + balance(10000, 10, 0.06f));
    }

    private float balance(float capital, int year, float rate) {
        if (year < 1) {
            return capital - 10000;
        }
        return balance(capital * (1 + rate) + 10000, --year, rate);
    }
}
