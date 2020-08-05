package com.sz.zhiling.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    //获取连接池
    public static ComboPooledDataSource getDataSource(){
        return comboPooledDataSource;
    }
}
