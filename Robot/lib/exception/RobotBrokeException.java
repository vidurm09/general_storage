package lib.exception;

public class RobotBrokeException extends RobotException {
     public RobotBrokeException(String message) {
          super("ERROR: ROBOT BROKE!!!! " + message);
     }
}