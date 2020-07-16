package com.sz.zhiling.entity;

public class BankCard {
    private String cardid;//卡号
    private String cardpwd;//卡密码
    private float balance;//余额
    private String masterid;//卡主人id

    @Override
    public String toString() {
        return "BankCard{" +
                "cardid='" + cardid + '\'' +
                ", cardpwd='" + cardpwd + '\'' +
                ", balance=" + balance +
                ", masterid='" + masterid + '\'' +
                '}';
    }

    public BankCard(String cardid, String cardpwd, float balance, String masterid) {
        this.cardid = cardid;
        this.cardpwd = cardpwd;
        this.balance = balance;
        this.masterid = masterid;
    }

    public BankCard() {
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getCardpwd() {
        return cardpwd;
    }

    public void setCardpwd(String cardpwd) {
        this.cardpwd = cardpwd;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getMasterid() {
        return masterid;
    }

    public void setMasterid(String masterid) {
        this.masterid = masterid;
    }
}
