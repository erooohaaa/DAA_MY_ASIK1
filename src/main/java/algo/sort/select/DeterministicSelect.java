package algo.sort.select;


import util.ArrayUtils;
import util.Metrics;

public class DeterministicSelect {

    public static int select(int[] arr, int k) {
        ArrayUtils.guardNotNull(arr);
        if (k < 0 || k >= arr.length) {
            throw new IllegalArgumentException("k out of range");
        }
        return select(arr, 0, arr.length - 1, k);
    }


    private static int select(int[] arr, int left, int right, int k) {
        while (true) {
            if (left == right) return arr[left];

            int pivot = medianOfMedians(arr, left, right);
            int p = partitionAroundPivot(arr, left, right, pivot);

            if (k == p) return arr[k];
            else if (k < p) right = p - 1;
            else left = p + 1;
        }
    }

    private static int partitionAroundPivot(int[] arr, int left, int right, int pivotValue) {
        int storeIndex = left;
        for (int i = left; i <= right; i++) {
            Metrics.incComparisons();
            if (arr[i] < pivotValue) {
                ArrayUtils.swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        int pivotIndex = storeIndex;
        for (int i = storeIndex; i <= right; i++) {
            Metrics.incComparisons();
            if (arr[i] == pivotValue) {
                ArrayUtils.swap(arr, pivotIndex, i);
                break;
            }
        }
        return pivotIndex;
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n <= 5) {
            insertionSort(arr, left, right);
            return arr[left + n / 2];
        }

        int numMedians = (int) Math.ceil((double) n / 5);
        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            insertionSort(arr, subLeft, subRight);
            int median = arr[subLeft + (subRight - subLeft) / 2];
            ArrayUtils.swap(arr, left + i, subLeft + (subRight - subLeft) / 2);
            arr[left + i] = median;
        }
        return medianOfMedians(arr, left, left + numMedians - 1);
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                Metrics.incComparisons();
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
