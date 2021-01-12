package com.example.mynativegame.classes;

import com.example.my_game_module.CollisionDetect;
import com.example.my_game_module.CoreFW;
import com.example.my_game_module.GraphicsFW;
import com.example.my_game_module.utils.UtilResource;
import com.example.mynativegame.generators.GeneratorBackground;
import com.example.mynativegame.generators.GeneratorEnemy;
import com.example.mynativegame.objects.HUD;
import com.example.mynativegame.objects.MainPlayer;

public class GameManager  {

    public final static double SPEED_ANIMATION = 3;
    
    private int mMaxScreenX;
    private int mMaxScreenY;
    private int mMinScreenY;

    private int mPassedDistance;
    private int mCurrentSpeedPlayer;
    private int mCurrentShieldsPlayer;

    
    public static boolean gameOver;

    MainPlayer mainPlayer;
    GeneratorBackground generatorBackground;
    GeneratorEnemy generatorEnemy;
    GeneratorGifts generatorGifts;
    HUD hud;

    public GameManager(CoreFW coreFW, int sceneWidth, int sceneHeight) {
        hud = new HUD(coreFW);
        mMaxScreenX = sceneWidth;
        mMaxScreenY = sceneHeight;
        mMinScreenY = hud.getHEIGHT_HUD();
        gameOver = false;
        
        mainPlayer = new MainPlayer(coreFW, maxScreenX, maxScreenY, minScreenY);
        generatorBackground = new GeneratorBackground(sceneWidth, sceneHeight, minScreenY);
        generatorEnemy = new GeneratorEnemy(sceneWidth,sceneHeight,minScreenY);
        generatorGifts = new GeneratorGifts(sceneWidth, sceneHeight, minScreenY);
    }

    public void update() {
        generatorBackground.update(mainPlayer.getSpeed());
        mainPlayer.update();
        generatorEnemy.update(mainPlayer.getSpeed());
        generatorGifts.update(mainPlayer.getSpeed());
        
        mPassedDistance += mainPlayer.getSpeed();
        mCurrentSpeedPlayer = (int) mainPlayer.getSpeed() * 60;
        mCurrentShieldsPlayer = mainPlayer.getShieldsPlayer();

        hud.update(mPassedDistance, mCurrentSpeedPlayer, mCurrentShieldsPlayer);

        checkHit();

    }

    private void checkHit() {
        for (int i = 0; i < generatorEnemy.enemyArrayList.size(); i++) {
            if(CollisionDetect.collisionDetect(mainPlayer,generatorEnemy.enemyArrayList.get(i))) {
                UtilResource.hit.play(1);
                mainPlayer.hitEnemy();
                generatorEnemy.hitPlayer(generatorEnemy.enemyArrayList.get(i));
            }
        }
        if(CollisionDetect.CollisionDetect(mainPlayer, generatorGifts.getProtector())) {
            hitPlayerWithProtector();
        }
    }

    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW) {
        mainPlayer.drawing(graphicsFW);
        generatorBackground.drawing(graphicsFW);
        generatorGifts.drawing(graphicsFW);
        generatorEnemy.drawing(graphicsFW);
        hud.drawing(graphicsFW);
    }
    
    public void hitPlayerWithProtector() {
        mainPlayer.hitProtector();    
        generatorGifts.hitProtectorWithPlayer();
    }

    public int getPassedDistance() {
        return mPassedDistance;
    }
}
