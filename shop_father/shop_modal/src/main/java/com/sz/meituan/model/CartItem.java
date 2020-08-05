package com.sz.meituan.model;


//实体类：购物中每个商品的购买信息；
public class CartItem  extends Food {
    private int num = 0;     //购买单个商品的数量；
    private float xiaoji ;  //购买单个商品的小计=数量*价格；

    public CartItem() {
    }

    public CartItem(int fid, String fname, String ftype, String fshop, float fprice, String fimg, int num, float xiaoji) {
        super(fid, fname, ftype, fshop, fprice, fimg);
        this.num = num;
        this.xiaoji = xiaoji;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getXiaoji() {
        xiaoji = this.num*this.getFprice();
        return xiaoji;
    }

    public void setXiaoji(float xiaoji) {
        this.xiaoji = xiaoji;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "num=" + num +
                ", xiaoji=" + xiaoji +
                '}';
    }
}
