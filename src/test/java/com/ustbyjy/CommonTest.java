package com.ustbyjy;

import com.ustbyjy.bean.NutritionFacts;
import com.ustbyjy.bean.User;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testBuilder() {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        System.out.println(cocaCola);
    }

    @Test
    public void testUser() {
        User user = new User();
        System.out.println(user);
    }

    @Test
    public void testStringArray() {
        Object obj = new String[]{"hello", "world"};
        String[] stringArr = (String[]) obj;
        System.out.println(Arrays.toString(stringArr));
    }

    @Test
    public void testMapToString() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
        System.out.println(map);

        String result = "result:" + map;
        System.out.println(result);

        Object obj1 = 1;
        Object obj2 = "1";
        System.out.println(String.valueOf(obj1));
        System.out.println(String.valueOf(obj2));
    }
}
