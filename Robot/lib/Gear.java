package lib;
import java.util.ArrayList;
/** Gear gets moved by Axel and/or Gears. Can move other Gears */
public class Gear implements Rotatable {
     /** Number of teeth */
     private int teeth;
     /** Axels and/or geats attached to Gear */
     private ArrayList<Rotatable> attached = new ArrayList<Rotatable>();
     /**
      * Contructs Gear 
      * @param teeth Teeth on Gear
      */ 
     public Gear(int teeth) {
          this.teeth = teeth;
     }
     /**
      * Get number of teeth on Gear
      * @return number of teech on Gear
      */ 
     public int getTeeth() {
          return teeth;
     }
     /** 
      * Rotate Gear when driven by axel (and everything attached to it) X degrees
      * @param degrees, degrees to rotate
      * @return degrees Degrees to move the Gear
      */ 
     public void rotate (Double degrees) {
          for (Rotatable thing : attached) {
               if (thing.getClass().equals(Gear.class)) {
                    //Rotating a gear
                    Gear oGear = (Gear)thing;
                    oGear.rotateOuter(this, degrees /*MARK FOR CONVERSION*/);
               } else {
                    //Rotating an axel
                    thing.rotate(degrees);
               }
          }
     }
     
     /**
      * Rotate gear when driven by another gear.
      * Thus, the axel would be the output and the gear teeth the input. The Converse is true for void rotate();
      * THIS METHOD IS USED INTERNALLY BY GEAR
      * @param other Gear object that is used to get the teeth of the other gear
      * @param degrees DOuble value representing gears that the other gear moved in last iteration
      */
     void rotateOuter(Gear other, double degrees) {
          
          //Rotate this gear proportionally based on the degrees the other gear with N teeth moved
          rotate(degrees*(((double)(other.getTeeth()))/((double)(teeth))));
     }
     /**
      * Attach rotatable to Gear
      * @param Rotatable to attach
      */ 
     public void attach (Rotatable other) {
          attached.add(other);
     }
}