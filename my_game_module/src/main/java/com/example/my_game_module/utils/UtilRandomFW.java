package com.example.my_game_module.utils;

import java.util.Random;

public class UtilRandomFW {
    public static int getCasualNumber(int number) {
        return new Random().nextInt(number);
    }

    public static int getGap(int minNumber, int maxNumber) {
        int gup = 0;
        gup = (int) (Math.random() * ++maxNumber) + minNumber;
        return gup;
    }
}
