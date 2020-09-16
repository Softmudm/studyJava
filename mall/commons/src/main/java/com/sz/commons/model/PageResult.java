package com.sz.commons.model;

import java.util.List;

//分页结果封装类
public class PageResult<T> {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalPage;
    private Long totalNum;
    private List<T> data;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public PageResult() {
    }

    public PageResult(Integer pageIndex, Integer pageSize, Integer totalPage, Long totalNum, List<T> data) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalNum = totalNum;
        this.data = data;
    }
}
