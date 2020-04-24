package com.qf.util;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateUtil {
    public static Date stringToDate(String strDate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(strDate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Date(date.getTime());
    }

    public static String dateToString(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String strDate = null;
        try{
            strDate = sdf.format(date);
        }catch (Exception e){
            e.printStackTrace();
        }

        return strDate;
    }

    public static Timestamp strToTimestamp(String dateStr){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = null;
        try {
            date = sdf.parse(dateStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(date);
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(new java.util.Date(System.currentTimeMillis()));

        return timestamp;
    }

    public static String timeStampToStr(Timestamp timestamp){

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = df.format(timestamp);
        return str;

    }

}
