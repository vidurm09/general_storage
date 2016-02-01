package lib.exception;

public class OutOfAirException extends RobotException {
     public OutOfAirException(String message) {
          super("Robot is out of air. No piston will move: " + message);
     }
}