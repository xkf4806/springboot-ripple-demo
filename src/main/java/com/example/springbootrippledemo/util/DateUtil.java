package com.example.springbootrippledemo.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    /**
     * 转换日期为指定格式的字符串
     * @author dong-wang5@hnair.com
     * @date 2017-10-24 15:09:27
     * @params
     * @param d : 转换日期
     * @param format : 转换工具
     * @return java.lang.String
     */
    public static String format(Date d, String format) {
        if (d == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(d);
        return s;
    }

    /**
     * 将字符串类型的日期按指定格式转换成日期类型
     * @author dong-wang5@hnair.com
     * @date 2017-10-24 16:18:14
     * @params
     * @param s : 转换前字符串
     * @param format : 转换工具
     * @return java.util.Date
     * @throws
     */
    public static Date parseDate(String s,String format) {
        if (StringUtils.isBlank(s)){
            return null;
        }
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            d = sdf.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public static Date addDays(Date date, long days) {
        LocalDateTime ldt = toLocalDateTime(date);
        return toDate(ldt.plusDays(days));
    }

    private static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    private static Date toDate(LocalDateTime ldt) {
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }

}