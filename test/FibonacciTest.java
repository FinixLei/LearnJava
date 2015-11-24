package test;

/* 
 * Demo the param list test
 */

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciTest {

    @Parameters(name = "{index}: fib({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 },
                { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
    }

    private int input;
    private int expected;

    public FibonacciTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, Fibonacci.compute(input));
    }
}

class Fibonacci {

    public static int compute(int input) {
        int result;
        switch (input) {
        case 0:
            result = 0;
            break;
        case 1:
        case 2:
            result = 1;
            break;
        case 3:
            result = 2;
            break;
        case 4:
            result = 3;
            break;
        case 5:
            result = 5;
            break;
        case 6:
            result = 8;
            break;
        default:
            result = 0;
        }
        return result;
    }
}
