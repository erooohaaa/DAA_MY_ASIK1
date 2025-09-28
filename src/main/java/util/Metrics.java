package util;

public class Metrics {
    private static long comparisons = 0;
    private static int currentDepth = 0;
    private static int maxDepth = 0;

    public static void updateDepth(int depth) {
        currentDepth = depth;
        if (depth > maxDepth) {
            maxDepth = depth;
        }
    }

    public static int compare(int a, int b) {
        comparisons++;
        return Integer.compare(a, b);
    }

    public static void incComparisons() {
        comparisons++;
    }

    public static long getComparisons() {
        return comparisons;
    }

    public static int getMaxDepth() {
        return maxDepth;
    }

    public static void reset() {
        comparisons = 0;
        currentDepth = 0;
        maxDepth = 0;
    }
}

