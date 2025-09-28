package geometry;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static ClosestPairResult findClosest(Point[] points) {
        if (points == null || points.length < 2) {
            return null;
        }
        Point[] sortedByX = points.clone();
        Arrays.sort(sortedByX, Comparator.comparingDouble(p -> p.x));
        Point[] aux = new Point[points.length];
        return findClosest(sortedByX, aux, 0, points.length - 1);
    }

    private static ClosestPairResult findClosest(Point[] points, Point[] aux, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(points, left, right);
        }

        int mid = (left + right) / 2;
        Point midPoint = points[mid];

        ClosestPairResult leftResult = findClosest(points, aux, left, mid);
        ClosestPairResult rightResult = findClosest(points, aux, mid + 1, right);

        ClosestPairResult best = (leftResult.dist <= rightResult.dist) ? leftResult : rightResult;
        double delta = best.dist;

        mergeByY(points, aux, left, mid, right);


        int stripSize = 0;
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midPoint.x) < delta) {
                aux[stripSize++] = points[i];
            }
        }


        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (aux[j].y - aux[i].y) < delta; j++) {
                double d = distance(aux[i], aux[j]);
                if (d < best.dist) {
                    best = new ClosestPairResult(aux[i], aux[j], d);
                    delta = d;
                }
            }
        }

        return best;
    }

    private static void mergeByY(Point[] points, Point[] aux, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (points[i].y <= points[j].y) aux[k++] = points[i++];
            else aux[k++] = points[j++];
        }
        while (i <= mid) aux[k++] = points[i++];
        while (j <= right) aux[k++] = points[j++];


        System.arraycopy(aux, 0, points, left, k);
    }


    private static ClosestPairResult bruteForce(Point[] points, int left, int right) {
        double min = Double.POSITIVE_INFINITY;
        Point a = null, b = null;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                double d = distance(points[i], points[j]);
                if (d < min) {
                    min = d;
                    a = points[i];
                    b = points[j];
                }
            }
        }
        return new ClosestPairResult(a, b, min);
    }

    private static double distance(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
