package benchmarks;

import algo.sort.MergeSort;
import algo.sort.QuickSort;
import org.openjdk.jmh.annotations.*;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 3, time = 1)
@Fork(1)
public class SortingBenchmark {

    @Param({"1000", "10000", "50000"})
    private int size;

    private int[] data;

    @Setup(Level.Iteration)
    public void setup() {
        Random rnd = new Random(42);
        data = rnd.ints(size, 0, Integer.MAX_VALUE).toArray();
    }

    @Benchmark
    public int[] mergeSort() {
        int[] copy = data.clone();
        MergeSort.sort(copy);
        return copy;
    }

    @Benchmark
    public int[] quickSort() {
        int[] copy = data.clone();
        QuickSort.sort(copy);
        return copy;
    }

    @Benchmark
    public int[] arraysSort() {
        int[] copy = data.clone();
        Arrays.sort(copy);
        return copy;
    }
}

