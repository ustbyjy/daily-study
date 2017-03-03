package com.ustbyjy.time;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ustbyjy
 * Date: 2017/3/3
 * Time: 11:43
 */
public class JodaTimeTest {

    @Test
    public void dateTimeTest() {
        DateTime dateTime = new DateTime();
        System.out.println("Date time: " + dateTime.toString("yyyy-MM-dd HH:mm:ss"));
        // 本月多少号
        int dayOfMonth = dateTime.getDayOfMonth();
        System.out.println("Day of month: " + dayOfMonth);
        // 本年第几月
        int monthOfYear = dateTime.getMonthOfYear();
        System.out.println("Month of year: " + monthOfYear);
        // 获取年份
        int year = dateTime.getYear();
        System.out.println("Year: " + year);

        dateTime = dateTime.plusDays(1);
        dateTime = dateTime.plusHours(1);
        dateTime = dateTime.plusYears(-1);
        System.out.println("Date time: " + dateTime.toString("yyyy-MM-dd HH:mm:ss"));

        DateTime newDateTime = new DateTime(2017, 2, 28, 10, 40, 50, 500);
        System.out.println("New date time: " + newDateTime.toString("yyyy-MM-dd HH:mm:ss"));

        LocalDate localDate = new LocalDate();
        // 计算下个月的第一天的日期
        localDate = localDate.plusMonths(1).dayOfMonth().withMinimumValue();
        System.out.println(localDate);

        DateTime dt = new DateTime();
        // 计算一年前的第二个月的最后一天的日期
        dt = dt.minusYears(1).monthOfYear().setCopy(2).dayOfMonth().withMaximumValue();
        System.out.println(dt);
    }

    @Test
    public void dateTimeWithJDKTest() {
        DateTime dateTime = new DateTime(new Date());
        Date date = dateTime.toDate();
        System.out.println(date);
        Calendar calendar = dateTime.toCalendar(Locale.CHINESE);
        System.out.println(calendar);
    }
}
