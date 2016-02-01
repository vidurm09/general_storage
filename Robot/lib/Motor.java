package lib;

/**
 * Motor abstract class
 * Represents a motor which can rotate an axel and can do so at a certain RPM
 */
public abstract class Motor {

  /**
   * RPM of motor at top speed, set by constructor
   */
  public Double rpm;

  /**
   * POWER, unused
   */
  protected final Integer POWER = 1;
  
  /**
   * Attached Axel: Motor rotates this
   */
  private Axel axel;

  /**
   * Sets the RPM and axel attachment of the motor
   */
  protected Motor(Axel a, Double rpms) {
    axel = a;
    rpm = rpms;
  }
  
  /**
   * Iterative move method that moves an axel N degrees based on RPM and iteration time
   */
  public void move(int speed) {
    axel.rotate(this.rotation(speed));  
  }
  
  /**
   * Calculates the degrees for move method
   */
  private Double rotation(int speed) {
    return (( ((double)Robot.delay) * .1 * (1.0/60.0)) * rpm)*(speed*0.007874015748031482);
  }

}