package lib;

import java.util.ArrayList;
import lib.exception.*;


/**
 * Piston
 * Simulates a piston and also it's effect on air pressure
 */
public class Piston {
  
  /**
   * Store associated Pneumatics system
   */
  Pneumatics pneumaticsSystem;

  /**
   * Only warn out of air once
   */
  private boolean hasWarned = false;


  /**
   * Constant of pressure consumed during a stroke
   */
  private Double PRESSURE_PER_STROKE = 1.62;

  /**
   * On or Off
   */
  private boolean state;


  /**
   * Extend the piston if it is not, and subtract air pressure from pneumatics system
   */
  public void extend() {
    if (pneumaticsSystem != null && !state) {
      try {
        pneumaticsSystem.depressurize(PRESSURE_PER_STROKE);
        state = true;
      } catch (OutOfAirException e) {
        if (!hasWarned) {
          System.out.println("[Warning]: Robot out of air");
          hasWarned = true;
        }
      }
    }
  }

  /**
   * Retract the piston if it is not, and subtract air pressure from pneumatics system
   */
  public void retract() {
    if (pneumaticsSystem != null && state) {
      try {
        pneumaticsSystem.depressurize(PRESSURE_PER_STROKE);
        state = false;
      } catch (OutOfAirException e) {
        if (!hasWarned) {
          System.out.println("[Warning]: Robot out of air");
          hasWarned = true;
        }
      }
    }
  }

  /**
   * Return the state
   */
  public boolean state() {
  return state;
  }
  
  /**
   * Register this piston to a pneumatics System
   */
  public void registerPneumaticSystem(Pneumatics p) {
    pneumaticsSystem = p;
  }

}