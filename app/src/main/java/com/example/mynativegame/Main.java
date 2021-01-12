package com.example.mynativegame;

import com.example.my_game_module.CoreFW;
import com.example.my_game_module.SceneFW;
import com.example.mynativegame.classes.LoaderAssets;
import com.example.mynativegame.scenes.MainMenuScene;

public class Main extends CoreFW {

    public SceneFW getStartScene() {
        LoaderAssets loaderAssets = new LoaderAssets(this, this.getGraphicsFW());
        return new MainMenuScene(this);
    }

}