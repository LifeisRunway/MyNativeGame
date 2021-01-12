package com.example.mynativegame.scenes;

public class ExitScene extends SceneFW {

    public ExitScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {
        if(coreFW.getTouchListenerFW().getTouchUp(150, 250, 100,35)) {
            
        }
    }

    @Override
    public void drawing() {
        coreFW.getGraphicsFW().clearScene(Color.BLACK);
        coreFW.getGraphicsFW().drawText("Are you sure?", 150, 200, Color.GREEN, 50, UtilResource.mainMenuFont);
        
        coreFW.getGraphicsFW().drawText("Yes", 150, 250, Color.GREEN, 35, UtilResource.mainMenuFont);
        coreFW.getGraphicsFW().drawText("No", 150, 300, Color.GREEN, 35, UtilResource.mainMenuFont);
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
