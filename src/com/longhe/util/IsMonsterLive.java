package com.longhe.util;

import com.longhe.role.Monster;


public class IsMonsterLive {
    public static boolean isLive(Monster monster){
        if (monster.getLifeValue()>0){
            return true;
        }
        return false;
    }

}
