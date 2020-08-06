package com.sz.test.singleton;

//单例设计模式：饿汉式
public class SingleTon1 {
    //一加载就实例化
    private static final SingleTon1 singleTon1 = new SingleTon1();
    //创建私有构造方法
    private SingleTon1(){
    }
    //创建获取实例对象的方法,只能是静态的
    public static SingleTon1 getSingleTon1(){
        return singleTon1;
    }
}
