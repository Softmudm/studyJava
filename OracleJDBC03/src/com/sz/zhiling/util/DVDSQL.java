package com.sz.zhiling.util;

import com.sz.zhiling.modal.DVD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

//数据库操作
public class DVDSQL {
    //创建queryrunner对象(简化sql查询的工具类)
    private static QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
    //增加一张DVD
    public static int addDVD(String dvdName){
        try {
            return qr.update("insert into DVD (dvdid,dvdname) values(sequence_dvd.nextval,?)",dvdName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    //删除一张DVD
    public static int deleteDVD(String dvdName){
        try {
            return qr.update("delete from DVD where dvdname=?",dvdName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    //修改一张DVD
    public static int updateDVD(DVD dvd){
        try {
            return qr.update("update DVD set dvdname=?,state=?,\"DATE\"=to_date(?,'YYYY-mi-dd HH24:mm:ss'),\"TIME\"=? where dvdid=?",dvd.getDvdname(),dvd.getState(),dvd.getDate(),dvd.getTime(),dvd.getDvdid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    //查询所有的DVD
    public static List<DVD> selectAllDVD(){
        try {
            return qr.query("select * from DVD",new BeanListHandler<>(DVD.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //根据名称查询DVD
    public static DVD selectDVDByName(String DVDName){
        try {
            return qr.query("select * from DVD where dvdname=?",new BeanHandler<>(DVD.class),DVDName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
