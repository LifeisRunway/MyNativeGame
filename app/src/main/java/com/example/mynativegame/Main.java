package com.example.mynativegame;

import com.example.my_game_module.CoreFW;
import com.example.my_game_module.SceneFW;
import com.example.mynativegame.classes.LoaderAssets;
import com.example.mynativegame.scenes.MainMenuScene;

public class Main extends CoreFW {

    public SceneFW getStartScene() {
       return new LoaderResourceScene(this);
    }

}
