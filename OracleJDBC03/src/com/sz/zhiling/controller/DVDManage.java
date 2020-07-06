package com.sz.zhiling.controller;

import com.sz.zhiling.modal.DVD;
import com.sz.zhiling.util.DVDSQL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DVDManage {
    private static Scanner scanner = new Scanner(System.in);
    //获取选择
    public static String getInput(){
        return scanner.next();
    }
    /*
     * 增加的方法
     */
    public static void addDVD() {
        System.out.println("------->新增DVD");
        System.out.println("请输入新增DVD的名字:");
        String addName = getInput();
        if (DVDSQL.selectDVDByName(addName) == null){
            if(DVDSQL.addDVD(addName)>0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }
        }else{
            System.out.println("添加失败，货架上已有该DVD");
        }
    }
    /*
     * 查看的方法
     */
    public static void searchDVD() {
        System.out.println("------->查看DVD");
        System.out.println("----------------------------------------------");
        System.out.println("序号\t状态\t\t名称\t\t借出日期\t借出次数");
        String state;
        String date;
        for(DVD dvd : DVDSQL.selectAllDVD()) {
            if(dvd.getState() == 1) {
                state = "可 借";
            }else {
                state = "已借出";
            }
            if(dvd.getDate() == null || "".equals(dvd.getState())) {
                date = "\t";
            }else{
                date = dvd.getDate();
            }
            System.out.println(dvd.getDvdid()+"\t"+state+"\t《"+dvd.getDvdname()+"》\t"+date+"\t"+dvd.getTime()+"次");
        }
        System.out.println("----------------------------------------------");
    }
    /*
     * 删除的方法
     */
    public static void deleteDVD() {
        System.out.println("------->删除DVD");
        System.out.println("请输入要删除DVD的名字:");
        String deleteName = getInput();
        DVD dvd = DVDSQL.selectDVDByName(deleteName);
        if(dvd != null){
            if(dvd.getState() == 1){
                DVDSQL.deleteDVD(deleteName);
                System.out.println("删除《"+deleteName+"》成功！");
            }else{
                System.out.println("删除《"+deleteName+"》失败,DVD为借出状态，不允许删除！");
            }
        }else{
            System.out.println("删除《"+deleteName+"》失败,没有找到匹配信息！");
        }
    }
    /*
     * 借出的方法
     */
    public static void lendDVD() {
        System.out.println("------->借出DVD");
        System.out.println("请输入借出DVD的名字:");
        String lendName = getInput();
        DVD dvd = DVDSQL.selectDVDByName(lendName);
        if(dvd != null){
            if(dvd.getState() == 1){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dvd.setState(0);
                dvd.setTime(dvd.getTime()+1);
                dvd.setDate(sdf.format(new Date()));
                DVDSQL.updateDVD(dvd);
                System.out.println("您于"+dvd.getDate()+"借出《"+lendName+"》成功！");
            }else{
                System.out.println("借出《"+lendName+"》失败,DVD为借出状态！");
            }
        }else{
            System.out.println("借出《"+lendName+"》失败,没有找到匹配信息！");
        }
    }
    /*
     * 归还方法
     */
    public static void returnDVD() {
        System.out.println("------->归还DVD");
        System.out.println("请输入要归还DVD的名字:");
        String returnName = getInput();
        DVD dvd = DVDSQL.selectDVDByName(returnName);
        if(dvd != null){
            if(dvd.getState() == 0){
                try{
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date();
                    Date date1 = sdf.parse(dvd.getDate());
                    long day = (date.getTime()-date1.getTime())/(1000*60*60*24);
                    dvd.setState(1);
                    dvd.setDate(null);
                    DVDSQL.updateDVD(dvd);
                    System.out.println("借出日期："+sdf.format(date1));
                    System.out.println("归还日期："+sdf.format(date));
                    System.out.println("天数："+day);
                    System.out.println("需付金额："+day*5+"元！");
                    System.out.println("您于"+sdf.format(date)+"归还《"+returnName+"》成功！");
                }catch(ParseException ex){
                    ex.printStackTrace();
                }
            }else{
                System.out.println("归还《"+returnName+"》失败,DVD为可借状态！");
            }
        }else{
            System.out.println("归还《"+returnName+"》失败,没有找到匹配信息！");
        }
    }
    //总方法
    public static void start(){
        while(true) {
            System.out.println("   DVD管理");
            System.out.println("-------------");
            System.out.println("1.新增\t2.查看");
            System.out.println("3.删除\t4.借出");
            System.out.println("5.归还\t6.退出");
            System.out.println("-------------");
            System.out.println("请选择操作:");
            switch(getInput()) {
                case "1" :
                    addDVD();
                    break;
                case "2" :
                    searchDVD();
                    break;
                case "3" :
                    deleteDVD();
                    break;
                case "4" :
                    lendDVD();
                    break;
                case "5" :
                    returnDVD();
                    break;
                case "6" :
                    System.out.println("谢谢使用！");
                    System.exit(1);
                default :
                    System.out.println("请输入正确的操作！");
            }
        }
        //sc.close();
    }
    public static void main(String[] args) {
        start();
    }
}
