package lib;

import java.util.ArrayList;

/**
 * Controller Abstract Class. Can be used to implement both VEX and Custom Controllers
 */ 
public abstract class Controller {
  /** Stores all of the controller buttons */
  public ArrayList<ControllerButton> buttons = new ArrayList<ControllerButton>();
  /** Stores all of the controller joysticks */
  public ArrayList<ControllerJoystick> joysticks = new ArrayList<ControllerJoystick>();

}