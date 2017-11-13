package m2.vv.tutorial.collections;

import org.hamcrest.Matcher;

public class StackMatchers {

    public static <T>  Matcher<T> onTopOf(BoundedStack<T> stack) {
        return new OnTopMatcher<>(stack);
    }

    public static <T> Matcher<BoundedStack<T>>  hasPeek(T expected) {
        return new HasPeekMatcher<>(expected);
    }

}
