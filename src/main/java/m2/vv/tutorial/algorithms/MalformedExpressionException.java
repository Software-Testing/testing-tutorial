package m2.vv.tutorial.algorithms;

public class MalformedExpressionException extends Exception {

    public MalformedExpressionException() {
        super("Incorrect expression");
    }

    public MalformedExpressionException(String message) {
        super(message);
    }

}
