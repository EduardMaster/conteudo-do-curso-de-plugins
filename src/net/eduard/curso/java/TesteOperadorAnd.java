package net.eduard.curso.java;

import net.eduard.api.lib.game.FakePlayer;
import net.eduard.api.lib.manager.CurrencyManager;

public class TesteOperadorAnd {

    public static void main(String[] args) {
            int max = 20;
        CurrencyManager
        for (int x= 1;x<=max;x++){
            System.out.println("---------------------------------------");
            for (int y= 1;y<=max;y++){
                System.out.println("|   "+x+"   &   "+y +" =    ["+ (x & y)+" | "+ (y & x)+"]   x= "+x +" y= "+y+"   |");
            }
        }
    }

}
