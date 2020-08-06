package com.sz.test.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class Page<T> {
    private int totalnum;//总条数
    private int totalpage;//总页数
    private int pagesize;//页面条数
    private int pageno;//当前页码
    private Boolean s;//备注信息
    private List<T> data;//查询结果

    public Boolean getS() {
        return s;
    }

    public void setS(Boolean s) {
        this.s = s;
    }

    public int getTotalpage() {
        return totalnum%pagesize==0?totalnum/pagesize:totalnum/pagesize+1;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    public Page(int totalnum, int pagesize, int pageno) {
        this.totalnum = totalnum;
        this.pagesize = pagesize;
        this.pageno = pageno;
    }

    public Page() {
        //this.data=null;
    }

    /**
     * 查询语句分页
     * @param pageno
     * @param pagesize
     * @param sql
     * @param runner
     * @param clazz
     */
    public Page(int pageno, int pagesize, String sql, QueryRunner runner,Class<T> clazz){
        this.pageno = pageno;
        this.pagesize = pagesize;
        String pagesql ="select * from(" +
                "select rownum rn,ttt.* from(" +
                sql
                + ") ttt where rownum<="+pageno*pagesize +
                ") where rn>"+(pageno-1)*pagesize;
        try {
            this.totalnum = Integer.parseInt(String.valueOf(runner.query("select count(*) from ("+sql+")",new ScalarHandler())));
            this.data = runner.query(pagesql,new BeanListHandler<>(clazz));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.totalpage = (totalnum%pagesize)==0 ? (totalnum/pagesize):(totalnum/pagesize)+1;
    }
}
