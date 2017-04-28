package com.ustbyjy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ustbyjy.bean.NutritionFacts;
import com.ustbyjy.bean.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
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

    @Test
    public void testEnumToList() {
        List<CurrencyEnum> currencyList = Arrays.asList(CurrencyEnum.values());
        System.out.println(currencyList);
        for (CurrencyEnum currencyEnum : currencyList) {
            System.out.println("==========================================");
            System.out.println("name: " + currencyEnum.getName());
            System.out.println("symbol: " + currencyEnum.getSymbol());
        }

        String array = JSONArray.toJSONString(CurrencyEnum.values(), SerializerFeature.WriteEnumUsingToString);
        System.out.println(array);
    }

    enum CurrencyEnum {
        RMB("人民币", "RMB"), USD("美元", "USD");
        private String name;
        private String symbol;

        private CurrencyEnum(String name, String symbol) {
            this.name = name;
            this.symbol = symbol;
        }

        public String getName() {
            return name;
        }

        public String getSymbol() {
            return symbol;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", symbol='" + symbol + '\'' +
                    "} ";
        }
    }

    /**
     * 若列表为null，无论是普通for循环还是增强for循环，都会引发空指针异常
     */
    @Test
    public void testFor() {
        List<String> list = null;

//        for (String s : list) {
//            System.out.println(s);
//        }

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        list = Arrays.asList("we", "are", "the", "world");

        for (String s : list) {
            System.out.println(s);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testSplit() {
        String s1 = "1,2,3,";
        String s2 = "1,2,3";
        String[] array1 = s1.split(",");
        String[] array2 = s2.split(",");
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    /**
     * String转Integer这两种方式都调用了parseInt方法，parseInt方法的返回值是int类型：
     * 前者利用Java的自动封箱将int转化为Integer，后者显示调用Integer.valueOf(int)进行转化。
     */
    @Test
    public void testStringToInteger() {
        Integer i1 = Integer.parseInt("1");
        Integer i2 = Integer.valueOf("2");
        System.out.println(i1);
        System.out.println(i2);

        // 用空格去分隔字符串
        String str = "hello world  !!  yeah ";
        String[] strArray = str.split("\\s+");
        System.out.println(Arrays.toString(strArray));

        // 计数一个字符在某个字符串中出现的次数
        int n = StringUtils.countMatches("11112222", "1");
        System.out.println(n);
    }

    /**
     * 字符串为null时，打印"null"
     */
    @Test
    public void testNullString() {
        String s = null;
        System.out.println(s);
        StringBuilder sb = new StringBuilder().append("s=").append(s);
        System.out.println(sb.toString());

        String s1 = "感謝一直以來對《東方不敗》的支持與鼓勵，但天下無不散的宴席，遊戲於2017年4月26日18：00暫停儲值業務，其後遊戲伺服器將在2017年5月26日12:00進行關閉，並停止營運服務，詳情請見官網公告";
        System.out.println(s1.length());
    }

    @Test
    public void testSign() {
        String s1 = "KizACjaSYaBC7itMIP08fwm1ELLpzSlWARpg8ghAkVITppmQ2oj5FOclLrrnFYDFz8TKILsaxWMD6Y8bnKE1DR4Po%2BjGgC36YMeC%2B1neosLMqE4YEl8nDnfzRp66TGGo1X0yNErNmdOSJc%2BubT8ddI2b%2BmzfvPSxk%2F8K%2FpZ67kw%3D";
        String s2 = "KizACjaSYaBC7itMIP08fwm1ELLpzSlWARpg8ghAkVITppmQ2oj5FOclLrrnFYDFz8TKILsaxWMD6Y8bnKE1DR4Po%252BjGgC36YMeC%252B1neosLMqE4YEl8nDnfzRp66TGGo1X0yNErNmdOSJc%252BubT8ddI2b%252BmzfvPSxk%252F8K%252FpZ67kw%253D";
    }
}
