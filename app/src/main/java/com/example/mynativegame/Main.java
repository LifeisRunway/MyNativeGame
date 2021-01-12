package com.example.mynativegame;

import com.example.my_game_module.CoreFW;
import com.example.my_game_module.SceneFW;
import com.example.mynativegame.classes.LoaderAssets;
import com.example.mynativegame.scenes.MainMenuScene;

public class Main extends CoreFW {

    public SceneFW getStartScene() {
        //TODO Сделать отдельный поток для loadAssets AsyncTask
        LoaderAssets loaderAssets = new LoaderAssets(this, this.getGraphicsFW());
        return new MainMenuScene(this);
    }

}
