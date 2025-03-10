package homeworks.homework12.exceptions;

public class UnexpectedCountValueException extends IllegalArgumentException {
    public UnexpectedCountValueException (String message) {
        super(message);
    }
}
