import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MethodClassTest {
    @org.junit.Test
    public void search() throws Exception {
        MethodClass mc = new MethodClass();
        int[] arr = new int[]{1,3,4,5,6,7,8,89,9};
        int actual = mc.search(arr, 9);
        int expected = 8;
        assertEquals(actual,expected);

        actual = mc.search(arr, 6);
        expected = 4;
        assertEquals(expected,actual);
    }

    @Test
    public void recursion() throws Exception {
        MethodClass mc = new MethodClass();
        int[] arr = new int[]{1,2,3};
        int[] actual = mc.recursion(arr);
        int[] expected = new int[]{3,2,1};
        assertArrayEquals(expected,actual);

    }
}