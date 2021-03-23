package com.example.shiro.common.utils;

import com.alibaba.fastjson.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 获取当前日期格式化
     *
     * @param format 需要返回的日期格式  yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDateNow(String format) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * @param date   原日期
     * @param day    增加天数
     * @param format 需要返回的日期格式  yyyy-MM-dd HH:mm:ss
     * @return 增加后的天数
     */
    public static String getSomeDay(String date, int day, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        DateFormat format1 = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(format1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.add(Calendar.DATE, day);
        return sdf.format(calendar.getTime());
    }

    /**
     * @param date   原日期
     * @param day    增加天数
     * @param format 需要返回的日期格式  yyyy-MM-dd HH:mm:ss
     * @return 增加后的天数
     */
    public static String getSomeDay(Date date, int day, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return sdf.format(calendar.getTime());
    }

    /**
     * 根据天加日期
     * @param date   原日期
     * @param day    增加天数
     * @return 增加后的天数
     */
    public static Date getSomeDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     *根据月加日期
     * @param date 原日期
     * @param month 加多少月
     * @return 返回增加后的日期
     */
    public static Date addMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }


    /**
     * 根据string类型的日期转换成另外一个类型的String类型
     * @param date   传入的日期
     * @param format 格式  yyyy-MM-dd HH:mm:ss
     * @return 返回格式化后的日期
     */
    public static String getFormatDate(String date, String format) {

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date2 = null;
        try {
            date2 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(date2);
    }

    /**
     * 根据日期字符串转换成日期
     * @param dateStr 日期字符串
     * @param format 格式  yyyy-MM-dd HH:mm:ss
     * @return Date
     */
    public static Date str2Date(String dateStr, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        try {
            Date date = simpleDateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 日期类型转String
     *
     * @param date   传入的日期
     * @param format 格式  yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2Str(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }


    /**
     * 通过时间秒毫秒数判断两个时间的间隔 date2-date1
     * @param date1
     * @param date2
     * @return 返回天数
     */
    public static int twoDate(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }


    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param format yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }
    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 获取苏宁的当前日期
     * @return
     */
    public static String getSMDateStr(){
        String resMes = HttpRequestsUtils.sendPost("http://quan.suning.com/getSysTime.do","");
        JSONObject jsonObject = JSONObject.parseObject(resMes);
        return jsonObject.getString("sysTime2");
    }

    /**
     * 获取苏宁的当前日期
     * @return
     */
    public static Date getSNDate(){
        String resMes = HttpRequestsUtils.sendPost("http://quan.suning.com/getSysTime.do","");
        JSONObject jsonObject = JSONObject.parseObject(resMes);
        return str2Date(jsonObject.getString("sysTime2"),"yyyy-MM-dd HH:mm:ss");
    }


}
