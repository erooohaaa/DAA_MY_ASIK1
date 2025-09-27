package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MetricsTest {

    @Test
    void testIncComparisons() {
        Metrics.reset();
        Metrics.incComparisons();
        Metrics.incComparisons();
        assertEquals(2, Metrics.getComparisons());
    }

    @Test
    void testCompare() {
        Metrics.reset();
        int result = Metrics.compare(5, 3);
        assertEquals(1, result);
        assertEquals(1, Metrics.getComparisons());
    }

    @Test
    void testUpdateDepth() {
        Metrics.reset();
        Metrics.updateDepth(1);
        Metrics.updateDepth(3);
        Metrics.updateDepth(2);
        assertEquals(3, Metrics.getMaxDepth());
    }

    @Test
    void testReset() {
        Metrics.incComparisons();
        Metrics.updateDepth(5);
        Metrics.reset();
        assertEquals(0, Metrics.getComparisons());
        assertEquals(0, Metrics.getMaxDepth());
    }
}
