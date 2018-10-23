package cn.mafangui.hotel.utils;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MyDateTimeFormat {
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    Calendar calendar = Calendar.getInstance();
    String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

    /**
     * 获得年份
     * @param date
     * @return
     */
    public int getYear(Date date) {
        simpleDateFormat.applyPattern("yyyy");
        return Integer.parseInt(simpleDateFormat.format(date));
    }

    /**
     * 获得月份
     * @param date
     * @return
     */
    public int getMonth(Date date) {
        simpleDateFormat.applyPattern("MM");
        return Integer.parseInt(simpleDateFormat.format(date));
    }

    /**
     * 获得日子
     * @param date
     * @return
     */
    public int getDay(Date date){
        simpleDateFormat.applyPattern("dd");
        return Integer.parseInt(simpleDateFormat.format(date));
    }

    /**
     * 返回某天是周几
     * @param date
     * @return
     */
    public String getWeek(Date date){
        simpleDateFormat.applyPattern("yyyy-MM-dd");
        calendar.setTime(date);
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) w = 0;
        return weekDays[w];
    }


    /**
     * 格式化为年份
     * @param date
     * @return
     */
    public String formatYear(Date date){
        simpleDateFormat.applyPattern("yyyy");
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化为年月
     * @param date
     * @return
     */
    public String formatMonth(Date date){
        simpleDateFormat.applyPattern("yyyy-MM");
        return simpleDateFormat.format(date);
    }
    /**
     * 格式化为年月日
     * @param date
     * @return
     */
    public String formatDay(Date date){
        simpleDateFormat.applyPattern("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
    /**
     * 格式化为年月日时分
     * @param date
     * @return
     */
    public String formatMinute(Date date){
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(date);
    }
    /**
     * 格式化为年月日时分秒
     * @param date
     * @return
     */
    public String formatSecond(Date date){
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
