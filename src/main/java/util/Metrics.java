package util;

public class Metrics {
    private long comparisons = 0;
    private long allocations = 0;
    private int currentDepth = 0;
    private int maxDepth = 0;

    public void reset() {
        comparisons = 0;
        allocations = 0;
        currentDepth = 0;
        maxDepth = 0;
    }

    public void incComparisons() { comparisons++; }
    public long getComparisons() { return comparisons; }

    public void incAllocations() { allocations++; }
    public long getAllocations() { return allocations; }

    public void enterRecursion() {
        currentDepth++;
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
    }

    public void leaveRecursion() { currentDepth--; }

    public int getMaxDepth() { return maxDepth; }
}
