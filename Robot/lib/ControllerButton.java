package lib;
/**
 * Buttons for the controller
 */ 
public class ControllerButton {
  /** On/off */
  private boolean value;
  /** 
   * Return button state
   * @return value of the button
   */ 
  public boolean val() {
    return value;
  }
  /**
   * Set value of button
   * @param val Value to set
   */ 
  public void val(boolean val) {
    value = val;
  }
  /**
   * Sets button to opposite of current value
   */ 
  public void opposite() {
    value = !value;
  }
  /**
   * Simulate button press. Sets value to true
   */ 
  public void press() {
    value = true;
  }
  /**
   * Similate button release. Sets value to fals
   */ 
  public void release() {
    value = false;
  }

}