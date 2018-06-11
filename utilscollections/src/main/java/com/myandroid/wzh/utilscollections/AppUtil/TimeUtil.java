package com.myandroid.wzh.utilscollections.AppUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
*
*@author W.Z.H
*@time 2018/6/11 16:07
*@description
 * 时间工具类
*/

public class TimeUtil {
    static Date datestr;
    static Calendar mCalendar;




    public static String getStringDate() {
        SimpleDateFormat formatter = new
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        return dateString;
    }


    /**
     * 根据毫秒返回时分秒
     *
     * @param time
     * @return
     */
    public static String getFormatHMS(long time) {
        //总秒数
        time = time / 1000;
        //秒
        int s = (int) (time % 60);
        //分
        int m = (int) (time / 60);
        //秒
        int h = (int) (time / 3600);
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    /**
     * 获取年份
     *
     * @return
     */
    public static String getYear() {
        mCalendar = Calendar.getInstance();
        String year = String.valueOf(mCalendar.get(Calendar.YEAR));
        return year;
    }

    /**
     * 获取月份
     *
     * @return
     */
    public static String getMonth() {
        mCalendar = Calendar.getInstance();
        String month = String.valueOf(mCalendar.get(Calendar.MONTH) + 1);
        return month;
    }

    /**
     * 获取天
     *
     * @return
     */
    public static String getDay() {
        mCalendar = Calendar.getInstance();
        String day = String.valueOf(mCalendar.get(Calendar.DAY_OF_MONTH));
        return day;
    }


    /**
     * @param time 时间戳转换成时间
     * @return
     */
    public static String timeslash(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        String times = sdr.format(new Date(lcc));
        return times;
    }

    /**
     * @param time 时间戳转换成中文时间
     * @return
     */
    public static String timeslash1(String time) {
        if(time!=null) {
            SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日");
            @SuppressWarnings("unused")
            long lcc = Long.valueOf(time);
            String times = sdr.format(new Date(lcc));
            return times;
        }
        else {
            return "1990年1月1日";
        }
    }

    /**
     * @param time 时间戳转换成时间
     * @return
     */
    public static String timeslash2(String time) {
        if(time!=null) {
            SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
            @SuppressWarnings("unused")
            long lcc = Long.valueOf(time);
            String times = sdr.format(new Date(lcc));
            return times;
        }
        else {
            return "1990-1-1";
        }
    }
}
