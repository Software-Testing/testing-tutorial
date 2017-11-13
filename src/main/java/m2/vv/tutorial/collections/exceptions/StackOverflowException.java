package m2.vv.tutorial.collections.exceptions;

public class StackOverflowException extends Exception {



    public StackOverflowException() {
        super("The stack reached its maximum capacity");
    }

    public StackOverflowException(String message) {
        super(message);
    }
}
