package m2.vv.tutorial;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import m2.vv.tutorial.collections.BoundedStack;
import m2.vv.tutorial.collections.exceptions.StackOverflowException;
import m2.vv.tutorial.collections.exceptions.StackUnderflowException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class CucumberStepDefinitions {

    private BoundedStack<Integer> stack;

    @Given("a new stack")
    public void given_a_new_stack() {
        stack = new BoundedStack<>(Integer.class);
    }

    @When("(\\d+) is pushed")
    public void when_an_integer_is_pushed(int integer)  throws StackOverflowException {
        stack.push(integer);
    }

    @Then("(\\d+) should be on top")
    public void integer_value_should_be_on_top(int integer) throws StackUnderflowException {
        assertSame(integer, stack.peek());
    }

    @Then("it should be empty")
    public void stack_should_be_empty() {
        assertTrue(stack.isEmpty());
    }

    @Then("it should have (\\d+) elements")
    public void stack_should_have_elements(int count) {
        assertEquals(count, stack.size());
    }

    @When("an element is popped")
    public void when_an_element_is_popped() throws StackUnderflowException{
        stack.pop();
    }

}
