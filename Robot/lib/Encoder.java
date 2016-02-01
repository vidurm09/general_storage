package lib;
/** Measures Axel movement */
public class Encoder extends Digital implements Rotatable {
  /** Axel that encoder is on */
  private Axel system;
  /** Degrees measured */
  private Double tot_deg = 0.0;
  /** Ratio between ticks and degrees */
  public final static Double TICKS_PER_DEG = 200.0/86.0;
  /**
   * Contructs encoder class attached to system
   * @param system Axel encoder is attached to
   */ 
  public Encoder(Axel system) {
    attach(system);
  }
  /** Constructs empty encoder not attached to axel */
  public Encoder() {
    
  }
  /**
   * Attach axel to encoder
   * @param system Axel to attach
   */ 
  public void attach(Axel system) {
    this.system = system;
    system.attach(this);
  }
  /**
   * Rotate encoder
   * @param degrees Degrees to move
   */ 
  public void rotate(Double degrees) {
     tot_deg += degrees;
  }
  /** Reset degrees moved */
  public void reset() {
    tot_deg = 0.0;
  }
  /** 
   * Return degrees moved
   * @return Degrees moved
   */ 
  public Integer val() {
    return (int)(tot_deg*TICKS_PER_DEG);
  }
  /** 
   * Prints data about the encoder
   * @param name Name of encoder
   */ 
  public void printState(String name) {
    System.out.printf("[%s%s%s]: Ticks: %d, Calculated Degrees: %.3f \n", TerminalColor.GREEN, name, TerminalColor.RESET, val(), (double)val() / Encoder.TICKS_PER_DEG); //Calculated deg
  }

}