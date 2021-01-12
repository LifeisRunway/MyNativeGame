package com.example.mynativegame.scenes;

import android.graphics.Color;
import com.example.my_game_module.CoreFW;
import com.example.my_game_module.SceneFW;
import com.example.my_game_module.utils.UtilResource;
import com.example.mynativegame.R;

public class MainMenuScene extends SceneFW {

    public MainMenuScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {
        if(coreFW.getTouchListenerFW().getTouchUp(20, 250, 100, 50)) {
            coreFW.setScene(new GameScene(coreFW));
            UtilResource.touch.play(1);
        }
        if(coreFW.getTouchListenerFW().getTouchUp(20, 400, 100, 50)) {
            coreFW.setScene(new TopDistance(coreFW));
            UtilResource.touch.play(1);
        }
        if(coreFW.getTouchListenerFW().getTouchUp(20, 350, 100, 50)) {
            coreFW.setScene(new SettingsScene(coreFW));
            UtilResource.touch.play(1);
        }
        if(coreFW.getTouchListenerFW().getTouchUp(20, 450, 100, 50)) {
            coreFW.setScene(new ExitScene(coreFW));
            UtilResource.touch.play(1);
        }
    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getResources().getString(R.string.app_name), 180, 100, Color.BLUE, 60, UtilResource.mainMenuFont);
        graphicsFW.drawText(coreFW.getResources().getString(R.string.new_game), 20, 250, Color.BLUE, 40, UtilResource.mainMenuFont);
        graphicsFW.drawText(coreFW.getResources().getString(R.string.settings), 20, 325, Color.BLUE, 40, UtilResource.mainMenuFont);
        graphicsFW.drawText(coreFW.getResources().getString(R.string.results), 20, 400, Color.BLUE, 40, UtilResource.mainMenuFont);
        graphicsFW.drawText(coreFW.getResources().getString(R.string.exit_game), 20, 475, Color.BLUE, 40, UtilResource.mainMenuFont);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

}
