package lib;
import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

/**
 * Generic Robot Template (Abstract Class)
 * All robots that are created must extend this file
 */
public abstract class Robot {

  /**
   * Default robot state
   */
  public State state = State.STOP;
  
  /**
   * keep track of this instace
   */
  public Robot thisRobot;
  
  /**
   * iteration counter
   */
  public Integer iteration = 0;
  
  /**
   * Set the maximum number of iterations, -1 is no limit
   */
  public int iteration_maximum = -1;
  
  /**
   * log level
   */
  public LoggerLevel loglevel = LoggerLevel.NONE;
  
  /**
   * Iteration Delay, default
   */
  public static int delay = 10;
  
  /**
   * Timer that is used to iterate robot
   */
  Timer timer;

  /**
   * Zero-Argument Constructor
   */
  public Robot(){
    thisRobot = this;
  }
  
  /**
   * Return milliseconds the robot has run
   * @return int milliseconds
   */
  public int getMillis() {
    return iteration * delay;
  }
  
  /**
   * set the log level
   * @param LoggerLevel log level
   */
  public void setLoggerLevel(LoggerLevel level) {
    this.loglevel = level;
  }
  
  /**
   * Get formatted time that the robot has run
   * @return String time
   */
  public String getTime() {
    Date date = new Date(getMillis());
    DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
    String dateFormatted = formatter.format(date);
    return dateFormatted;
  }
  
  /**
   * Starts the running of the code and sets iteration delay
   * @param delay
   */
  public void begin(int delay) {
    this.delay = delay;
    begin();
  }
  /**
   * Begin the robot with delay and iteration
   * @param delay
   * @param iter iteration limit
   */
  public void begin(int delay, int iter) {
    iteration_maximum = iter;
    this.delay = delay;
    begin();
  }
  
  /**
   * Begin the robot
   * Assumed 10ms delay and no iter limit if called directly
   */
  private void begin() {
    
    if (state == State.STOP) {
      state = State.START;
      thisRobot.setup();
      state = State.RUN;
      
      timer = new Timer();
       
      timer.scheduleAtFixedRate(new TimerTask() {
              public void run() {
                  iteration++;
                  if (loglevel == LoggerLevel.TIME || loglevel == LoggerLevel.ALL) {
                    System.out.printf("\n===============[%s%s%s]===============\n", TerminalColor.BLUE, getTime(), TerminalColor.RESET);
                  }
                  thisRobot.run();
                  if (iteration_maximum > -1 && iteration >= iteration_maximum) {
                    thisRobot.end();
                  }
              }
          }, 0, delay);
    } else {
      
    }
    
  }
  
  /**
   * Stop the execution of the robot
   */
  public void end() {
    timer.cancel();
    state = State.STOP;
    finish();
  }

  /**
   * Use this to define what runs on the robot every iteration
   */
  protected abstract void run();
  
  /**
   * Use this to run things ONCE when the robot is initially started
   */
  protected abstract void setup();

  /**
   * Use this to run something once when the robot ends execution
   */
  protected abstract void finish();

}