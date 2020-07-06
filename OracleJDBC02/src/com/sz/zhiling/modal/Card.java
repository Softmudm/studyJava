package com.sz.zhiling.modal;

public class Card {
    private String cardid;//卡号
    private String cardpwd;//卡密码
    private Float balance;//卡余额
    private String masterid;//卡拥有者id

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

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getMasterid() {
        return masterid;
    }

    public void setMasterid(String masterid) {
        this.masterid = masterid;
    }

    public Card() {
    }

    public Card(String cardid, String cardpwd, Float balance, String masterid) {
        this.cardid = cardid;
        this.cardpwd = cardpwd;
        this.balance = balance;
        this.masterid = masterid;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardid='" + cardid + '\'' +
                ", cardpwd='" + cardpwd + '\'' +
                ", balance=" + balance +
                ", masterid='" + masterid + '\'' +
                '}';
    }
}
