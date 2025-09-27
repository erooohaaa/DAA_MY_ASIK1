package util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MetricsTest {

    @Test
    void testComparisons() {
        Metrics m = new Metrics();
        m.incComparisons();
        m.incComparisons();
        assertEquals(2, m.getComparisons());
    }

    @Test
    void testRecursionDepth() {
        Metrics m = new Metrics();
        m.enterRecursion();
        m.enterRecursion();
        m.leaveRecursion();
        assertEquals(2, m.getMaxDepth());
    }
}
