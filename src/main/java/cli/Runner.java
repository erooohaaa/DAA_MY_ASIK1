package cli;

import algo.sort.MergeSort;
import algo.sort.QuickSort;
import algo.sort.select.DeterministicSelect;
import geometry.ClosestPair;
import geometry.Point;
import util.Metrics;
import util.CSVWriter;

import java.io.IOException;
import java.util.Random;

public class Runner {
    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.out.println("Usage: java cli.Runner <algorithm> <inputSize> <trials> [output.csv]");
            return;
        }

        String algorithm = args[0];
        int n = Integer.parseInt(args[1]);
        int trials = Integer.parseInt(args[2]);
        String outputFile = args.length > 3 ? args[3] : "results.csv";

        try (CSVWriter writer = new CSVWriter(outputFile)) {
            for (int t = 1; t <= trials; t++) {
                Metrics.reset();
                long time = runAlgorithm(algorithm, n);


                long comparisons = Metrics.getComparisons();
                int depth = Metrics.getMaxDepth();
                long allocations = 0;
                writer.writeRow(n, algorithm, time / 1_000_000, comparisons, allocations, depth);
            }
        }

        System.out.println("Results written to " + outputFile);
    }

    private static long runAlgorithm(String algorithm, int n) {
        Random rnd = new Random();
        long start, end;

        switch (algorithm.toLowerCase()) {
            case "mergesort":
                int[] arr1 = rnd.ints(n, 0, 100000).toArray();
                start = System.nanoTime();
                MergeSort.sort(arr1);
                end = System.nanoTime();
                break;

            case "quicksort":
                int[] arr2 = rnd.ints(n, 0, 100000).toArray();
                start = System.nanoTime();
                QuickSort.sort(arr2);
                end = System.nanoTime();
                break;

            case "select":
                int[] arr3 = rnd.ints(n, 0, 100000).toArray();
                int k = n / 2;
                start = System.nanoTime();
                DeterministicSelect.select(arr3, k);
                end = System.nanoTime();
                break;

            case "closestpair":
                Point[] pts = new Point[n];
                for (int i = 0; i < n; i++) {
                    pts[i] = new Point(rnd.nextDouble() * 1000, rnd.nextDouble() * 1000);
                }
                start = System.nanoTime();
                ClosestPair.findClosest(pts);
                end = System.nanoTime();
                break;

            default:
                throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }
        return end - start;
    }
}
