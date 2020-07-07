package com.sz.zhiling.controller;

import com.sz.zhiling.modal.Card;
import com.sz.zhiling.util.OracleJDBC;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class ATMManager {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        // TODO Auto-generated method stub
        while (true) {
            System.out.println("=======ATM登陆界面=======");
            System.out.println("请输入账号:");
            String loginId = sc.next();
            System.out.println("请输入密码:");
            String loginPassword = sc.next();
            Card cd = login(loginId, loginPassword);
            if (cd != null) {
                System.out.println("登陆成功!");
                while (true) {
                    boolean jumpFlag = false;
                    System.out.println("=======ATM功能界面=======");
                    System.out.println("\t1.查看余额");
                    System.out.println("\t2.修改密码");
                    System.out.println("\t3.存款");
                    System.out.println("\t4.取款");
                    System.out.println("\t5.转账");
                    System.out.println("\t6.注销");
                    System.out.println("\t7.退出");
                    System.out.println("======================");
                    System.out.println("请输入操作序号:");
                    String choose = sc.next();
                    switch (choose) {
                        case "1":
                            showMoney(cd);
                            break;
                        case "2":
                            updatePsw(cd);
                            jumpFlag = true;
                            break;
                        case "3":
                            saveMoney(cd);
                            break;
                        case "4":
                            takeMoney(cd);
                            break;
                        case "5":
                            turnMoney(cd);
                            break;
                        case "6":
                            jumpFlag = true;
                            break;
                        case "7":
                            System.out.println("退出成功!");
                            System.exit(0);
                        default:
                            System.out.println("输入错误，请输入正确序号(1~6)!");
                    }
                    if (jumpFlag) {
                        break;
                    }
                }
            } else {
                System.out.println("账号和密码不匹配，请重新输入!");
            }
        }
    }

    //登陆方法，返回null登陆失败。
    private static Card login(String loginId, String loginPassword) {
        // TODO Auto-generated method stub
        String sql = "select * from BANKCARD where cardid=? and cardpwd=?";
        List<Card> list = OracleJDBC.DQL(Card.class,sql,loginId,loginPassword);
        if(list.size()!=0){
            return list.get(0);
        }else{
            return null;
        }
    }

    //查看余额
    private static void showMoney(Card cd) {
        // TODO Auto-generated method stub
        System.out.println("=========查看余额=========");
        System.out.println(cd.getMasterid() + "您好，您的余额为:" + cd.getBalance());
    }

    //修改密码
    private static void updatePsw(Card cd) {
        // TODO Auto-generated method stub
        while (true) {
            System.out.println("=========修改密码=========");
            System.out.println("请输入原密码:");
            String oldPsw = sc.next();
            if (oldPsw.equals(cd.getCardpwd())) {
                while (true) {
                    System.out.println("请输入新密码:");
                    String newPsw1 = sc.next();
                    System.out.println("请确认新密码:");
                    String newPsw2 = sc.next();
                    if (newPsw1.equals(newPsw2)) {
                        String cardid = cd.getCardid();
                        String sql = "update BANKCARD set cardpwd=? where cardid=?";
                        if(OracleJDBC.DML(sql,newPsw1,cardid)>0){
                            System.out.println("密码修改成功!请重新登陆!");
                        }else{
                            System.out.println("密码修改失败!请联系管理员!");
                        }
                        break;
                    } else {
                        System.out.println("两次密码不一致，请重新输入!");
                    }
                }
                break;
            } else {
                System.out.println("原密码错误，请重新输入!");
            }
        }
    }

    //存款
    private static void saveMoney(Card cd) {
        // TODO Auto-generated method stub
        System.out.println("=========存款=========");
        System.out.println("请输入存款金额:");
        try {
            float savemoney = sc.nextFloat();
            if (savemoney > 0) {
                String sql = "update BANKCARD set balance=? where cardid=?";
                if(OracleJDBC.DML(sql,(cd.getBalance() + savemoney),cd.getCardid())>0){
                    cd.setBalance(cd.getBalance() + savemoney);
                    System.out.println("存款" + savemoney + "成功!您的账户余额为:" + cd.getBalance());
                }else {
                    System.out.println("存款失败!请联系管理员!");
                }
            } else {
                System.out.println("存款金额必须为正数!");
            }
        } catch (InputMismatchException ex) {
            System.out.println("金额只能输入数字!");
            sc.next();
        }
    }

    //取款
    private static void takeMoney(Card cd) {
        // TODO Auto-generated method stub
        System.out.println("=========取款=========");
        System.out.println("请输入取款金额:");
        try {
            float takemoney = sc.nextFloat();
            if (takemoney > 0) {
                float countmoney = cd.getBalance() - takemoney;
                if (countmoney >= 0) {
                    String sql = "update BANKCARD set balance=? where cardid=?";
                    if(OracleJDBC.DML(sql,countmoney,cd.getCardid())>0){
                        cd.setBalance(countmoney);
                        System.out.println("取款" + takemoney + "成功!您的账户余额为:" + cd.getBalance());
                    }else{
                        System.out.println("取款失败!请联系管理员!");
                    }
                } else {
                    System.out.println("余额不足，取款失败!");
                }
            } else {
                System.out.println("取款金额必须为正数!");
            }
        } catch (InputMismatchException ex) {
            System.out.println("金额只能输入数字!");
            sc.next();
        }
    }

    //转账
    private static void turnMoney(Card cd) {
        // TODO Auto-generated method stub
        System.out.println("=========转账=========");
        System.out.println("请输入对方账户:");
        String turnid = sc.next();
        String ssql = "select * from BANKCARD where cardid=?";
        Card cd2 = null;
        boolean flag = false;
        if(!cd.getCardid().equals(turnid)){
            List<Card> list = OracleJDBC.DQL(Card.class,ssql,turnid);
            if(list.size()==1){
                cd2 = list.get(0);
                flag = true;
            }
        }else{
            System.out.println("不能自己转账给自己!");
            return;
        }
        Connection connection = OracleJDBC.getConnection();
        PreparedStatement ps = null;
        if (flag) {
            System.out.println("请输入转账金额:");
            try {
                float turnmoney = sc.nextFloat();
                if (turnmoney > 0) {
                    float countmoney = (cd.getBalance() - turnmoney);
                    if (countmoney >= 0) {
                        String usql = "update BANKCARD set balance=? where cardid=?";
                        try {
                            //关闭事务自动提交
                            connection.setAutoCommit(false);
                            ps = connection.prepareStatement(usql);
                            ps.setFloat(1,countmoney);
                            ps.setString(2,cd.getCardid());
                            //添加到一个批次
                            ps.addBatch();
                            //清除参数
                            ps.clearParameters();
                            ps.setFloat(1,cd2.getBalance()+turnmoney);
                            ps.setString(2,cd2.getCardid());
                            ps.addBatch();
                            //批次执行数据库操作
                            ps.executeBatch();
                            //提交事务
                            connection.commit();
                            cd.setBalance(countmoney);
                            System.out.println("转账成功，余额为" + cd.getBalance());
                        } catch (SQLException throwables) {
                            try {
                                connection.rollback();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            System.out.println("转账失败，请联系管理员!");
                            throwables.printStackTrace();
                        }
                        //OracleJDBC.DML1(usql,countmoney,cd.getCardid())==1&&OracleJDBC.DML1(usql,(cd2.getBalance()+turnmoney),cd2.getCardid())==1){
                    } else {
                        System.out.println("余额不足，转账失败!");
                    }
                } else {
                    System.out.println("转账金额必须为正数!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("金额只能输入数字!");
                sc.next();
            }
        } else {
            System.out.println("输入账户不存在!");
        }
    }
}