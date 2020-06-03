package com.sz.zhiling.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date类和SimpleDateFormat类
 */
public class DateTest {
    public static void main(String[] args){
        long time = System.currentTimeMillis();
        System.out.println(time);
        Date date1 = new Date(time);
        System.out.println(date1);

        Date date = new Date();//本质上也是调用系统的currentTimeMillis()方法获取当前时间；
        System.out.println(date.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");
        System.out.println(sdf.format(date));
    }
}
