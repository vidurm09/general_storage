package lib;
/** Joystick on Controller */
public class ControllerJoystick {
  /** X position */
  private Integer valueX;
  /** Y position */
  private Integer valueY;
  /** 
   * Returns x-position
   * @return x-position
   */ 
  public Integer valX() {
    return valueX;
  }
  /**
   * Returns y-position
   * @return y-position
   */ 
  public Integer valY() {
    return valueY;
  }
  /**
   * Sets x-position
   * @param val Value for x-position
   */ 
  public void valX(Integer val) {
    valueX = val;
  }
  /**
   * Sets y-position
   * @param val Value for y-position
   */ 
  public void valY(Integer val) {
    valueY = val;
  }
  /** 
   * Sets x and y-positions
   * @params val Array for positions [x,y]
   */ 
  public void valXY(int val[]) {
    valueX = val[0];
    valueY = val[1];
  }

}