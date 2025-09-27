package algo.sort;

import org.junit.jupiter.api.Test;
import util.Metrics;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    @Test
    void testSmallArray() {
        int[] arr = {5, 3, 8, 1, 2};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        Metrics.reset();
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);

        System.out.println("SmallArray -> comparisons=" + Metrics.getComparisons() +
                ", maxDepth=" + Metrics.getMaxDepth());
    }

    @Test
    void testRandomArray() {
        Random rnd = new Random(42);
        int[] arr = rnd.ints(1000, -1000, 1000).toArray();
        int[] expected = arr.clone();
        Arrays.sort(expected);

        Metrics.reset();
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);

        System.out.println("RandomArray -> comparisons=" + Metrics.getComparisons() +
                ", maxDepth=" + Metrics.getMaxDepth());
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = arr.clone();

        Metrics.reset();
        MergeSort.sort(arr);
        assertArrayEquals(expected, arr);

        System.out.println("AlreadySorted -> comparisons=" + Metrics.getComparisons() +
                ", maxDepth=" + Metrics.getMaxDepth());
    }
}
