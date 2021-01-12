package com.example.mynativegame.objects;

import com.example.my_game_module.ObjectFW;
import com.example.my_game_module.utils.UtilRandomFW;

public class Star extends ObjectFW {

    public Star(int sceneWidth, int sceneHeight, int minScreenY) {
        this.maxScreenX = sceneWidth;
        this.maxScreenY = sceneHeight;
        this.minScreenX = 0;
        this.minScreenY = minScreenY;
        this.speed = 4;
        this.x = UtilRandomFW.getCasualNumber(maxScreenX);;
        this.y = UtilRandomFW.getGap(minScreenY, maxScreenY);
    }

    public void update(float speedPlayer){
        x-=speedPlayer;
        x-=speed;
        if(x < 0) {
            x = maxScreenX;
            y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
