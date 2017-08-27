package com.ustbyjy.lang;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/4/13
 * Time: 14:05
 */
public class CommonLangTest {
    /**
     * 原生JDK比较字符串相等时，要求两个字符串必须是非空，否则抛出空指针异常
     */
    @Test(expected = NullPointerException.class)
    public void testNullStringEquals() {
        String s1 = null;
        String s2 = null;
        System.out.println(s1.equals(s2));
    }

    @Test
    public void testStringUtils() {
        // Common Lang 字符串工具比较字符串相等时，入参可为null，null 和 null比较返回true
        String s1 = null;
        String s2 = null;
        System.out.println(StringUtils.equals(s1, s2));

        System.out.println("=============================== 华丽的分割线 =================================");

        // 处理空字符串
        String s3 = StringUtils.defaultString(null);
        String s4 = StringUtils.defaultString(null, "空");
        String s5 = StringUtils.defaultIfEmpty("", "空");
        String s6 = StringUtils.defaultIfBlank("   ", "空");
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);

        System.out.println("=============================== 华丽的分割线 =================================");

        // JDK原生Character类判断是不是空白字符
        boolean b1 = Character.isWhitespace(' ');
        boolean b2 = Character.isWhitespace('x');
        System.out.println(b1);
        System.out.println(b2);

        System.out.println("=============================== 华丽的分割线 =================================");

        // 使用原生StringBuilder翻转字符串，但参数为null时，返回null
        String s7 = StringUtils.reverse(null);
        String s8 = StringUtils.reverse("");
        String s9 = StringUtils.reverse("abc");
        String s10 = StringUtils.reverseDelimited("x.y.z", '.');
        System.out.println(s7);
        System.out.println(s8);
        System.out.println(s9);
        System.out.println(s10);

        System.out.println("=============================== 华丽的分割线 =================================");

        // 得到省略字符串
        String s11 = StringUtils.abbreviate("hello world", 4);
        String s12 = StringUtils.abbreviate("hello world", 6);
        System.out.println(s11);
        System.out.println(s12);

        System.out.println("=============================== 华丽的分割线 =================================");

        // 比较字符串的不同
        String s13 = StringUtils.difference("hello", "hallo");
        String s14 = StringUtils.difference("world", "world");
        System.out.println(s13);
        System.out.println(s14);

        System.out.println("=============================== 华丽的分割线 =================================");

        // 比较字符串从哪一位开始不同
        int index1 = StringUtils.indexOfDifference("", "");
        int index2 = StringUtils.indexOfDifference("", "abc");
        int index3 = StringUtils.indexOfDifference("abc", "");
        int index4 = StringUtils.indexOfDifference("hello", "hallo");
        int index5 = StringUtils.indexOfDifference("world", "world");
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);
        System.out.println(index5);

        System.out.println("=============================== 华丽的分割线 =================================");

        // 获取两个字符串的共同前缀
        String s15 = StringUtils.getCommonPrefix(new String[]{"", ""});
        String s16 = StringUtils.getCommonPrefix(new String[]{"", "abc"});
        String s17 = StringUtils.getCommonPrefix(new String[]{"abc", ""});
        String s18 = StringUtils.getCommonPrefix(new String[]{"abc", "abc"});
        String s19 = StringUtils.getCommonPrefix(new String[]{"abc xoy", "abc opq"});
        System.out.println(s15);
        System.out.println(s16);
        System.out.println(s17);
        System.out.println(s18);
        System.out.println(s19);

        System.out.println("=============================== 华丽的分割线 =================================");

        // 判断是否以多个字符串中的任意一个开头
        boolean b3 = StringUtils.startsWithAny("abc", new String[]{null, "abc", "xyz"});
        System.out.println(b3);
    }


    @Test
    public void testArrayUtils() {
        // 原生Arrays和ArraysUtils打印空数组
        String[] emptyStringArray = ArrayUtils.EMPTY_STRING_ARRAY;
        System.out.println(ArrayUtils.toString(emptyStringArray));
        System.out.println(Arrays.toString(emptyStringArray));

        System.out.println("=============================== 华丽的分割线 =================================");

        // 二维数组 to Map
        Map colorMap = ArrayUtils.toMap(new String[][]{{"RED", "#FF0000"}, {"GREEN", "#00FF00"}, {"BLUE", "#0000FF"}});
        Set<Map.Entry> entrySet = colorMap.entrySet();
        for (Map.Entry entry : entrySet) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }

}
