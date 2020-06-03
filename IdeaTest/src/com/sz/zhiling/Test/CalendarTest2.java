package com.sz.zhiling.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalendarTest2 {

    private static void showHolidays(int year) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date =null;
        try {
            date = simpleDateFormat.parse(year+"-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);//获取这一年的第一个星期日
        int inday = calendar.get(Calendar.DAY_OF_WEEK);
        while(inday != 1){
            calendar.add(Calendar.DATE,1);
            inday = calendar.get(Calendar.DAY_OF_WEEK);
        }
        int m = 0;
        while(year == calendar.get(Calendar.YEAR)){//判断是不是这一年
            System.out.print((calendar.get(Calendar.MONTH)+1)+"月"+calendar.get(Calendar.DATE)+"日\t");
            calendar.add(Calendar.DATE,7);
            if(calendar.get(Calendar.MONTH)!=m){//按月换行
                System.out.println();
                m = calendar.get(Calendar.MONTH);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year;
        while(true){
            try{
                System.out.println("请输入年份(1900~9999):");
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
        showHolidays(year);
    }
}
