package m2.vv.tutorial.algorithms;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import static m2.vv.tutorial.algorithms.ReversePolishExpressionEvaluator.evaluate;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class ReversePolishExpressionTest {


    @Parameter(0)
    public String[] expression;

    @Parameter(1)
    public int evaluation;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { new String[] { "2", "3", "+" }, 5 },
                { new String[] { "1", "2", "+", "2", "*"}, 6}
        });
    }

    @Test
    public void testEvaluation() throws MalformedExpressionException {
        assertEquals(evaluation, evaluate(expression));
    }

}