package com.example.mynativegame.objects;

import android.graphics.Rect;

import com.example.my_game_module.AnimationGameFW;
import com.example.my_game_module.GraphicsFW;
import com.example.my_game_module.ObjectFW;
import com.example.my_game_module.utils.UtilRandomFW;
import com.example.my_game_module.utils.UtilResource;

public class Enemy extends ObjectFW {

    AnimationGameFW animEnemy;

    public Enemy(int maxScreenX, int maxScreenY, int minScreenY, int enemyType) {
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spriteEnemy.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;
        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        radius = UtilResource.spriteEnemy.get(0).getWidth() / 4;
        switch (enemyType) {
            case 1:
                speed = UtilRandomFW.getGap(1,6);
                animEnemy = new AnimationGameFW(3,
                        UtilResource.spriteEnemy);
                break;
            case 2:
                speed = UtilRandomFW.getGap(4,9);
                break;
        }
    }

    public void update(float speedPlayer) {
        x -= speed;
        x -= speedPlayer;
        if(x < minScreenX) {
            x = maxScreenX;
            y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        }
        animEnemy.runAnimation();
        hitBox = new Rect(x, y,
                UtilResource.spriteEnemy.get(0).getWidth(),
                UtilResource.spriteEnemy.get(0).getHeight());
    }

    public void drawing (GraphicsFW graphicsFW) {
        animEnemy.drawingAnimation(graphicsFW, x, y);
    }

}
