package com.example.mynativegame.tasks;

import android.os.AsyncTask;

public class LoaderTask extends AcyncTask<Void, Integer, Void> {
  
  private CoreFW mCoreFW;
  
  public LoaderTask (CoreFW coreFW) {
    mCoreFW = coreFW;
  }
  
  @Override
  protected Void doInBackground(Void...voids) {
    loaderAssets();
    return null;
  }
  
  public void loaderAssets() {
        loadTexture(mCoreFW.getGraphicsFW());
        loadSpritePlayer(mCoreFW.getGraphicsFW());
        loadSpriteEnemy(mCoreFW.getGraphicsFW());
        loadOther(mCoreFW.getGraphicsFW());
        loadAudio(mCoreFW);
        loadSpritePlayerShieldsOn(mCoreFW.getGraphicsFW());
        loadGifts(mCoreFW.getGraphicsFW());
    }

    private void loadOther(GraphicsFW graphicsFW) {
        UtilResource.shieldHitEnemy = graphicsFW.createSprite(UtilResource.textureAtlas, 0, 128, 64, 64);
    }

    private void loadAudio(CoreFW coreFW) {
        UtilResource.gameMusic = coreFW.getAudioFW().newMusic("music.mp3");
        UtilResource.hit = coreFW.getAudioFW().newSound("hit.mp3");
        UtilResource.explode = coreFW.getAudioFW().newSound("explode.mp3");
        UtilResource.touch = coreFW.getAudioFW().newSound("touch.mp3");
    }

    private void loadSpritePlayerShieldsOn(GraphicsFW graphicsFW) {
        UtilResource.spritePlayersShieldsOn = new ArrayList<>();
        UtilResource.spritePlayersShieldsOnBoost = new ArrayList<>();

//        UtilResource.spritePlayersShieldsOn.add(graphicsFW.createSprite(UtilResource.textureAtlas, 0, 128, 64, 64));
//        UtilResource.spritePlayersShieldsOn.add(graphicsFW.createSprite(UtilResource.textureAtlas, 64, 128, 64, 64));
//        UtilResource.spritePlayersShieldsOn.add(graphicsFW.createSprite(UtilResource.textureAtlas, 128, 128, 64, 64));
//        UtilResource.spritePlayersShieldsOn.add(graphicsFW.createSprite(UtilResource.textureAtlas, 192, 128, 64, 64));
//
//        UtilResource.spritePlayersShieldsOnBoost.add(graphicsFW.createSprite(UtilResource.textureAtlas, 0, 192, 64, 64));
//        UtilResource.spritePlayersShieldsOnBoost.add(graphicsFW.createSprite(UtilResource.textureAtlas, 64, 192, 64, 64));
//        UtilResource.spritePlayersShieldsOnBoost.add(graphicsFW.createSprite(UtilResource.textureAtlas, 128, 192, 64, 64));
//        UtilResource.spritePlayersShieldsOnBoost.add(graphicsFW.createSprite(UtilResource.textureAtlas, 192, 192, 64, 64));
    }

    public void loadGifts(GraphicsFW graphicsFW) {
        //Метод загружает бонусы (неуязвимость, щиты)
        UtilResource.spriteProtector = new ArrayList<>();

        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 0, 0, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 16, 0, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 32, 0, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 48, 0, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 64, 0, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 0, 16, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 16, 16, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 32, 16, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 48, 16, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 64, 16, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 0, 32, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 16, 32, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 32, 32, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 48, 32, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 64, 32, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 0, 48, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 16, 48, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 32, 48, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 48, 48, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 64, 48, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 0, 64, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 16, 64, 16, 16));
        UtilResource.spriteProtector.add(graphicsFW.createSprite(UtilResource.textureAtlasHeal, 32, 64, 16, 16));
    }

    private void loadSpriteEnemy(GraphicsFW graphicsFW) {
        UtilResource.spriteEnemy = new ArrayList<>();

        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 0, 0, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 64, 0, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 128, 0, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 192, 0, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 256, 0, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 320, 0, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 384, 0, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 448, 0, 64, 64));

        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 0, 64, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 64, 64, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 128, 64, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 192, 64, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 256, 64, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 320, 64, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 384, 64, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 448, 64, 64, 64));

        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 0, 128, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 64, 128, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 128, 128, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 192, 128, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 256, 128, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 320, 128, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 384, 128, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 448, 128, 64, 64));

        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 0, 192, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 64, 192, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 128, 192, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 192, 192, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 256, 192, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 320, 192, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 384, 192, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 448, 192, 64, 64));

        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 0, 256, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 64, 256, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 128, 256, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 192, 256, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 256, 256, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 320, 256, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 384, 256, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 448, 256, 64, 64));

        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 0, 320, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 64, 320, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 128, 320, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 192, 320, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 256, 320, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 320, 320, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 384, 320, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 448, 320, 64, 64));

        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 0, 384, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 64, 384, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 128, 384, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 192, 384, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 256, 384, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 320, 384, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 384, 384, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 448, 384, 64, 64));

        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 0, 448, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 64, 448, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 128, 448, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 192, 448, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 256, 448, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 320, 448, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 384, 448, 64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroid, 448, 448, 64, 64));
    }

    private void loadSpritePlayer(GraphicsFW graphicsFW) {
        UtilResource.spritePlayer = new ArrayList<>();
        UtilResource.spritePlayerBoost = new ArrayList<>();
        UtilResource.spriteExplosionPlayer = new ArrayList<>();

        UtilResource.spritePlayer.add(graphicsFW.createSprite(UtilResource.textureAtlas, 0, 0, 64, 64));
        UtilResource.spritePlayer.add(graphicsFW.createSprite(UtilResource.textureAtlas, 64, 0, 64, 64));
        UtilResource.spritePlayer.add(graphicsFW.createSprite(UtilResource.textureAtlas, 128, 0, 64, 64));
        UtilResource.spritePlayer.add(graphicsFW.createSprite(UtilResource.textureAtlas, 192, 0, 64, 64));

        UtilResource.spritePlayerBoost.add(graphicsFW.createSprite(UtilResource.textureAtlas, 0, 64, 64, 64));
        UtilResource.spritePlayerBoost.add(graphicsFW.createSprite(UtilResource.textureAtlas, 64, 64, 64, 64));
        UtilResource.spritePlayerBoost.add(graphicsFW.createSprite(UtilResource.textureAtlas, 128, 64, 64, 64));
        UtilResource.spritePlayerBoost.add(graphicsFW.createSprite(UtilResource.textureAtlas, 192, 64, 64, 64));

        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 0, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 64, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 128, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 192, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 256, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 320, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 384, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 448, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 512, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 576, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 640, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 704, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 768, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 832, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 896, 0, 64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.createSprite(UtilResource.textureAtlasAsteroidExplosion, 960, 0, 64, 64));
    }

    private void loadTexture(GraphicsFW graphicsFW) {
        UtilResource.textureAtlasHeal = graphicsFW.createTexture("sprite-heal.png");
        UtilResource.textureAtlas = graphicsFW.createTexture("texture_atlas.png");
        UtilResource.textureAtlasAsteroid = graphicsFW.createTexture("asteroid.png");
        UtilResource.textureAtlasAsteroidExplosion = graphicsFW.createTexture("asset_asteroid_explosion.png");
    }
}