package main.java;

import algo.sort.MergeSort;
import algo.sort.QuickSort;
import algo.sort.select.DeterministicSelect;
import geometry.ClosestPair;
import geometry.Point;
import util.Metrics;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Divide and Conquer Algorithms Demo ===\n");

        // Demo 1: Sorting Algorithms
        demoSortingAlgorithms();

        // Demo 2: Selection Algorithm
        demoSelectionAlgorithm();

        // Demo 3: Geometric Algorithm
        demoGeometricAlgorithm();

        // Demo 4: Performance Comparison
        demoPerformanceComparison();
    }

    private static void demoSortingAlgorithms() {
        System.out.println("1. SORTING ALGORITHMS DEMO");
        System.out.println("--------------------------");

        int[] originalArray = {64, 34, 25, 12, 22, 11, 90, 5};
        System.out.println("Original array: " + Arrays.toString(originalArray));

        // MergeSort Demo
        int[] mergeSortArray = originalArray.clone();
        Metrics.reset();
        MergeSort.sort(mergeSortArray);
        System.out.println("MergeSort result: " + Arrays.toString(mergeSortArray));
        System.out.println("  Comparisons: " + Metrics.getComparisons() + ", Max Depth: " + Metrics.getMaxDepth());

        // QuickSort Demo
        int[] quickSortArray = originalArray.clone();
        Metrics.reset();
        QuickSort.sort(quickSortArray);
        System.out.println("QuickSort result: " + Arrays.toString(quickSortArray));
        System.out.println("  Comparisons: " + Metrics.getComparisons() + ", Max Depth: " + Metrics.getMaxDepth());

        System.out.println();
    }

    private static void demoSelectionAlgorithm() {
        System.out.println("2. SELECTION ALGORITHM DEMO");
        System.out.println("---------------------------");

        int[] array = {7, 10, 4, 3, 20, 15, 8};
        System.out.println("Array: " + Arrays.toString(array));

        for (int k = 0; k < array.length; k++) {
            int[] copy = array.clone();
            int kthSmallest = DeterministicSelect.select(copy, k);
            System.out.printf("  %d-th smallest element: %d%n", k, kthSmallest);
        }

        System.out.println();
    }

    private static void demoGeometricAlgorithm() {
        System.out.println("3. GEOMETRIC ALGORITHM DEMO");
        System.out.println("---------------------------");

        Point[] points = {
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };

        System.out.println("Points: ");
        for (Point p : points) {
            System.out.printf("  (%.1f, %.1f)%n", p.x, p.y);
        }

        var result = ClosestPair.findClosest(points);
        if (result != null) {
            System.out.printf("Closest pair: (%.1f, %.1f) and (%.1f, %.1f)%n",
                    result.p1.x, result.p1.y, result.p2.x, result.p2.y);
            System.out.printf("Distance: %.3f%n", result.dist);
        }

        System.out.println();
    }

    private static void demoPerformanceComparison() {
        System.out.println("4. PERFORMANCE COMPARISON");
        System.out.println("-------------------------");

        int size = 1000;
        Random rnd = new Random(42);
        int[] testData = rnd.ints(size, 0, 10000).toArray();

        // MergeSort performance
        int[] data1 = testData.clone();
        long start = System.nanoTime();
        MergeSort.sort(data1);
        long mergeTime = System.nanoTime() - start;

        // QuickSort performance
        int[] data2 = testData.clone();
        start = System.nanoTime();
        QuickSort.sort(data2);
        long quickTime = System.nanoTime() - start;

        // Arrays.sort performance
        int[] data3 = testData.clone();
        start = System.nanoTime();
        Arrays.sort(data3);
        long arraysTime = System.nanoTime() - start;

        System.out.printf("Sorting %d elements:%n", size);
        System.out.printf("  MergeSort:  %8d ns%n", mergeTime);
        System.out.printf("  QuickSort:  %8d ns%n", quickTime);
        System.out.printf("  Arrays.sort:%8d ns%n", arraysTime);

        // Selection performance
        int k = size / 2;
        int[] data4 = testData.clone();
        start = System.nanoTime();
        int selectResult = DeterministicSelect.select(data4, k);
        long selectTime = System.nanoTime() - start;

        int[] data5 = testData.clone();
        start = System.nanoTime();
        Arrays.sort(data5);
        int sortPickResult = data5[k];
        long sortPickTime = System.nanoTime() - start;

        System.out.printf("\nFinding %d-th smallest element:%n", k);
        System.out.printf("  DeterministicSelect: %8d ns (result: %d)%n", selectTime, selectResult);
        System.out.printf("  Sort and pick:       %8d ns (result: %d)%n", sortPickTime, sortPickResult);

        System.out.println("\n=== Demo Completed ===");
    }
}