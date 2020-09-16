package com.sz.order.model;

import java.math.BigDecimal;

public class CartDetail extends Product{
    private Integer detailNum = 0;
    private BigDecimal detailCount = new BigDecimal(0);

    public Integer getDetailNum() {
        return detailNum;
    }

    public void setDetailNum(Integer detailNum) {
        this.detailNum = detailNum;
        getDetailCount();
    }

    public BigDecimal getDetailCount() {
        BigDecimal bd = this.getProductPrice();
        if(this.getProductPrice()==null){
            bd = new BigDecimal(0);
        }
        BigDecimal dc = bd.multiply(new BigDecimal(detailNum));
        detailCount = dc;
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
