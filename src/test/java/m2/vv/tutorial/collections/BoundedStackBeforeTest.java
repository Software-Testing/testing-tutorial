package m2.vv.tutorial.collections;

import m2.vv.tutorial.collections.exceptions.StackOverflowException;
import m2.vv.tutorial.collections.exceptions.StackUnderflowException;

import org.junit.*;
import static org.junit.Assert.*;

public class BoundedStackBeforeTest {

    BoundedStack<String> stack;

    @BeforeClass
    public static void executedBeforeAllTests() {
        System.out.println("No test executed yet");
    }

    // This method is executed before each test
    @Before
    public void createTheStack() {
        System.out.println("Creating a new stack");
        stack = new BoundedStack<>(String.class);
    }

    @After
    public void executedAfterEachMethod() {
        System.out.println("Test finished");
    }

    @AfterClass
    public static void executedAtTheEnd() {
        System.out.println("All tests executed");
    }

    @Test
    public void shouldGetTheSameAfterPop() throws StackOverflowException, StackUnderflowException {
        String item = "something";
        stack.push(item);
        assertSame(item, stack.pop());
    }

    @Test
    public void shouldBeEmptyAfterCreation() {
        assertTrue(stack.isEmpty());
    }

    @Test(expected = StackUnderflowException.class)
    public void shouldNotRetrieveAnythingFromAnEmptyStack() throws StackUnderflowException {
        stack.pop();
    }

}
