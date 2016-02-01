package lib;
import java.lang.reflect.*;

/**
 * A vex controller
 */
public class VexController extends Controller {
     
     /**
      * JOYSTICKS
      */
     public ControllerJoystick leftJoystick;
     public ControllerJoystick rightJoystick;

     /**
      * D-PAD
      */
     public ControllerButton Btn7U;
     public ControllerButton Btn7D;
     public ControllerButton Btn7R;
     public ControllerButton Btn7L;

     /**
      * D-PAD
      */
     public ControllerButton Btn8U;
     public ControllerButton Btn8D;
     public ControllerButton Btn8L;
     public ControllerButton Btn8R;

     /**
      * BUMPER
      */
     public ControllerButton Btn5U;
     public ControllerButton Btn5D;

     /**
      * BUMPER
      */
     public ControllerButton Btn6U;
     public ControllerButton Btn6D;
     
     /**
      * Create the buttons and joysticks
      */
     public VexController() {
          Btn7U = new ControllerButton();
          Btn7D = new ControllerButton();
          Btn7R = new ControllerButton();
          Btn7L = new ControllerButton();
          Btn8U = new ControllerButton();
          Btn8D = new ControllerButton();
          Btn8L = new ControllerButton();
          Btn8R = new ControllerButton();
          Btn5U = new ControllerButton();
          Btn5D = new ControllerButton();
          Btn6U = new ControllerButton();
          Btn6D = new ControllerButton();
          
          buttons.add(Btn7U);
          buttons.add(Btn7D);
          buttons.add(Btn7R);
          buttons.add(Btn7L);
          buttons.add(Btn8U);
          buttons.add(Btn8D);
          buttons.add(Btn8L);
          buttons.add(Btn8R);
          buttons.add(Btn5U);
          buttons.add(Btn5D);
          buttons.add(Btn6U);
          buttons.add(Btn6D);
          
          leftJoystick  = new ControllerJoystick();
          rightJoystick = new ControllerJoystick();
          
          joysticks.add(leftJoystick);
          joysticks.add(rightJoystick);
     }
     
     /**
      * Get a button value
      * @param what which button
      * @return Integer value: 1 or 0
      */
     public Integer buttonVal(String what) {
          try {
               Field field = this.getClass().getField(what);
               if (field.getType() == ControllerButton.class) {
                    return (((ControllerButton)(field.get(this))).val())? 1 : 0;
               } else {
                    return -1;
               }
          } catch (Exception e) {
               System.out.println("in buttonVal: " + e);
          }
          return Integer.MIN_VALUE;
     }
     
     /**
      * Joystick Value
      * @param what which joystick
      * @return Integer[] values: x, y
      */
     public Integer[] joystickVal(String what) {
          try {
               Field field = this.getClass().getField(what);
               if (field.getType() == ControllerJoystick.class) {
                    Integer[] vals = new Integer[2];
                    ControllerJoystick stick = ((ControllerJoystick)(field.get(this)));
                    vals[0] = stick.valX();
                    vals[1] = stick.valY();
                    return vals;
               } else {
                    return new Integer[2];
               }
          } catch (Exception e) {
               System.out.println("in joystickVal: " + e);
          }
          return new Integer[2];
     }
     
     /**
      * Set a button
      * @param which what button
      * @param val boolean on or off
      */
     public void clickButton(String which, boolean val){
          try {
               Field field = this.getClass().getField(which);
               if (field.getType() == ControllerButton.class) {
                    ((ControllerButton)(field.get(this))).val(val);
               } else {
                    System.out.println("Trying to read button value of " + field.getType());
               }
          } catch (Exception e) {
               System.out.println("in clickButton: " + e);
          }
     }
     
     /**
      * Set a joystick
      * @param which what joystick
      * @param int[] x,y vals
      */
     public void setJoystick(String which, int[] vals){
          try {
               Field field = this.getClass().getField(which);
               if (field.getType() == ControllerJoystick.class) {
                    ControllerJoystick stick = ((ControllerJoystick)(field.get(this)));
                    stick.valX(vals[0]);
                    stick.valY(vals[1]);
               } else {
                    System.out.println("Trying to read joystick value of " + field.getType());
               }
          } catch (Exception e) {
               System.out.println("in setJoystick: " + e);
          }
     }
}