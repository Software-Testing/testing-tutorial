package m2.vv.tutorial;

import m2.vv.tutorial.collections.BoundedStack;
import m2.vv.tutorial.collections.exceptions.StackOverflowException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static m2.vv.tutorial.collections.StackMatchers.hasPeek;
import static m2.vv.tutorial.collections.StackMatchers.onTopOf;

import static org.hamcrest.MatcherAssert.assertThat;


import static org.hamcrest.Matchers.*;



public class HamcrestTest {

    private static final long SEED = 12345;

    @Test
    public void testDoubleEquality() {
        assertThat(0.4 * 3, closeTo(1.2, 1.0E-10));
//        assertThat(0.4 * 3, is(closeTo(1.2, 1.0E-10)));
    }


    @Test
    public void testMatchers() {

        Random rd = new Random(SEED);
        int bound = 10;
        int result = rd.nextInt(bound);
        assertThat(result, is(lessThan(bound)));

    }

    @Test
    public void testEmptyArray() {
        assertThat(new Integer[0], emptyArray());
    }


    @Test
    public void testEmptyIntersection() {
        Set<String>  a = new HashSet<>();
        a.add("A");
        a.add("B");
        Set<String> b = new HashSet<>();
        b.add("C");
        a.retainAll(b);
        assertThat(a , empty());
    }

    @Test
    public void testIntersection() {
        Set<String>  a = new HashSet<>();
        a.add("A");
        a.add("B");
        a.add("C");
        Set<String> b = new HashSet<>();
        b.add("C");
        a.retainAll(b);

        assertThat(a, both(hasSize(1)).and(contains("C")));
    }

    @Test
    public void testReuse() {

        ArrayList<String> array = new ArrayList<>();
        array.add("something");


        HashSet<Integer> set = new HashSet<>();
        set.add(1);


        assertThat(array, hasSize(1));
        assertThat(set, hasSize(1));

    }


    @Test
    public void testPeek() throws StackOverflowException {
        BoundedStack<String> stack = new BoundedStack<>(String.class);
        stack.push("A");
        assertThat("A", is(onTopOf(stack)));

    }

    @Test
    public void testTheSame() throws StackOverflowException {
        BoundedStack<String> stack = new BoundedStack<>(String.class);
        stack.push("A");
        assertThat(stack, hasPeek("A"));
    }





}
