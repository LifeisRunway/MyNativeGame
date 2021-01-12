package com.example.mynativegame.generators;

import android.graphics.Color;

import com.example.my_game_module.GraphicsFW;
import com.example.mynativegame.objects.Star;

import java.util.ArrayList;

public class GeneratorBackground {
    public ArrayList<Star> starArrayList = new ArrayList<Star>();

    public GeneratorBackground(int sceneWidth, int sceneHeight, int minScreenY) {
        int starsSpeak = 50;
        for(int i = 0; i < starsSpeak; i++) {
            Star star = new Star(sceneWidth, sceneHeight, minScreenY);
            starArrayList.add(star);
        }
    }

    public void update(float speedPlayer) {
        for(Star s : starArrayList) {
            s.update(speedPlayer);
        }
    }

    public void drawing(GraphicsFW graphicsFW) {
        for (Star s : starArrayList) {
            graphicsFW.drawPixel(s.getX(), s.getY(), Color.WHITE);
        }
    }

}
