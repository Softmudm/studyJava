package com.sz.zhiling.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    //获取连接池对象
    public static ComboPooledDataSource getDataSource(){
        return comboPooledDataSource;
    }
}
