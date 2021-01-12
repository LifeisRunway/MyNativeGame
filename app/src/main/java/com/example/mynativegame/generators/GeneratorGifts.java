package com.example.mynativegame.generators;

public class GeneratorGifts {
  
  Protector protector;
  UtilTimerDelay timerProtector;
  
  private int maxScreenX;
  private int maxScreenY;
  private int minScreenX;
  private int minScreenY;
  
  public GeneratorGifts(int sceneWidth, int sceneHeight, int minScreenY) {
    this.maxScreenX = sceneWidth;
    this.maxScreenY = sceneHeight;
    this.minScreenY = minScreenY;
    minScreenX = 0;
    protector = new Protector(maxScreenX, maxScreenY, minScreenY);
    timerProtector = new UtilTimerDelay();
    timerProtector.startTimer();
  }
  
  public void update(float speedPlayer) {
    if(timerProtector.timerDelay(8) && (!MainPlayer.isShieldsOn())) {
      protector.update(speedPlayer);
      if(protector.getX() < minScreenX) {
        protector = null;
        protector = new Protector(maxScreenX, maxScreenY, minScreenY);
        timerProtector.startTimer();
      }
    } 
  }
    
  public void drawing (GraphicsFW graphicsFW) {
       protector.drawing(graphicsFW);
  }
  
}
