package com.ustbyjy;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void test1() {
        Long value = 10L;
        value = -value;
        System.out.println(value);
    }

    /**
     * foreach和for循环都要检查空指针
     * 使用apache commons collections工具类进行检查
     */
    @Test
    public void test2() {
        List<Integer> list = null;
        if (CollectionUtils.isNotEmpty(list)) {
            for (Integer id : list) {
                System.out.println(id);
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("The list is empty...");
        }
    }
}
