/*
 * Copyright (c) 2020.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Talk is cheap,show me the code.
 *
 * @Description:
 * @Author: X2
 * @Date: 2020/6/23 18:38
 */
public class NewDate {

    @Test
    public void test01() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 9, 29, 10, 50, 32, 22);
        System.out.println(localDateTime1);

        localDateTime.plusYears(5);
        localDateTime.minusHours(3);
        localDateTime.getDayOfMonth();
    }

    @Test
    public void test02() {
        Instant now = Instant.now();//默认获取UTC时区
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(now + "北京:" + offsetDateTime);
        System.out.println(now.toEpochMilli());
        System.out.println(Instant.ofEpochMilli(60));

    }

    @Test
    public void test03() throws InterruptedException {
        Instant instant = Instant.now();
        Thread.sleep(1000);
        Instant instant1 = Instant.now();
        System.out.println(Duration.between(instant, instant1).toMillis());

        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(1998, 3, 29);
        System.out.println(Period.between(localDate, localDate1));
    }

    @Test
    public void test04() {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);//指定几号
        System.out.println(localDateTime1);

        LocalDateTime with = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(with);

        localDateTime.with((l)->{
            LocalDateTime localDateTime2 = (LocalDateTime) l;
            DayOfWeek dayOfWeek = localDateTime2.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return localDateTime2.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)){
                return localDateTime2.plusDays(2);
            }else {
                return localDateTime2.plusDays(1);
            }
        });

    }


    @Test
    public void test05() throws InterruptedException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String strDate = localDateTime.format(dateTimeFormatter);
        String strDate2 = dateTimeFormatter1.format(localDateTime);
        System.out.println(strDate);
        System.out.println(strDate2);

    }

    @Test
    public void test06() throws InterruptedException {
        LocalDateTime turkey = LocalDateTime.now(ZoneId.of("Turkey"));
        ZonedDateTime zdt = turkey.atZone(ZoneId.of("Turkey"));
        System.out.println(turkey);
        System.out.println(zdt);

    }

}
