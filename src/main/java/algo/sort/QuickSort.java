package algo.sort;

import util.Metrics;
import java.util.Random;

public class QuickSort {
    private static final Random rnd = new Random();

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1, 1);
    }

    private static void sort(int[] a, int lo, int hi, int depth) {
        if (lo >= hi) return;

        Metrics.updateDepth(depth);

        int pivotIndex = lo + rnd.nextInt(hi - lo + 1);
        int pivot = a[pivotIndex];
        swap(a, pivotIndex, hi);

        int p = partition(a, lo, hi, pivot);

        int leftSize = p - lo;
        int rightSize = hi - p;

        if (leftSize < rightSize) {
            sort(a, lo, p - 1, depth + 1);
            sort(a, p + 1, hi, depth + 1);
        } else {
            sort(a, p + 1, hi, depth + 1);
            sort(a, lo, p - 1, depth + 1);
        }
    }

    private static int partition(int[] a, int lo, int hi, int pivot) {
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (Metrics.compare(a[j], pivot) < 0) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, hi);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
