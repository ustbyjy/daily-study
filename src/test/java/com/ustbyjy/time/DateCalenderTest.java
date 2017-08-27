package com.ustbyjy.time;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017-05-07
 * Time: 21:57
 */
public class DateCalenderTest {

    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DAY_OF_YEAR, 1);

        System.out.println(date);
        System.out.println(calendar);
    }
}
