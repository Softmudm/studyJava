package com.sz.zhiling;
;
import java.util.List;
import java.util.Map;

public class PokerTest {
    public static void main(String[] args) {
        Poker poker = new Poker();
        Map map = poker.deal();
        System.out.println("玩家一:"+poker.sort((List)(map.get("玩家一"))));
        System.out.println("玩家二:"+poker.sort((List)(map.get("玩家二"))));
        System.out.println("玩家三:"+poker.sort((List)(map.get("玩家三"))));
        System.out.println("底牌:"+poker.sort((List)(map.get("底牌"))));
    }
}
