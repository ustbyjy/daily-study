package com.ustbyjy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ustbyjy.bean.NutritionFacts;
import com.ustbyjy.bean.Privilege;
import com.ustbyjy.bean.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    }

    @Test
    public void testCompareString() {
        String s1 = "12:50:16";
        String s2 = "23:32:70";
        System.out.println(s1.compareTo(s2));

    }

    @Test
    public void testNullEquals() {
        String s = null;
        System.out.println("hello".equals(s));
        System.out.println(s.equals("hello"));
    }

    @Test(expected = NullPointerException.class)
    public void testString2Date() {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(null);
        } catch (ParseException e) {
            date = new Date();
        }
        System.out.println(date);
    }

    @Test
    public void testInteger() {
        // 使用缓冲区数据：-128 - 127，返回true
        System.out.println(Integer.valueOf("127") == Integer.valueOf("127"));
        // 未使用缓冲区数据，返回false
        System.out.println(Integer.valueOf("128") == Integer.valueOf("128"));
        // parseInt返回int类型，然后自动拆箱比较，返回true
        System.out.println(Integer.parseInt("128") == Integer.valueOf("128"));
    }

    @Test
    public void testStringLength() {
        String s1 = "6c4d433b33084eca913859762fbc938d$ireader@4028";
        System.out.println(s1.length());

    }

    @Test
    public void testMap() {
        Map<Integer, Privilege> map = new TreeMap<Integer, Privilege>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        map.put(100, new Privilege(100, "权限100", 0));
        map.put(1, new Privilege(1, "权限1", 10));
        map.put(3, new Privilege(3, "权限100", 20));
        map.put(10, new Privilege(10, "权限10", 30));
        map.put(6, new Privilege(6, "权限6", 40));
        for (Map.Entry<Integer, Privilege> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }

    @Test
    public void testPrintList() {
        List<String> list = Arrays.asList("hello", "word", "!!!");
        System.out.println(list);
    }

    /**
     * 在for循环中，应该初始化list长度，之后每次都取这个长度，而不是每次都调用list.size()方法来获取长度；
     * 不过，优化的效果不是很明显，只有当list特别大的时候才能看出来。
     */
    @Test
    public void testListSize() {
        int length = 1000000;
        List<Privilege> list = new ArrayList<Privilege>(1500000);
        Privilege privilege;
        for (int i = 0; i < length; i++) {
            privilege = new Privilege(i, "p" + i, i);
            list.add(privilege);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        long end = System.currentTimeMillis();
        long time1 = end - start;
        start = end;
        for (int i = 0, size = list.size(); i < size; i++) {
            System.out.println(list.get(i));
        }
        end = System.currentTimeMillis();
        long time2 = end - start;
        System.out.println("time1:" + time1);
        System.out.println("time2:" + time2);
    }

    /**
     * 一定不要在for循环里写try-catch，影响效率，要在try-catch里写for循环
     */
    @Test
    public void testException() {
        int length = 10000;
        long start = System.currentTimeMillis();

        for (int i = 0; i < length; i++) {
            try {
                FileWriter fw1 = new FileWriter("demo.txt");
                FileWriter fw2 = new FileWriter("demo.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        long time1 = end - start;
        start = end;

        try {
            for (int i = 0; i < length; i++) {
                FileWriter fw1 = new FileWriter("demo.txt");
                FileWriter fw2 = new FileWriter("demo.txt");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        end = System.currentTimeMillis();
        long time2 = end - start;
        System.out.println("time1:" + time1);
        System.out.println("time2:" + time2);
    }
}
