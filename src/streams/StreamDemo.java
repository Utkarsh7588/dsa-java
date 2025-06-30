package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // Streams are a feature introduced in Java 8
        // They allow processing collections in a *functional*, *declarative*, and often *parallel* way

        // Benefits:
        // - Simplifies data processing (e.g., filtering, mapping)
        // - Embraces functional programming principles (no mutation, chaining)
        // - Enables easy parallel execution (parallelStream)

        // 👉 What is a Stream?
        // It's a sequence of elements (from a collection, array, etc.) that supports various operations
        // It doesn't store data — it conveys elements from a source through a pipeline of operations

        // Stream Usage Pattern:
        // ➤ Source → Intermediate Operations (lazy) → Terminal Operation (triggers evaluation)

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Example: Count even numbers
        // - filter() is intermediate (lazy)
        // - count() is terminal (triggers execution)
        System.out.println(numbers.stream().filter(x -> x % 2 == 0).count()); // Output: 2

        // 👇 Different ways to create streams in Java

        // 1️⃣ From a Collection (List, Set, etc.)
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        // 2️⃣ From an Array
        String[] array = {"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(array);

        // 3️⃣ Using Stream.of()
        Stream<String> stream2 = Stream.of("a", "b");

        // 4️⃣ Infinite Streams
        // ➤ generate() — uses a Supplier, generates same or computed values infinitely
        Stream<Integer> generate = Stream.generate(() -> 1); // 1, 1, 1, 1, ...
        // ➤ iterate() — creates an infinite stream based on a seed and unary operator
        Stream<Integer> infinite = Stream.iterate(1, x -> x + 1); // 1, 2, 3, 4, ...

        // Note: Infinite streams must be used with caution (usually combined with limit())
    }
}
