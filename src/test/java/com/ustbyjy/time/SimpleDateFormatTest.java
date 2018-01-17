package com.ustbyjy.time;


import org.apache.commons.lang.time.FastDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static FastDateFormat fastSdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    private static ThreadLocal<DateFormat> safeSdf = new ThreadLocal<DateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private static int count = 100;

    public static void main(String[] args) {
//        notSafeTest();
//        safeTest1();
//        safeTest2();
        safeTest3();
    }

    private static void notSafeTest() {
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(sdf.parse("2017-12-13 15:17:27"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

    private static void safeTest1() {
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (sdf) {
                            System.out.println(new Date().toString() + "\t" + sdf.parse("2017-12-13 15:17:27"));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

    private static void safeTest2() {
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(new Date().toString() + "\t" + safeSdf.get().parse("2017-12-13 15:17:27"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

    /**
     * FastDateFormat不支持parse
     */
    private static void safeTest3() {
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(fastSdf.format(new Date()));
                }
            });
            thread.start();
        }
    }
}
