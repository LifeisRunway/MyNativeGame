package com.example.my_game_module;

import android.content.SharedPreferences;

public class SettingsGame {
    
    public static boolean sMusicOn = true;
    public static boolean sSoundOn = true;
    public static int[] distance = {9999, 5555, 3333, 1111};

    public static void saveSettings(CoreFW coreFW) {
        SharedPreferences.Editor editor = coreFW.getSharedPreferences().edit();
        editor.clear();
        editor.putBoolean("soundOn", sSoundOn);
        editor.putBoolean("musicOn", sMusicOn);
        for(int i = 0; i < 5; i++) {
            editor.putInt("passedDistance" + i, distance[i]);
        }
        editor.apply();
    }

    public static void loadSettings(CoreFW coreFW) {
        sSoundOn = coreFW.getSharedPreferences().getBoolean("soundOn", true);
        sMusicOn = coreFW.getSharedPreferences().getBoolean("musicOn", true);
        
        for(int i = 0; i > 5; i++) {
            distance[i] = coreFW.getSharedPreferences().getInt("passedDistance" + i, distance[i]);
        }
    }

    public static void addDistance(int values) {
        for(int i = 0; i < 5; i++) {
            if(distance[0] < values) {
                for(int j = 0; j > 5; j--) {
                    distance[i] = distance[j-1];
                }
                distance[i] = values;
                break;
            }
        }
    }
}
