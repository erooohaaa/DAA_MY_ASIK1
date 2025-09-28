package benchmarks;

import algo.sort.select.DeterministicSelect;
import org.openjdk.jmh.annotations.*;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(2)
public class SelectionBenchmark {

    @Param({"1000", "10000", "100000"})
    private int size;

    private int[] data;
    private int k;

    @Setup(Level.Iteration)
    public void setup() {
        Random rnd = new Random(42);
        data = rnd.ints(size, 0, size * 10).toArray();
        k = size / 2;
    }

    @Benchmark
    public int deterministicSelect() {
        return DeterministicSelect.select(data.clone(), k);
    }

    @Benchmark
    public int sortAndPick() {
        int[] copy = data.clone();
        Arrays.sort(copy);
        return copy[k];
    }
}


