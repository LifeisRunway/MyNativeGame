package com.example.mynativegame.scenes

public class LoaderResourceScene extends SceneFW implements TaskComplete {
        
    private static int mProgressloader;
    
    public LoaderResourceScene(CoreFW coreFW) {
        super(coreFW);
        mProgressLoader = 0;
        LoaderTask loaderTask = new LoaderTask(coreFW, this);
        loaderTask.execute();
    }
    
    @Override
    public void update() {
         
    }

    @Override
    public void drawing() {
        coreFW.getGraphicsFW().clearScene(Color.BLACK);
        coreFW.getGraphicsFW().drawText(coreFW.getString(R.string.loading), 200, 200, Color.GREEN, 50, null);
        coreFW.getGraphicsFW().drawLine(0, 500, mProgressLoader, 500, Color.GREEN);
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
    
    public static void setProgressLoader(int progress) {
        LoaderResourceScene.mProgressLoader = progress;
    }
    
}
