# Divide-and-Conquer Algorithms Project

## Overview
This Java project implements classic divide-and-conquer algorithms with safe recursion patterns, metrics collection, benchmarking, and a CLI interface. All work is version-controlled with Git and properly structured in branches.

**Learning Goals:**
- Implement divide-and-conquer algorithms: MergeSort, QuickSort, Deterministic Select (Median-of-Medians), Closest Pair of Points.
- Analyze running-time recurrences using Master Theorem & Akra-Bazzi intuition.
- Collect metrics (time, recursion depth, comparisons, allocations) and report results.

---

## Algorithms Implemented

1. **MergeSort**
   - Standard merge, reusable buffer, small-array cutoff (insertion sort).

2. **QuickSort**
   - Randomized pivot selection.
   - Recurse on smaller partition first; iterate over larger partition to limit stack depth.

3. **Deterministic Select (Median-of-Medians)**
   - O(n) selection algorithm.
   - Groups of 5, median-of-medians as pivot.
   - In-place partitioning; recurses only into the needed side.

4. **Closest Pair of Points (2D)**
   - O(n log n) algorithm.
   - Sort by x-coordinate, recursive split, strip check by y-order.

---

## Tech Stack
- Java 17
- Maven 3.6+
- 4GB RAM (for large benchmarks)
- JUnit 5 for testing

---

## Project Structure

.
├── src
│ ├── main
│ │ ├── java
│ │ │ ├── algorithms # MergeSort, QuickSort, Select, ClosestPair
│ │ │ ├── metrics # Counters, DepthTracker, CSVWriter
│ │ │ ├── util # Partition, Swap, Shuffle, Guards
│ │ │ └── cli # Command-line interface
│ │ └── resources
│ └── test
│ └── java
│ ├── algorithms # Unit tests for each algorithm
│ └── metrics # Tests for metrics collection
├── benchmarks # JMH benchmarks for select vs sort
├── README.md # Project report & summary
├── pom.xml # Maven project configuration
└── .gitignore # Ignored files

yaml
Копировать код

---

## Git Workflow

**Branches:**
- `main` – stable releases only (v0.1, v1.0)
- Feature branches:  
  `feature/mergesort`, `feature/quicksort`, `feature/select`, `feature/closest`, `feature/metrics`

**Commit Storyline Example:**
- `init`: Maven setup, JUnit5, README  
- `feat(metrics)`: counters, depth tracker, CSV writer  
- `feat(mergesort)`: baseline + buffer reuse + cutoff + tests  
- `feat(quicksort)`: smaller-first recursion, randomized pivot + tests  
- `refactor(util)`: partition, swap, shuffle, guards  
- `feat(select)`: deterministic select (MoM5) + tests  
- `feat(closest)`: divide-and-conquer implementation + tests  
- `feat(cli)`: parse args, run algorithms, export CSV  
- `bench(jmh)`: benchmark harness  
- `docs(report)`: Master cases, AB intuition, initial plots  
- `fix`: edge cases (duplicates, tiny arrays)  
- `release`: v1.0

---

## Testing

- **Sorting correctness:** random and adversarial arrays; recursion depth verification (QuickSort depth ≤ 2*floor(log2 n) + O(1) with randomized pivot)  
- **Select correctness:** compare with `Arrays.sort(a)[k]` across 100 random trials  
- **Closest Pair correctness:** validate against O(n²) method for small n (≤2000); fast version only for large n

---

## Metrics & Reporting

- Recursion depth tracking  
- Comparison and swap counters  
- CSV output of metrics for each run  
- CLI to run any algorithm and collect measurements  
- Plots: time vs n, depth vs n  
- Discussion of constant factors (cache effects, GC impact)

---

## Roadmap

- [ ] Metrics (time, depth, comparisons, allocations)  
- [ ] MergeSort  
- [ ] QuickSort  
- [ ] Deterministic Select  
- [ ] Closest Pair of Points  
- [ ] CLI for experiments  
- [ ] Benchmarks (JMH)  
- [ ] Report (README.md)
