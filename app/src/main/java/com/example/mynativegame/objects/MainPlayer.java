package com.example.mynativegame.objects;

import android.graphics.Rect;

import com.example.my_game_module.CoreFW;
import com.example.my_game_module.GraphicsFW;
import com.example.my_game_module.ObjectFW;
import com.example.my_game_module.utils.UtilResource;
import com.example.my_game_module.AnimationGameFW;
import com.example.my_game_module.utils.UtilTimerDelay;
import com.example.mynativegame.classes.GameManager;

public class MainPlayer extends ObjectFW {

    private final int GRAVITY = -3;
    private final int MAX_SPEED = 15;
    private final int MIN_SPEED = 1;

    AnimationGameFW animMainPlayer;
    AnimationGameFW animMainPlayerBoost;
    AnimationGameFW animExplosionPlayer;
    AnimationGameFW animPlayerShieldsOn;
    AnimationGameFW animPlayerShieldsOnBoost;

    UtilTimerDelay timerOnShieldHit;
    UtilTimerDelay timerOnGameOver;;

    boolean hitEnemy;
    boolean isGameOver;
    static boolean shieldsOn;

    CoreFW coreFW;

    boolean boosting;
    private int shieldsPlayer;

    public MainPlayer(CoreFW coreFW, int maxScreenX, int maxScreenY, int minScreenY) {
        x = 20;
        y = 200;
        speed = (float) GameManager.SPEED_ANIMATION;
        shieldsPlayer = 3;
        boosting = false;
        hitEnemy = false;
        isGameOver = false;
        shieldsOn = false;
        timerOnShieldHit = new UtilTimerDelay();
        timerOnGameOver = new UtilTimerDelay();

        radius = UtilResource.spritePlayer.get(0).getHeight() / 4;

        this.coreFW = coreFW;
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spritePlayer.get(0).getHeight();
        this.minScreenY = minScreenY;

        initAnimation();
    }

    private void initAnimation() {
        animMainPlayer = new AnimationGameFW(speed, UtilResource.spritePlayer);
        animMainPlayerBoost = new AnimationGameFW(speed, UtilResource.spritePlayerBoost);
        animPlayerShieldsOn = new AnimationGameFW(speed, UtilResource.spritePlayersShieldsOn);
        animPlayerShieldsOnBoost = new AnimationGameFW(speed, UtilResource.spritePlayersShieldsOnBoost);
        animExplosionPlayer = new AnimationGameFW(speed, UtilResource.spriteExplosionPlayer);
    }

    public void update() {

        if(coreFW.getTouchListenerFW().getTouchDown(0, maxScreenY, maxScreenX, maxScreenY)) {
            startBoosting();
        }

        if(coreFW.getTouchListenerFW().getTouchUp(0, maxScreenY, maxScreenX, maxScreenY)) {
            stopBoosting();
        }

        if(boosting) {
            speed += 0.1;
        } else {
            speed -= 3.0;
        }

        if(speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        if(speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }

        y -= speed + GRAVITY;

        if(y < minScreenY) {
            y = minScreenY;
        }
        if(y > maxScreenY) {
            y = maxScreenY;
        }
        if(boosting) {
            if(shieldsOn) {
                animPlayerShieldsOnBoost.runAnimation();
            } else {
                animMainPlayerBoost.runAnimation();
            }
        } else {
            if(shieldsOn) {
                animPlayerShieldsOn.runAnimation();
            } else {
                animMainPlayer.runAnimation();
            }
        }

        if(isGameOver) {
            animExplosionPlayer.runAnimation();
        }

        hitBox = new Rect(x, y,
                UtilResource.spritePlayer.get(0).getWidth(),
                UtilResource.spritePlayer.get(0).getHeight());

    }

    private void stopBoosting() {
        boosting = false;
    }

    private void startBoosting() {
        boosting = true;
    }

    public void drawing(GraphicsFW graphicsFW) {
        if(boosting) {
            animMainPlayerBoost.drawingAnimation(graphicsFW, x, y);
        } else {
            animMainPlayer.drawingAnimation(graphicsFW, x, y);
        }

        if(!isGameOver) {
            if(!hitEnemy) {
                if(boosting) {
                    if(shieldsOn) {
                        animPlayerShieldsOnBoost.drawingAnimation(graphicsFW, x, y);
                    } else {
                        animMainPlayerBoost.drawingAnimation(graphicsFW, x, y);
                    }
                } else {
                    if(shieldsOn) {
                        animPlayerShieldsOn.drawingAnimation(graphicsFW, x, y);
                    } else {
                        animMainPlayer.drawingAnimation(graphicsFW, x, y);
                    }
                }
            } else {
                graphicsFW.drawTexture(UtilResource.shieldHitEnemy, x, y);
                if(timerOnShieldHit.timerDelay(0.3)) {
                    hitEnemy = false;
                } else {hitEnemy = true;}
            }
        } else {
            animExplosionPlayer.drawingAnimation(graphicsFW, x, y);
            if(timerOnGameOver.timerDelay(0.5)) {
                GameManager.gameOver = true;
            }
        }
    }

    public float getSpeed() {
        return speed;
    }

    public int getShieldsPlayer() {
        return shieldsPlayer;
    }

    public void hitEnemy() {
        shieldsPlayer--;
        if(!shieldsOn) {
            if(shieldsPlayer < 0) {
                UtilResource.explode.play(1);
                isGameOver = true;
                timerOnGameOver.startTimer();
            }
        }
        hitEnemy = true;
        timerOnShieldHit.startTimer();
    }
    
    public static boolean isShieldsOn() {
        return shieldsOn;
    }
}
