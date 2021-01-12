package com.example.mynativegame.scenes

public class LoaderResourceScene extends SceneGame {
        
    public LoaderResourceScene(CoreFW coreFW) {
        super(coreFW);
        LoaderTask loaderTask = new LoaderTask(coreFW);
        loaderTask.execute();
    }
    
    @Override
    public void update() {
         coreFW.setScene(new MainMenuScene(coreFW));
    }

    @Override
    public void drawing() {
        
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
