package com.ustbyjy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ustbyjy.bean.ConfigList;
import com.ustbyjy.bean.NutritionFacts;
import com.ustbyjy.bean.Privilege;
import com.ustbyjy.bean.User;
import com.ustbyjy.util.FreeMarkerUtil;
import com.xiaoleilu.hutool.util.BeanUtil;
import freemarker.template.Template;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanjingyang@zulong.com
 * Date: 2017/3/13
 * Time: 15:12
 */
public class CommonTest {
    private static Logger logger = LoggerFactory.getLogger(CommonTest.class);

    /**
     * foreach和for循环都不检查空指针
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

    @Test
    public void testLogger() {
        try {
            throw new NullPointerException("空指针");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Test
    public void testEnum() {
        TypeEnum[] typeEnums = TypeEnum.values();
        for (TypeEnum typeEnum : typeEnums) {
            System.out.println(typeEnum.name());
        }
        System.out.println(JSONObject.toJSONString(TypeEnum.XML));
    }

    private enum TypeEnum {
        XML(0, "xml"), JSON(1, "json");

        private Integer id;
        private String name;

        private TypeEnum(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "TypeEnum{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    "} " + super.toString();
        }
    }

    @Test
    public void testCompareInteger() {
        Integer id = null;
        System.out.println(id < 0);
    }

    @Test
    public void testConfigList() {
        ConfigList configList = new ConfigList();
        configList.setId(222L);
        System.out.println(configList.toString());
    }

    @Test
    public void testNewString() {
        int length = 1000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            String s = String.valueOf(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("String.valueOf(i) spent: " + (end - start) + "ms");
        start = end;
        for (int i = 0; i < length; i++) {
            String s = "" + i;
        }
        end = System.currentTimeMillis();
        System.out.println("\"\" + i spent: " + (end - start) + "ms");
        start = end;
        for (int i = 0; i < length; i++) {
            String s = Integer.toString(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Integer.toString(i) spent: " + (end - start) + "ms");
    }

    @Test
    public void testString() {
        String s = "heihei";
        anotherString(s);
        System.out.println(s);
    }

    private void anotherString(String s) {
        s = "haha";
        System.out.println(s);
    }

    @Test
    public void testClassLoader() {
        System.out.println(this.getClass().getClassLoader().getResource(""));
    }

    @Test
    public void testProcess() {
        try {
            // create a new process
            System.out.println("Creating Process...");

            Process process = Runtime.getRuntime().exec("C:\\Program Files\\Git\\git-bash.exe");

            // destroy the process instantly to get a exit value
//            process.destroy();

            // get the exit value of the new process

//            Thread.sleep(5000);

            System.out.println("" + process.exitValue());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testEnvironment() {
        Map<String, String> map = System.getenv();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("OS: " + map.get("OS"));

        System.out.println("=====================华丽的分割线======================");

        Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("OS: " + System.getProperty("os.name"));
    }

    @Test
    public void testUUID() {
        String uuId = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuId);
        System.out.println(uuId.length());
    }

    @Test
    public void testReplaceString() {
        String ssoName = "yanjingyang@sso";
        System.out.println(ssoName.replace("@sso", ""));
        System.out.println(ssoName);
        System.out.println(21474836 * 100);
        System.out.println(Integer.MAX_VALUE * 100);
        System.out.println(null == null);
    }

    @Test
    public void testClone() {
        List<User> userList = new ArrayList<User>();

        User user = new User();
        user.setId(1);

        for (int i = 0; i < 10; i++) {
            User tempUser = new User();
            BeanUtil.copyProperties(user, tempUser);
            tempUser.setName("user-" + i);
            userList.add(tempUser);
            System.out.println(tempUser);
        }

        System.out.println("==============华丽丽的分割线==============");

        for (int i = 0; i < 10; i++) {
            User tempUser = userList.get(i);
            System.out.println(tempUser);
        }
    }

    @Test
    public void testPlus() {
        String s = "154+280+378+750";
        String[] strArray = s.split("\\+");
        int result = 0;
        for (int i = 0; i < strArray.length; i++) {
            result += Integer.parseInt(strArray[i]);
        }
        System.out.println(result);
    }

    @Test
    public void testDataToString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        System.out.println(sdf.format(new Date()));
    }

    /**
     * 自动拆箱会带来性能损耗，若Integer与int比较是可使用Integer.intValue()值比较
     */
    @Test
    public void testAutoBoxing() {
        Integer i = 1;
        int j = 1;
        int index = 10000000;
        long start = System.currentTimeMillis();
        while (index > 0) {
            if (i == index) {
                break;
            }
            index--;
        }
        long end = System.currentTimeMillis();
        System.out.println("expend：" + (end - start) + "ms");

        index = 10000000;
        start = end;

        while (index > 0) {
            if (i == index) {
                break;
            }
            index--;
        }
        end = System.currentTimeMillis();
        System.out.println("expend：" + (end - start) + "ms");
    }

    @Test
    public void testFreemarker() {
        Template template = FreeMarkerUtil.getTemplate("templates/steam.ftl", CommonTest.class);
        Map<String, Object> objects = new HashMap<String, Object>();
        objects.put("bootstrap_servers", "10.105.237.187:9092");
        objects.put("topics", "topic_keel_steam");
        objects.put("group_id", "steam");
        objects.put("autogenerate_column_names", "false");
        objects.put("columns1", Arrays.asList("logtime", "hostname", "modulename", "gameid", "serverid", "logid", "logtype"));

        Map<String, String> converts1 = new LinkedHashMap<String, String>();
        converts1.put("logtime", "date");
        converts1.put("gameid", "integer");
        converts1.put("serverid", "integer");
        objects.put("converts1", converts1);

        objects.put("logtype", "currency");
        objects.put("columns2", Arrays.asList("logtime", "hostname", "modulename", "gameid", "serverid", "logid", "logtype", "platform", "channel", "mac", "userid", "roleid", "rolelevel", "currencytype", "reason", "changenum", "leftnum"));

        Map<String, String> converts2 = new LinkedHashMap<String, String>();
        converts2.put("logtime", "date");
        converts2.put("gameid", "integer");
        converts2.put("serverid", "integer");
        converts2.put("platform", "integer");
        converts2.put("rolelevel", "integer");
        converts2.put("currencytype", "integer");
        converts2.put("reason", "integer");
        converts2.put("changenum", "integer");
        converts2.put("leftnum", "integer");
        objects.put("converts2", converts2);

        objects.put("removeFields", Arrays.asList("hostname", "modulename", "logid", "mac"));
        objects.put("hosts", Arrays.asList("10.105.10.94:9200", "10.105.48.245:9200"));
        objects.put("index", "currency-keel-%{gameid}-%{date}");
        objects.put("template_name", "currency");
        objects.put("routing", "%{userid}");

        System.out.println(FreeMarkerUtil.render(template, objects));
    }

    /**
     * 实际比较才发现String.replace还是比StringUtils.replace效率要高；
     * 只不过StringUtils.replace可以指定最大替换数量，扩展性比较好
     */
    @Test
    public void testReplace() {
        long start = System.currentTimeMillis();
        String s = "zzhzhhzhfavzlzloafzzzhzhhzhfavzlzloafzafzzzzhzhhzhfavzlzloafzafzztfevvazef;fadslkazlffqffzdfea" +
                "fglg.ag/bvnvnaglzozzzhzhhzhfzzhzhhzhfavzlzloafzafzztfevvazef;fadslkazlffqffzdfeafglg.ag/bvnvvnaglzozzzzzzdsfadfadfzfzf,f,,,ferfzzzzdfe" +
                "wgtzgzddgrdgaavzlzloafzafzztfevvazef;fadslkazlffqffzdfeafglg.ag/bvnvnaglzozzzzzzdsfadfadfzfzf,f,,,ferfzzzzdf" +
                "wgtzgzddgrdgaavzlzloafzafzztfevvazef;fadslkazlffqffzdfeafglg.ag/bvnvnaglzozzzzzzdsfadfadfzfzf,f,,,ferfzzzzdf" +
                "ewgtzgzddgrdgazzzzdsfadfadfzfzf,f,,,ferfzzzzdfewgtzgzddgrdgazzhzhhzhfavzlzloafzafzztfevvazef;fadslkazlffqffzdfeaf" +
                "aglzozzzzzzzhzhhzhfavzlzloafzafzztfevvazef;fadslkazlffqffzdfeafglg.ag/bvnvnaglzozzzzzzdsfadfadfzfzf,f,,,ferfzzzzdf" +
                "ewgtzgzddgrdgazzzzdsfadfadfzfzf,f,,,ferfzzzzdfewgtzgzddgrdgazzhzhhzhfavzlzloafzafzztfevvazef;fadslkazlffqffzdfeaf" +
                "ewgtzgzddgrdgazzzzdsfadfadfzfzf,f,,,ferfzzzzdfewgtzgzddgrdgazzhzhhzhfavzlzloafzafzztfevvazef;fadslkazlffqffzdfeaf" +
                "glg.ag/bvnvnaglzozzzzzzdsfadfadfzfzf,f,,,ferfzzzzdfewgtzgzddgrdgatfevvazef;fadslkazlffqffzdfeafglg.ag/bvnvn" +
                "glg.ag/bvnvnaglzozzzzzzdsfadfadfzfzf,f,,,ferfzzzzdfewgtzgzddgrdgatfevvazef;fadslkazlffqffzdfeafglg.ag/bvnvn" +
                "ewgtzgzddgrdgazzzzdsfadfadfzfzf,f,,,ferfzzzzdfewgtzgzddgrdgazzhzhhzhfavzlzloafzafzztfevvazef;fadslkazlffqffzdfeaf" +
                "glg.ag/bvnvnaglzozzzzzzdsfadfadfzfzf,f,,,ferfzzzzdfewgtzgzddgrdgatfevvazef;fadslkazlffqffzdfeafglg.ag/bvnvn" +
                "glg.ag/bvnvnaglzozzzzzzdsfadfadfzfzf,f,,,ferfzzzzdfewgtzgzddgrdgatfevvazef;fadslkazlffqffzdfeafglg.ag/bvnvn" +
                "aglzozzzzzzzhzhhzhfavzlzloafzafzztfevvazef;fadslkazlffqffzdfeafglg.ag/bvnvnaglzozzzzzzdsfadfadfzfzf,f,,,ferfzzzzdf" +
                "aglzozzzzzzzhzhhzhfavzlzloafzafzztfevvazef;fadslkazlffqffzdfeafglg.ag/bvnvnaglzozzzzzzdsfadfadfzfzf,f,,,ferfzzzzdf" +
                "ewgtzgzddgrdgazdsfadfadfzfzf,f,,,ferfzzzzdfewgtzgzddgrdgaafzztfevvazef;fadslkazlffqffzdfeafglg.ag/bvnvnaglzo" +
                "zzzzzzdsfadfadfzfzf,f,,,ferfzzzzdfewgtzgzddgrdga";
        s = s.replace("fadfz", "hello world!");
        s = StringUtils.replace(s, "fadfz", "hello world!");
        System.out.println(s);
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void testObjects() {
        // 使用原生的equals方法有可能抛空指针异常
//        Object object = null;
//        object.equals("hello");
        boolean equalsResult = Objects.equals(null, null);
        System.out.println(equalsResult);

        int hashCodeResult = Objects.hashCode("hello");
        System.out.println(hashCodeResult);

        String toStringResult = Objects.toString(null);
        System.out.println(toStringResult);

        boolean isNullResult = Objects.isNull(null);
        System.out.println(isNullResult);
    }

    @Test
    public void testSet2Array() {
        Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c"));
        String[] array = set.toArray(new String[0]);

        for (String string : array) {
            System.out.println(string);
        }
    }

    @Test
    public void testRandomInt() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtils.nextInt(30));
        }
    }
}
