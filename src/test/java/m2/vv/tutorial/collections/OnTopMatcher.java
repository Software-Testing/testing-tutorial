package m2.vv.tutorial.collections;

import m2.vv.tutorial.collections.exceptions.StackUnderflowException;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class OnTopMatcher<T> implements Matcher<T> {

    private final BoundedStack<T> stack;

    public OnTopMatcher(BoundedStack<T> stack) {
        this.stack = stack;
    }

    private T peek() {
        try {
            return stack.peek();
        }catch(StackUnderflowException exc) {
            throw new AssertionError("This should not happen as the size is being checked in advance");
        }
    }

    @Override
    public boolean matches(Object item) {
        if(stack.isEmpty()) return false;
        return item == peek();
    }

    @Override
    public void describeMismatch(Object item, Description mismatchDescription) {

        if(stack.isEmpty())
            mismatchDescription.appendText("the stack was empty");
        else {
            mismatchDescription.appendValue(peek()).appendText(" was on top of the stack instead of ").appendValue(item);
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(" the given element on top of the stack");
    }

    @Override
    @Deprecated
    public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {

    }
}
