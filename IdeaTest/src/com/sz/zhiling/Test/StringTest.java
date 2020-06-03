package com.sz.zhiling.Test;

import java.util.Map;
import java.util.Scanner;

/**
 * 核心类库之String练习
 */

public class StringTest {
    public static void main(String[] args){

        String s1 = "123";
        String s2 = new String("123");//如果常量池中没有“123”，那么这句创建了两个对象，一个是常量池对象一个是堆内存对象(前者的拷贝副本)
        System.out.println("=====案例一=====");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        //输出为false,true
        //s1指向方法区中常量池的“123”地址
        //s2指向堆中new出来的的对象地址

        String s3 = "1"+"2"+"3";
        System.out.println("=====案例二=====");
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        //输出为true,true
        //s3中的“1”“2”“3”都是字符串常量"+"号拼接后得到“123”常量

        String s4 = "12";
        s4 = s4+"3";
        System.out.println("=====案例三=====");
        System.out.println(s1 == s4);
        System.out.println(s1.equals(s4));
        //输出为false,true
        //"12"为字符串对象，+“3”操作为前者转StringBuffer对象后调用append方法拼接字符串再转回String，相当于还是指向堆内存对象

        /**
         * StringBuffer常用方法如下
         */
        StringBuffer strb = new StringBuffer("abc");
        System.out.println("初始字符串:"+strb);
        strb.append("def");
        System.out.println("append方法拼接字符串\"def\"后:"+strb);
        char c = strb.charAt(0);
        System.out.println("charAt方法获得第0个字符:"+c);
        strb.setCharAt(0,'z');
        System.out.println("setCharAt方法把第0个字符改为'z'后:"+strb);
        strb.insert(0,"xyopqrst");
        System.out.println("insert方法向第0个位置插入\"xyopqrst\"后:"+strb);
        strb = strb.reverse();
        System.out.println("reverse方法将StringBuffer反向后:"+strb);
        strb.delete(0,5);
        System.out.println("delete删除第0到第4的字符后"+strb);
        strb.replace(0,4,"aaa");
        System.out.println("replace方法将第0个到第4的字符替换成‘aaa’后"+strb);



        //String类进行变化(拼接，删除)时会产生(因为String是固定长度的，变化实际上是指向另一个String对象)
        //StringBuffer类，操作字符串缓冲区，长度是可变的(初始长度16字符，超出自动增加)
        //利用StringBuffer类实现回文数的判断
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer(sc.next());
        System.out.println("输入"+sb);//输入
        StringBuffer sb1 = new StringBuffer(sb);
        System.out.println("拷贝副本"+sb1);//拷贝副本
        sb1.reverse();
        System.out.println("翻转副本"+sb1);//翻转副本
        System.out.println("原来的"+sb);
        System.out.println(sb.toString().equals(sb1.toString())?"是回文数":"不是回文数");
        //注意!!!!这里StringBuffer没有重写equals方法，所以才转成String再比较
    }
}
