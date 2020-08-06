package com.sz.test.singleton;

//单例设计模式：懒汉式
public class SingleTon2 {
    private static final SingleTon2 singleTon2 = null;
    //私有化构造方法
    private SingleTon2(){
    }
    //获取实例化对象的方法
    private static SingleTon2 getSingleTon2(){
        if(singleTon2==null){
            return new SingleTon2();
        }
        return singleTon2;
    }
}
