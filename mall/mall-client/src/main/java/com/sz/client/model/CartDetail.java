package com.sz.client.model;

import java.math.BigDecimal;

public class CartDetail extends Product {
    Integer detailNum;
    BigDecimal detailCount;

    public Integer getDetailNum() {
        return detailNum;
    }

    public void setDetailNum(Integer detailNum) {
        this.detailNum = detailNum;
        getDetailCount();
    }

    public BigDecimal getDetailCount() {
        this.detailCount = this.getProductPrice().divide(new BigDecimal(detailNum));
        return detailCount;
    }

    public void setDetailCount(BigDecimal detailCount) {
        this.detailCount = detailCount;
    }

    public CartDetail() {
    }

    public CartDetail(Integer detailNum, BigDecimal detailCount) {
        this.detailNum = detailNum;
        this.detailCount = detailCount;
    }
    public CartDetail(Integer detailNum, BigDecimal detailCount ,Product product) {
        super(product.getProductId(),product.getProductName(),product.getProductPrice(),product.getProductImg(),product.getDescription());
        this.detailNum = detailNum;
        this.detailCount = detailCount;
        getDetailCount();
    }
}
