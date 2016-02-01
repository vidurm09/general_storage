import lib.*;
import lib.exception.*;


public class DumbRobot extends Robot {
     Pneumatics pneumaticsSystem;
     Piston fpiston = new Piston();
     Piston spiston = new Piston();
     Tank tank = new Tank();
     Tank tank2 = new Tank();
     VexController input = new VexController();
     
     
     //Testing Gearbox
     Axel a = new Axel();
     Motor m = new TurboMotor(a); //input
     Gear g = new Gear(36);
     Gear secondG = new Gear(12);
     Axel secondA = new Axel();
     Gear thirdG = new Gear(36);
     Gear fourthG = new Gear(12);
     Axel thirdA = new Axel(); //output
     
     
     Encoder enc = new Encoder(thirdA);
     
     
     
     
     protected void run() {
          fpiston.extend();
          fpiston.retract();
          //a.rotate(100.0);
          m.move(127);
          enc.printState("Encoder 1");
          pneumaticsSystem.printState("Pneumatics System");
     }
     
     
     protected void setup() {
          setLoggerLevel(LoggerLevel.TIME);
          try {
               System.out.println(TerminalColor.GREEN + "Set Up!" + TerminalColor.RESET);
               pneumaticsSystem = new Pneumatics();
          
               pneumaticsSystem.addTank(tank);
               pneumaticsSystem.addTank(tank2);
               
               pneumaticsSystem.addPiston(fpiston);
               pneumaticsSystem.addPiston(spiston);
               pneumaticsSystem.pressurize(500.0);
          } catch (RobotException e) {
               System.out.println(e);
          }
          
          //Button tester
          input.clickButton("Btn6U", true);
          System.out.println(input.buttonVal("Btn6U"));
          
          //Set up gearbox
          a.attach(g);
          g.attach(secondG);
          secondG.attach(secondA);
          secondA.attach(thirdG);
          thirdG.attach(fourthG);
          fourthG.attach(thirdA);
          
     }
     protected void finish() {
          System.out.println(TerminalColor.RED + "The End!" + TerminalColor.RESET);
     }
}