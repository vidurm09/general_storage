package lib;
/**
 * Interface Measurable is used by systems that can be quantified absolutley.
 * Thus, sensors are measurable and axels are also measurable (by an encoder)
 */
public interface Measurable {

  /**
   * Measures the system
   * @return any double value representing the absolute measurment of the system
   */
  public Double measure();

}