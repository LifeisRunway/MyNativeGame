package com.example.mynativegame.objects;

import android.graphics.Rect;

import com.example.my_game_module.AnimationGameFW;
import com.example.my_game_module.GraphicsFW;
import com.example.my_game_module.ObjectFW;
import com.example.my_game_module.utils.UtilRandomFW;
import com.example.my_game_module.utils.UtilResource;

public class Protector extends ObjectFW {
    
    AnimationGameFW animProtector;

    public Protector(int maxScreenX, int maxScreenY, int minScreenY) {
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spriteProtector.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;
        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        radius = UtilResource.spriteProtector.get(0).getWidth() / 4;
        hitBox = new Rect(x, y,
                UtilResource.spriteProtector.get(0).getWidth(),
                UtilResource.spriteProtector.get(0).getHeight());
        animProtector = new AnimationFW(GameManager.SPEED_ANIMATION, UtilResource.spriteProtector);
    }

    public void update(float speedPlayer) {
        x -= speed;
        x -= speedPlayer;
               
        if(x < minScreenX) {
            y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        }
        
        animProtector.runAnimation();
        
        hitBox = new Rect(x, y,
                UtilResource.spriteEnemy.get(0).getWidth(),
                UtilResource.spriteEnemy.get(0).getHeight());
    }

    public void drawing (GraphicsFW graphicsFW) {
        animProtector.drawingAnimation(graphicsFW, x, y);
    }

  
}
