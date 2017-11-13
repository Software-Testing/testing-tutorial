package m2.vv.tutorial.collections;

import m2.vv.tutorial.collections.exceptions.StackOverflowException;
import m2.vv.tutorial.collections.exceptions.StackUnderflowException;

import org.junit.*;
import static org.junit.Assert.*;


public class BoundedStackTest {

    @Test
    public void shouldBeEmptyAfterCreation() {
        BoundedStack<String> stack = new BoundedStack<>(String.class);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void shouldHaveOneElement() throws StackOverflowException {
        BoundedStack<String> stack = new BoundedStack<>(String.class);
        stack.push("stack");
        assertTrue(stack.size() == 1);
    }

    @Test
    public void shouldBeOnTopAfterPushing() throws StackOverflowException, StackUnderflowException {
        BoundedStack<String> stack = new BoundedStack<>(String.class);
        String item = "jUnit";
        stack.push(item);
        assertTrue(item == stack.peek());
        //This is not exactly equivalent. TASK: Give such a scenario
        assertEquals(item, stack.peek());
        //This would be equivalent
        assertSame(item, stack.peek());
    }

    @Test
    public void shouldGetTheSameAfterPop() throws StackOverflowException, StackUnderflowException {
        BoundedStack<String> stack = new BoundedStack<>(String.class);
        String item = "something";
        stack.push(item);
        assertSame(item, stack.pop());
    }

    @Test
    public void shouldTheFirstBeTheLast() throws StackOverflowException, StackUnderflowException {
        String[] elements = { "A", "B", "C", "D", "E" };
        BoundedStack<String> stack = new BoundedStack<>(String.class);
        stack.pushAll(elements);
        for(int i = elements.length-1; i > 0; i--) {
            assertEquals(elements[i], stack.pop());
            //Task: Include a message providing more information about the values involved
        }

    }

    @Test(expected = StackUnderflowException.class)
    public void shouldNotRetrieveAnythingFromAnEmptyStack() throws StackUnderflowException {
        BoundedStack<String> stack = new BoundedStack<>(String.class);
        stack.pop();
    }

    @Test(timeout = 100)
    public void shoudlBeFast() throws StackOverflowException, StackUnderflowException {
        //BEWARE OF TIMEOUTS -> They might bring flaky tests
        //TASk: At which interval this test case fails?
        BoundedStack<String> stack = new BoundedStack<>(String.class);
        for(int it = 0; it < 1000000; it++) {
            stack.push("something");
            stack.pop();
        }
    }

    //TASK: Add tests to increase coverage

}