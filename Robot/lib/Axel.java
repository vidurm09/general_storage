package lib;

import java.util.ArrayList;


/**
 * Axel Class. Attach Gears, Encoders, and Motors to an Axel. Moves, can be moved, and transfers movement
 */ 
public class Axel implements Rotatable, Measurable {
     /** All objects attached to the Axel */
     private ArrayList<Rotatable> attached = new ArrayList<Rotatable>();
     /** Stores the total degrees moved */
     private Double tot_deg = 0.0;
     /**
      * Used to rotate the axel, affects all attached Rotatable objects (Gears, Encoders). Accessed by motor
      * @param degrees Degrees movement of the axel
      */ 
     public void rotate(Double degrees) {
          tot_deg+=degrees;
          for (Rotatable thing : attached) {
               thing.rotate(degrees);
          }
     }
     /**
      * Used to attach Rotatable to axel
      * @param r Rotatable to attach to axel
      */ 
     public void attach(Rotatable r) {
          attached.add(r);
     }
     /**
      * Returns the total rotation of the axel. Used by Encoder
      * @return Total degrees moved by axel
      */ 
     public Double measure() {
          return tot_deg;
     }
}