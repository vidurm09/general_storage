package lib;
/**
 * Rotatable
 * Defines an object that can be rotated by another object (I.E. A motor can rotate an axel)
 */
public interface Rotatable {
     /**
      * Rotate the system N Degrees
      * @param degrees Double
      */
     void rotate(Double degrees);
}