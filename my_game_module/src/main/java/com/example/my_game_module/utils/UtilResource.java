package com.example.my_game_module.utils;

import android.graphics.Bitmap;

import com.example.my_game_module.MusicFW;
import com.example.my_game_module.SoundFW;

import java.util.ArrayList;

public class UtilResource {

    public static Bitmap textureAtlas;
    public static Bitmap textureAtlasHeal;
    public static Bitmap textureAtlasAsteroid;
    public static Bitmap textureAtlasAsteroidExplosion;
    public static ArrayList<Bitmap> spritePlayer;
    public static ArrayList<Bitmap> spritePlayerBoost;
    public static ArrayList<Bitmap> spriteEnemy;
    public static ArrayList<Bitmap> spritePlayersShieldsOn;
    public static ArrayList<Bitmap> spritePlayersShieldsOnBoost;
    public static ArrayList<Bitmap> spriteProtector;
    public static Bitmap shieldHitEnemy;
    public static ArrayList<Bitmap> spriteExplosionPlayer;
    public static MusicFW gameMusic;
    public static SoundFW hit;
    public static SoundFW explode;
    public static SoundFW touch;
    public static Typeface mainMenuFont;
}
