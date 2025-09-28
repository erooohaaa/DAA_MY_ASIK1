package geometry;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPairTest {

    @Test
    void testSimpleCase() {
        Point[] pts = {
                new Point(0, 0),
                new Point(3, 4),
                new Point(7, 7),
                new Point(1, 1)
        };
        ClosestPairResult res = ClosestPair.findClosest(pts);
        assertNotNull(res);
        assertEquals(Math.sqrt(2), res.dist, 1e-9);
    }

    @Test
    void testDuplicates() {
        Point[] pts = {
                new Point(5, 5),
                new Point(5, 5),
                new Point(10, 10)
        };
        ClosestPairResult res = ClosestPair.findClosest(pts);
        assertNotNull(res);
        assertEquals(0.0, res.dist, 1e-9);
    }

    @Test
    void testRandomVsBruteForce() {
        Random rnd = new Random(42);
        int n = 200;
        Point[] pts = new Point[n];
        for (int i = 0; i < n; i++) {
            pts[i] = new Point(rnd.nextDouble() * 1000, rnd.nextDouble() * 1000);
        }

        ClosestPairResult fast = ClosestPair.findClosest(pts);
        ClosestPairResult brute = bruteForce(pts);

        assertNotNull(fast);
        assertNotNull(brute);
        assertEquals(brute.dist, fast.dist, 1e-9);
    }


    private ClosestPairResult bruteForce(Point[] pts) {
        double minDist = Double.POSITIVE_INFINITY;
        Point a = null, b = null;
        for (int i = 0; i < pts.length; i++) {
            for (int j = i + 1; j < pts.length; j++) {
                double d = Math.hypot(pts[i].x - pts[j].x, pts[i].y - pts[j].y);
                if (d < minDist) {
                    minDist = d;
                    a = pts[i];
                    b = pts[j];
                }
            }
        }
        return new ClosestPairResult(a, b, minDist);
    }
}
