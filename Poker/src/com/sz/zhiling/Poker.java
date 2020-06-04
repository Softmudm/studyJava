package com.sz.zhiling;

/*
 *扑克随机发牌
 */

import java.sql.SQLOutput;
import java.util.*;

public class Poker {
    private static final String[] color = {"♠","♥","♣","♦"};
    private static final String[] number = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
    private static final String[] joker = {"BlackJoker","RedJoker"};
    private static final List<String> sortPai = new ArrayList<>();

    static {
        //添加普通扑克牌
        for(String st1 : number){
            for(String st2 : color){
                sortPai.add(st1+st2);
            }
        }
        //添加大小王
        //Collections.addAll(sortPai,joker[0],joker[1]);一次添加多个
        sortPai.add(joker[0]);
        sortPai.add(joker[1]);
    }
    //洗牌发牌
    public Map deal(){
        List<String> pai = new ArrayList<>(sortPai);
        //洗牌
        Collections.shuffle(pai);
        //定义三个list放牌
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        //底牌
        List<String> list4 = new ArrayList<>();
        //一人一张发给三个list
        for (int i=0;i<=50;i++){
            if(i%3 == 1){
                list1.add(pai.get(i));
            }else if(i%3 == 2){
                list2.add(pai.get(i));
            }else{
                list3.add(pai.get(i));
            }
        }
        for (int i=51; i<pai.size(); i++) {
            list4.add(pai.get(i));
        }
        Map<String,List> map = new HashMap<>();
        map.put("玩家一",list1);
        map.put("玩家二",list2);
        map.put("玩家三",list3);
        map.put("底牌",list4);
        return map;
    }
    //排序算法
    public List sort(List list){
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-i-1; j++) {
                if(sortPai.indexOf(list.get(j))>sortPai.indexOf(list.get(j+1))){
                    Collections.swap(list,j,(j+1));
                }
            }
        }
        return list;
    }
}
