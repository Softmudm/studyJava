package com.sz.wx.util;

import java.util.List;

public class PageResult<T> {
    private int pageNo;
    private int pageSize;
    private int totalPage;
    private int totalNum;
    private List<T> list;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
        this.totalPage = (totalNum%pageSize==0)?(totalNum/pageSize):(totalNum/pageSize+1);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageResult() {
    }

    public PageResult(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PageResult(int pageNo, int pageSize, List<T> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.list = list;
    }

    public PageResult(int pageNo, int pageSize, int totalPage, int totalNum, List<T> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalNum = totalNum;
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalNum=" + totalNum +
                ", list=" + list +
                '}';
    }
}
