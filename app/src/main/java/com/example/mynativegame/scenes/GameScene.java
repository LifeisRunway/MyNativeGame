package com.example.mynativegame.scenes;

import android.graphics.Color;
import com.example.my_game_module.CoreFW;
import com.example.my_game_module.SceneFW;
import com.example.my_game_module.SettingsGame;
import com.example.my_game_module.utils.UtilResource;
import com.example.mynativegame.R;
import com.example.mynativegame.classes.GameManager;

public class GameScene extends SceneFW {

    private enum GameState {
        READY, RUNNING, PAUSE, GAMEOVER
    }

    GameState gameState;
    GameManager gameManager;

    public GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState = GameState.READY;
        gameManager = new GameManager(coreFW, sceneWidth, sceneHeight);
        if(SettingsGame.sMusicOn) {
             UtilResource.gameMusic.play(true, 0.5f);
        }
    }

    @Override
    public void update() {
        if(gameState == GameState.READY) {
            updateStateReady();
        }
        if(gameState == GameState.RUNNING) {
            updateStateRunning();
        }
        if(gameState == GameState.PAUSE) {
            updateStatePause();
        }
        if(gameState == GameState.GAMEOVER) {
            updateStateGameOver();
        }
    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);

        if(gameState == GameState.READY) {
            drawingStateReady();
        }
        if(gameState == GameState.RUNNING) {
            drawingStateRunning();
        }
        if(gameState == GameState.PAUSE) {
            drawingStatePause();
        }
        if(gameState == GameState.GAMEOVER) {
            drawingStateGameOver();
        }
    }


    private void drawingStateReady() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.gameScene_stateReady_ready), 250, 300, Color.WHITE, 60, null);
    }

    private void updateStateReady() {
        if(coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)) {
            gameState = GameState.RUNNING;
        }
    }

    private void drawingStateRunning() {
        graphicsFW.clearScene(Color.BLACK);
        gameManager.drawing(coreFW,graphicsFW);
    }

    private void updateStateRunning() {
        gameManager.update();
        if(GameManager.gameOver) {
            gameState = GameState.GAMEOVER;
        }
        if(coreFW.isPressedKeyBack()) {
            gameState = GameState.PAUSE;
            coreFW.setPressedKeyBack(false);
        }
    }

    private void drawingStatePause() {
        coreFW.getGraphicsFW().drawText("Pause", 350, 300, Color.GREEN, 50, null);
    }

    private void updateStatePause() {
        if(coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)) {
            gameState = GameState.RUNNING;
        }
    }

    private void drawingStateGameOver() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.gameScene_stateGameOver_gameOver), 250, 300, Color.WHITE, 60, null);
        graphicsFW.drawText(coreFW.getString(R.string.gameScene_stateGameOver_restart), 250, 360, Color.WHITE, 30, null);
        graphicsFW.drawText(coreFW.getString(R.string.gameScene_stateGameOver_exit), 250, 420, Color.WHITE, 30, null);
        graphicsFW.drawText(coreFW.getString(R.string.gameScene_stateGameOver_distance) + gameManager.getPassedDistance(), 250, 200, Color.WHITE, 30, null);
    }

    private void updateStateGameOver() {
        SettingsGame.addDistance(gameManager.getPassedDistance());
        if(coreFW.getTouchListenerFW().getTouchUp(250, 360, 100, 35)) {
            coreFW.setScene(new GameScene(coreFW));
        }
        if(coreFW.getTouchListenerFW().getTouchUp(250, 420, 100, 35)) {
            coreFW.setScene(new MainMenuScene(coreFW));
        }
    }


    @Override
    public void pause() {
        UtilResource.gameMusic.stop();
    }

    @Override
    public void resume() {
        if(SettingsGame.sMusicOn) {
             UtilResource.gameMusic.play(true, 0.5f);
        }
    }

    @Override
    public void dispose() {
      
    }
}
