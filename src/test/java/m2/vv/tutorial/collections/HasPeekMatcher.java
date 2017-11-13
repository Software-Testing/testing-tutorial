package m2.vv.tutorial.collections;

import m2.vv.tutorial.collections.exceptions.StackUnderflowException;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class HasPeekMatcher<T> implements Matcher<BoundedStack<T>> {


    private final T expectedPeek;

    public HasPeekMatcher(T expectedPeek) {
        this.expectedPeek = expectedPeek;
    }


    private T peek(BoundedStack<T> stack) {
        try{
           return stack.peek();
        }
        catch(StackUnderflowException exc) {
            throw new AssertionError("This should not happen as the size of the stack was verified", exc);
        }
    }

    @Override
    public boolean matches(Object item) {
        BoundedStack<T> stack = ((BoundedStack<T>)item);
        if(stack.isEmpty()) return false;
        return expectedPeek == peek(stack);
    }

    @Override
    public void describeMismatch(Object item, Description mismatchDescription) {
        BoundedStack<T> stack = ((BoundedStack<T>)item);
        if(stack.isEmpty())
            mismatchDescription.appendText("stack was empty");
        else {
            mismatchDescription.appendValue(peek(stack)).appendText(" was found instead of ").appendValue(expectedPeek);
        }


    }

    @Override
    public void describeTo(Description description) {
        description.appendValue(expectedPeek).appendText(" on top of the stack ");

    }

    @Override
    @Deprecated
    public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {

    }
}
