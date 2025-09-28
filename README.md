# Divide and Conquer Algorithms Project

## Overview
Implementation and analysis of classic divide-and-conquer algorithms:
- MergeSort
- QuickSort
- Deterministic Select (Median-of-Medians)
- Closest Pair of Points

## Tech Stack
- Java 17
- Maven 3.6+
- 4GB RAM (for large benchmarks)
- JUnit 5 for testing

## Roadmap
- [ ] Metrics (time, depth, comparisons, allocations)
- [ ] MergeSort
- [ ] QuickSort
- [ ] Deterministic Select
- [ ] Closest Pair of Points
- [ ] CLI for experiments
- [ ] Benchmarks (JMH)
- [ ] Report (README.md)


src/
├── main/java/
│   ├── algo/
│   │   ├── sort/
│   │   │   ├── MergeSort.java          # MergeSort implementation
│   │   │   ├── QuickSort.java          # QuickSort implementation  
│   │   │   └── select/
│   │   │       └── DeterministicSelect.java  # Median of Medians
│   │   └── benchmarks/
│   │       ├── SelectionBenchmark.java # Selection algorithms benchmark
│   │       └── SortingBenchmark.java   # Sorting algorithms benchmark
│   ├── cli/
│   │   └── Runner.java                 # Command-line interface
│   ├── geometry/
│   │   ├── ClosestPair.java            # Closest pair algorithm
│   │   ├── ClosestPairResult.java      # Result container
│   │   └── Point.java                  # 2D point representation
│   └── util/
│       ├── ArrayUtils.java             # Array utilities
│       ├── CSVWriter.java              # CSV output
│       ├── Metrics.java                # Performance metrics
│       └── Main.java                   # Main entry point
└── test/java/
    ├── algo/
    │   ├── sort/
    │   │   ├── MergeSortTest.java
    │   │   ├── QuickSortTest.java
    │   │   └── select/
    │   │       └── DeterministicSelectTest.java
    │   └── geometry/
    │       └── ClosestPairTest.java
    └── util/
        └── MetricsTest.java


## Available Algorithms
mergesort - MergeSort algorithm

quicksort - QuickSort algorithm

select - Deterministic selection

closestpair - Closest pair of points

# Run all benchmarks
mvn exec:java -Dexec.mainClass="benchmarks.BenchmarkRunner"

# Run with JMH profile
mvn clean compile integration-test -Pjmh

# Run specific benchmark
mvn exec:java -Dexec.mainClass="org.openjdk.jmh.Main" -Dexec.args="SelectionBenchmark"
##Benchmark Results
The benchmarks compare:

Selection: DeterministicSelect vs Arrays.sort + selection

Sorting: MergeSort vs QuickSort vs Arrays.sort

Performance: Time complexity and real-world performance


##📝 Report
The project includes comprehensive analysis of:

Algorithm correctness and edge cases

Performance characteristics

Memory usage patterns

Comparative analysis between algorithms

Benchmark results and interpretations


