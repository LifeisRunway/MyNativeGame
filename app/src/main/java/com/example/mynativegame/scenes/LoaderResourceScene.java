package com.example.mynativegame.scenes

public class LoaderResourceScene extends SceneFW implements TaskComplete {
        
    public LoaderResourceScene(CoreFW coreFW) {
        super(coreFW);
        LoaderTask loaderTask = new LoaderTask(coreFW, this);
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
    
    @Override
    public void onComplete() {
        coreFW.setScene(new MainMenuScene(coreFW));
    }
    
}
