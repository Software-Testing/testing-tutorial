package m2.vv.tutorial.collections;

import org.junit.*;
import static org.junit.Assert.*;

public class SillyTest {

    @Ignore
    @Test
    public void shouldFail ()
    {
        fail("Always fail");
    }

    @Test
    public void willThisWork()
    {
        //assertTrue(0.4*3 == 1.2);
        assertEquals(0.4 * 3, 1.2, 0.0000001);

    }

}
