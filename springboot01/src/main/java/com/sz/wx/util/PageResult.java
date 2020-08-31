package com.sz.wx.util;

import java.util.List;

public class PageResult<T> {
    private int pageIndex;
    private int pageSize;
    private long totalNum;
    private int totalPage;
    private List<T> list;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageResult() {
    }

    public PageResult(int pageIndex, int pageSize, long totalNum, int totalPage, List<T> list) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = totalPage;
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalNum=" + totalNum +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
