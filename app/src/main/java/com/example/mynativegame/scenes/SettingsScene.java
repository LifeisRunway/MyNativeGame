package com.example.mynativegame.scenes

public class SettingsScene extends SceneFW {
  
    
  
  
    public SettingsScene(CoreFW coreFW) {
        super(coreFW);
       
    }
    
    @Override
    public void update() {
         
    }

    @Override
    public void drawing() {
       coreFW.getGraphics().clearScene(Color.BLACK);
       coreFW.getGraphics().drawText("Settings", 250, 200, Color.GREEN, 40, null);
       
       coreFW.getGraphics().drawText("Music ", 250, 300, Color.GREEN, 30, null);
       coreFW.getGraphics().drawText("Sound ", 250, 350, Color.GREEN, 30, null);
       
       coreFW.getGraphics().drawText("ON", 450, 300, Color.GREEN, 30, null);
       coreFW.getGraphics().drawText("ON", 450, 350, Color.GREEN, 30, null);
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
