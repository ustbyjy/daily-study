package com.ustbyjy.time;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Test
    public void testString2Date() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'");

        Date date = sdf.parse("2017-09-04T");
        System.out.println(date.toString());

        String strDate = sdf.format(date);
        System.out.println(strDate);

        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = sdf.parse("2018-01-05");

        System.out.println(date);
    }

}
