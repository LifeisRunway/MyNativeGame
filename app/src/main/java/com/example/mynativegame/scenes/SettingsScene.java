package com.example.mynativegame.scenes

public class SettingsScene extends SceneFW {
  
    
  
  
    public SettingsScene(CoreFW coreFW) {
        super(coreFW);
       
    }
    
    @Override
    public void update() {
         if(coreFW.isPerssedKeyBack()) {
            coreFW.setPressedKeyBack(false);
            coreFW.setScene(new MainMenuScene(coreFW));
         }
         
        if(coreFW.getTouchListenerFW().getTouchUp(250, 350, 100, 30)) {
            SettingsGame.sSoundOn = !SettingsGame.sSoundOn;
            SettingsGame.sSoundOn.saveSettings(coreFW);
        }
        
        if(coreFW.getTouchListenerFW().getTouchUp(250, 300, 100, 30)) {
            SettingsGame.sMusicOn = !SettingsGame.sMusicOn;
            SettingsGame.sMusicOn.saveSettings(coreFW);
        }
    }

    @Override
    public void drawing() {
       coreFW.getGraphics().clearScene(Color.BLACK);
       coreFW.getGraphics().drawText("Settings", 250, 200, Color.GREEN, 40, null);
       
       coreFW.getGraphics().drawText("Music ", 250, 300, Color.GREEN, 30, null);
       coreFW.getGraphics().drawText("Sound ", 250, 350, Color.GREEN, 30, null);
       
       if(SettingsGame.sMusicOn) {
          coreFW.getGraphics().drawText("ON", 400, 300, Color.GREEN, 30, null);
       } else {
          coreFW.getGraphics().drawText("OFF", 400, 300, Color.RED, 30, null);
       }
       
       if(SettingsGame.sSoundOn) {
          coreFW.getGraphics().drawText("ON", 400, 350, Color.GREEN, 30, null);
       } else {
          coreFW.getGraphics().drawText("OFF", 400, 350, Color.RED, 30, null);
       }
              
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
