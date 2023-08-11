package com.jory.map;

import java.util.ArrayList;
import java.util.HashMap;

public class GameTest {
    public static void main(String[] args) {
        //斗地主,需要扑克集合和扑克索引集合
        HashMap<Integer, String> poker = new HashMap<>();
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        PokerGame demo = new PokerGame(poker, pokerIndex);
        //准备牌
        demo.prepare();
        demo.shufflePoker();
        //打印牌
        demo.printPoker();
    }
}
