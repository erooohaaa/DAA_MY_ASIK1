package algo.sort.select;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeterministicSelectTest {

    @Test
    void testSmallArray() {
        int[] arr = {7, 2, 9, 1, 5};
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        for (int k = 0; k < arr.length; k++) {
            int result = DeterministicSelect.select(arr.clone(), k);
            assertEquals(sorted[k], result);
        }
    }

    @Test
    void testRandomArray() {
        Random rnd = new Random(42);
        int[] arr = rnd.ints(200, -1000, 1000).toArray();
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        for (int k = 0; k < 20; k++) { // 20 случайных проверок
            int idx = rnd.nextInt(arr.length);
            int result = DeterministicSelect.select(arr.clone(), idx);
            assertEquals(sorted[idx], result);
        }
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        assertEquals(42, DeterministicSelect.select(arr, 0));
    }
}
