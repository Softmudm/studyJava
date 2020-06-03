package com.sz.zhiling.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *2020-6-20日历练习
 */

public class CalendarTest {
    public static void showCalendar(int year,int month) {
        Calendar calendar = Calendar.getInstance();//使用默认时区和区域设置获取日历。
        int nyear = calendar.get(calendar.YEAR);//获得今天所属年份
        int nmonth = (calendar.get(calendar.MONTH)+1);//获得今天所属月份
        int nday = calendar.get(calendar.DAY_OF_MONTH);//获得今天所在这个月的日
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String showDay = "1970-01-01";
        if(month<10){//这里调整年月日格式，小于10月的月份前要加0，不然getTime()方法得出的是错误的。
            showDay = year+"-0"+month+"-01";//输入的那一个月
        }else{
            showDay = year+"-"+month+"-01";
        }
        long countDay = 1L;
        try{
            Date showDate = simpleDateFormat.parse(showDay);
            countDay += showDate.getTime()/(1000*60*60*24);//转化为毫秒数，用来计算和1970-01-01的天数
            System.out.println(showDate.getTime());
            System.out.println(countDay);
        }catch(ParseException ex){
            ex.printStackTrace();
        }
        int space = (int)(countDay+4)%7;//计算这个月日历前要空几格
        int monthDays = 30;//计算输入月份的天数
        if(month == 2){
            if((year%100!=0 && year%4==0) || (year%400==0)){
                monthDays = 29;
            }else{
                monthDays = 28;
            }
        }else if(month==2 || month==4 || month==6 || month==9 || month==11){
            monthDays = 30;
        }else{
            monthDays = 31;
        }
        System.out.println("========="+year+"年"+month+"月=========");
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for(int j=0;j<space;j++){
            System.out.print("\t");
        }
        for(int i=0;i<monthDays;i++){
            countDay++;
            if((countDay+4)%7==0){//判断是否换行
                if(nyear==year && nmonth==month && nday==i+1){//判断是不是今天,如果是输出要加[]
                    System.out.print("["+(i+1)+"]"+"\n");
                }else{
                    System.out.print((i+1)+"\n");
                }
            }else{
                if(nyear==year && nmonth==month && nday==i+1){
                    System.out.print("["+(i+1)+"]"+"\t");
                }else{
                    System.out.print((i+1)+"\t");
                }
            }
        }
        System.out.println();
        System.out.println("==========================");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year,month;
        while(true){
            try{
                System.out.println("请输入年份(1970~9999):");
                year = sc.nextInt();
                if(year>=1970 && year<=9999){
                    break;
                }else{
                    System.out.println("请按要求输入年份!");
                }
            }catch(InputMismatchException ex){
                System.out.println("请按要求输入年份!");
                sc.next();
            }
        }
        while(true){
            try{
                System.out.println("请输入月份(1~12):");
                month = sc.nextInt();
                if(month>=1 && month<=12){
                    break;
                }else{
                    System.out.println("请按要求输入月份!");
                }
            }catch(InputMismatchException ex){
                System.out.println("请按要求输入月份!");
                sc.next();
            }
        }
        showCalendar(year,month);
    }
}
