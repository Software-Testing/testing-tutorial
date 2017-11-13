package m2.vv.tutorial.algorithms;

import m2.vv.tutorial.collections.BoundedStack;
import m2.vv.tutorial.collections.exceptions.StackOverflowException;
import m2.vv.tutorial.collections.exceptions.StackUnderflowException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class ReversePolishExpressionEvaluator {

    private static Map<String, BiFunction<Integer, Integer, Integer>> operators;

    private static Pattern INT_REO = Pattern.compile("-?[0-9]+");

    static {
        operators = new HashMap<>();
        operators.put("+", (i, j) -> i + j);
        operators.put("-", (i, j) -> i - j);
        operators.put("*", (i, j) -> i * j);
        operators.put("/", (i, j) -> i / j);
    }

    public static int evaluate(String... expression) throws MalformedExpressionException {
        BoundedStack<Integer> stack = new BoundedStack<>(Integer.class, expression.length);
        try {
            for (String item : expression) {
                if (INT_REO.matcher(item).matches()) {
                    stack.push(Integer.parseInt(item));
                } else if (operators.containsKey(item)) {
                    stack.push(operators.get(item).apply(stack.pop(), stack.pop()));
                } else throw new MalformedExpressionException("Unexpected item on expression: " + item);
            }

            return stack.peek();

        } catch (StackUnderflowException exc) {
            throw new MalformedExpressionException();
        } catch (StackOverflowException exc) {
            //This case is not expected as capacity is computed from the expression
            throw new MalformedExpressionException("This case is not expected");
        }
    }

}
