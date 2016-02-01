package lib;

import java.util.ArrayList;
import lib.exception.*;

/**
 * Defines a pneumatics system: Tanks and Pistons
 */
public class Pneumatics {

  /**
   * Keep track of tanks
   */
  public ArrayList<Tank> tanks;

  /**
   * Keep track of pistons
   */
  public ArrayList<Piston> pistons;
  
  /**
   * 0 argument constructor: Instantiates arraylists for tanks and pistons
   */
  public Pneumatics() {
    tanks = new ArrayList<Tank>();
    pistons = new ArrayList<Piston>();
  }

  /**
   * Get's system's pressure
   * @return Double pressure
   */
  public Double getPressure() {
    Double sum = 0.0;
    for(Tank tank : tanks) {
      sum += tank.getPressure();
    }
    return sum / tanks.size();
  }
  
  /**
   * Gets a piston reference
   * @param which numerical index
   * @return Piston reference
   */
  public Piston getPiston(Integer which) {
    return pistons.get(which);
  }
  
  /**
   * Gets a tank reference
   * @param which numerical index
   * @return Tank reference
   */
  public Tank getTank(Integer which) {
    return tanks.get(which);
  }
  
  /**
   * Adds a piston to this system
   * @param Piston to add
   */
  public void addPiston(Piston newPiston) {
    pistons.add(newPiston);
    newPiston.registerPneumaticSystem(this);
  }
  
  /**
   * Adds a tank to this system
   * @param Tank to add
   */
  public void addTank(Tank newTank) {
    tanks.add(newTank);
  }
  
  
  /**
   * Pressurize the system by an ammount
   * @param Double value of pressure to add
   * @throws RobotException it overpressurized
   */
  public void pressurize(Double amount) throws RobotException {
    Double perTank = amount;  ///tanks.size();
    try {
      for(Tank tank : tanks) {
        tank.pressurize(perTank);
      }
    } catch (RobotException e) {
      if (e instanceof RobotBrokeException) {
        for(Tank tank : tanks) {
          tank.depressurize(tank.getPressure());
        }
        throw e;
      }
    }
  }
  
  /**
   * Depressurize the system by an ammount
   * @param Double value of pressure to remove
   * @throws OutOfAirException it out of air
   */
  public void depressurize(Double amount) throws OutOfAirException {
    Double perTank = amount/(tanks.size()*2);
    for (Tank tank : tanks) {
      if (tank.getPressure() == 0.0) {
        throw new OutOfAirException("Tank out of air");
      }
      tank.depressurize(perTank);
    }
  }
  
  /**
   * Fills the tanks
   */
  public void fillAll() throws RobotException {
    for(Tank tank : tanks) {
      Double pressure = 0.0;
      pressure = 100.0 - tank.getPressure();
      tank.pressurize(pressure);
    }
  }
  
  
  /**
   * Logs the state to the console
   */
  public void printState(String name) {
    System.out.printf("[%s%s%s]: Pressure: %f\n", TerminalColor.GREEN, name, TerminalColor.RESET, getPressure());
  }

}