package com.example.my_game_module;

import android.graphics.Bitmap;

import java.util.List;

public class AnimationGameFW {

    double speedAnimation;
    int delayIndex;
    int countFrames;
    int frames;

    Bitmap sprite;

    List<Bitmap> mSprites;

    public AnimationGameFW(double speedAnimation, List<Bitmap> sprites) {
        sprite = sprites.get(0);
        mSprites = sprites;
        this.speedAnimation = speedAnimation;
        frames = sprites.size() - 1;
    }

    public void runAnimation() {
        delayIndex++;

        if(delayIndex > speedAnimation) {
            delayIndex = 0;
            nextFrame();
        }

    }

    private void nextFrame() {

        sprite = mSprites.get(countFrames);

        countFrames++;

        if(countFrames > frames) {
            countFrames = 0;
        }
    }

//    private void nextFrame() {
//
//        switch (countFrames) {
//            case 0:
//                sprite = sprite1;
//                break;
//            case 1:
//                sprite = sprite2;
//                break;
//            case 2:
//                sprite = sprite3;
//                break;
//            case 3:
//                sprite = sprite4;
//                break;
//        }
//        countFrames++;
//        if(countFrames >= frames) {
//            countFrames = 0;
//        }
//    }

    public void drawingAnimation(GraphicsFW graphicsFW, int x, int y) {
        graphicsFW.drawTexture(sprite, x, y);
    }

}
