package m2.vv.tutorial.collections.exceptions;

public class StackUnderflowException extends Exception {

    public StackUnderflowException() {
        super("Attempting to remove an element from an empty stack");
    }
}
