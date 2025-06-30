package streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        // ✅ Parallel Streams enable parallel processing (multithreading) of stream operations.
        // Ideal for large or CPU-intensive tasks.

        // Create a list of integers from 1 to 20000
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();

        // 🔹 Measure time using SEQUENTIAL stream
        long startTime = System.currentTimeMillis();

        // Calculate factorial of each number using normal (sequential) stream
        List<Long> factorialsList = list.stream()
                .map(ParallelStream::factorial)
                .toList();

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential stream: " + (endTime - startTime) + " ms");

        // 🔹 Measure time using PARALLEL stream
        startTime = System.currentTimeMillis();

        // Parallel stream executes .map() concurrently using multiple threads
        factorialsList = list.parallelStream()
                .map(ParallelStream::factorial)
                .toList();

        // Optional: Switch back to sequential if needed
        // .sequential() cancels parallel behavior → useful for conditional logic
        // factorialsList = list.parallelStream().map(ParallelStream::factorial).sequential().toList();

        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: " + (endTime - startTime) + " ms");

        // ✅ Summary:
        // - Parallel stream is faster for heavy computations on large datasets
        // - It uses ForkJoinPool.commonPool internally
        // - For small/light operations, parallel streams may be slower due to thread overhead

        // 🔹 Now: Demonstrate a WRONG use case of parallel stream

        // Example: cumulative sum
        // [1, 2, 3, 4, 5] → [1, 3, 6, 10, 15] (like a running total)

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using AtomicInteger to hold shared mutable state
        AtomicInteger sum = new AtomicInteger(0);

        // WARNING: This is NOT safe in parallel! Works only with sequential stream
        List<Integer> cumulativeSum = numbers.stream() // use .sequential() to force order
                .map(sum::addAndGet)
                .toList();

        System.out.println("Expected cumulative sum: [1, 3, 6, 10, 15]");
        System.out.println("Actual result with parallel stream: " + cumulativeSum);

        // ❌ Why this fails in parallel:
        // Streams are not guaranteed to process in order in parallel mode
        // Mutable state (like AtomicInteger here) can be accessed simultaneously → race conditions
        // Always use stateless functions with parallel streams
    }

    // 🔹 Factorial function: CPU-intensive task, great candidate for parallelism
    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
