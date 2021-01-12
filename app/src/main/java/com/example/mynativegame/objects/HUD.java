package com.example.mynativegame.objects;

import android.graphics.Color;

import com.example.my_game_module.CoreFW;
import com.example.my_game_module.GraphicsFW;
import com.example.mynativegame.R;

public class HUD {

    private int passedDistance;
    private int currentSpeedPlayer;
    private int currentShieldsPlayer;

    CoreFW coreFW;

    private final int HEIGHT_HUD = 50;

    public HUD(CoreFW coreFW) {
        this.coreFW = coreFW;
    }

    public void update(int passedDistance, int currentSpeedPlayer, int curretShieldsPlayer) {
        this.currentShieldsPlayer = curretShieldsPlayer;
        this.currentSpeedPlayer = currentSpeedPlayer;
        this.passedDistance = passedDistance;
    }

    public void drawing(GraphicsFW graphicsFW) {
        graphicsFW.drawLine(0, HEIGHT_HUD, graphicsFW.getWidthFrameBuffer(), HEIGHT_HUD, Color.WHITE);
        graphicsFW.drawText(coreFW.getString(R.string.hud_passedDisance) + passedDistance, 10, 30, Color.GREEN, 25, null);
        graphicsFW.drawText(coreFW.getString(R.string.hud_currentSpeedPlayer) + currentSpeedPlayer, 350, 30, Color.GREEN, 25, null);
        graphicsFW.drawText(coreFW.getString(R.string.hud_currentShieldsPlayer) + currentShieldsPlayer, 600, 30, Color.GREEN, 25, null);
    }

    public int getCurrentSpeedPlayer() {
        return currentSpeedPlayer;
    }

    public int getHEIGHT_HUD() {
        return HEIGHT_HUD;
    }
}
