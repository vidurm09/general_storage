package lib;

import lib.exception.RobotBrokeException;
/**
 * Tank
 * Simulates an airtank used in a pneumatics system
 */
public class Tank {
  /**
   * Stores pressure
   */
  private Double pressure;
  
  /**
   * Is the tank still alive?
   */
  private boolean isExploded = false;

  /**
   * Max tank pressure
   */
  private static Double MAX_PRESSURE = 100.0;

  /**
   * Starts tank with 0 pressure
   */
  public Tank() {
    pressure = 0.0;
  }
  
  /**
   * Returns pressure
   * @return Double pressure
   */
  public Double getPressure() {
    return pressure;
  }

  /**
   * Pressurize a tank
   * @param toPressure, additive pressure
   * @throws RobotBrokeException if it explodes
   */
  public void pressurize(Double toPressure) throws RobotBrokeException {
      if(!isExploded) {
        pressure += toPressure;
        if(pressure > 120.0) {
          pressure = 0.0;
          if(!isExploded) { isExploded = !isExploded; }
          throw new RobotBrokeException("Over-Pressurized! Tank Exploded!");
        }
      }
  }

  /**
   * Depressurize a tank
   * @param toPressure, amount of pressure to remove
   */
  public void depressurize(Double toPressure) {
    pressure -= toPressure;
    if(pressure < 0.0) {
      pressure = 0.0;
    }
  }

}