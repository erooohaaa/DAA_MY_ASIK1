package util;

import java.util.Random;

public class ArrayUtils {
    private static final Random rnd = new Random();

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr, int lo, int hi, int pivot) {
        int i = lo;
        int j = hi;
        while (i <= j) {
            while (i <= j && arr[i] < pivot) i++;
            while (i <= j && arr[j] > pivot) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return i - 1;
    }

    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    public static void guardNotNull(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Argument must not be null");
        }
    }
}

