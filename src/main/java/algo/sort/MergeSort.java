package algo.sort;

import util.Metrics;
import java.util.Arrays;

public class MergeSort {

    private static final int CUTOFF = 16;

    public static void sort(int[] a) {
        int[] buffer = new int[a.length];
        sort(a, buffer, 0, a.length - 1, 1);
    }

    private static void sort(int[] a, int[] buffer, int lo, int hi, int depth) {
        Metrics.updateDepth(depth);

        if (hi - lo + 1 <= CUTOFF) {
            insertionSort(a, lo, hi);
            return;
        }

        int mid = (lo + hi) >>> 1;
        sort(a, buffer, lo, mid, depth + 1);
        sort(a, buffer, mid + 1, hi, depth + 1);
        merge(a, buffer, lo, mid, hi);
    }

    private static void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= lo && Metrics.compare(a[j], key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    private static void merge(int[] a, int[] buffer, int lo, int mid, int hi) {
        System.arraycopy(a, lo, buffer, lo, hi - lo + 1);

        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            if (Metrics.compare(buffer[i], buffer[j]) <= 0) {
                a[k++] = buffer[i++];
            } else {
                a[k++] = buffer[j++];
            }
        }
        while (i <= mid) a[k++] = buffer[i++];
        while (j <= hi) a[k++] = buffer[j++];
    }
}
