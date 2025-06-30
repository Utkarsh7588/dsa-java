package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // 1️⃣ collect(): Terminal operation to collect stream elements into a collection
        List<Integer> collected = list.stream().skip(1).collect(Collectors.toList());
        // Alternatively (Java 16+): toList() is built-in and cleaner
        List<Integer> collected2 = list.stream().skip(1).toList();

        // 2️⃣ forEach(): Performs an action for each element in the stream
        list.stream().forEach(x -> System.out.println(x));

        // 3️⃣ reduce(): Combines elements of the stream into a single result (like sum)
        Optional<Integer> optionalInteger = list.stream().reduce((x, y) -> x + y);
        System.out.println("Sum using reduce: " + optionalInteger.get());

        // 4️⃣ count(): Counts number of elements in the stream
        long count = list.stream().count();
        System.out.println("Count: " + count);

        // 5️⃣ anyMatch, allMatch, noneMatch: return true/false based on predicates
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);      // at least one even?
        System.out.println("Any even? " + b);
        boolean b1 = list.stream().allMatch(x -> x > 0);          // all positive?
        System.out.println("All positive? " + b1);
        boolean b2 = list.stream().noneMatch(x -> x < 0);         // none negative?
        System.out.println("None negative? " + b2);

        // 6️⃣ findFirst(), findAny(): Get first or any element from stream
        System.out.println("First: " + list.stream().findFirst().get());
        System.out.println("Any: " + list.stream().findAny().get()); // useful in parallel streams

        // 7️⃣ toArray(): Converts stream to Object array
        Object[] array = Stream.of(1, 2, 3).toArray();
        System.out.println("Array: " + Arrays.toString(array));

        // 8️⃣ min / max: Get minimum or maximum element using comparator
        Optional<Integer> max = Stream.of(2, 44, 69).max((o1, o2) -> o2 - o1); // descending max
        Optional<Integer> min = Stream.of(2, 44, 69).min(Comparator.naturalOrder());
        System.out.println("Max: " + max.get());
        System.out.println("Min: " + min.get());

        // 9️⃣ forEachOrdered vs forEach with parallel streams
        List<Integer> numbers0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Using forEach with parallel stream (order not guaranteed):");
        numbers0.parallelStream().forEach(System.out::println); // may print out-of-order
        System.out.println("Using forEachOrdered with parallel stream (preserves order):");
        numbers0.parallelStream().forEachOrdered(System.out::println); // preserves encounter order

        // 🔟 Example: filter + collect — Get names longer than 3 characters
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        List<String> longNames = names.stream().filter(x -> x.length() > 3).collect(Collectors.toList());
        System.out.println("Names with >3 chars: " + longNames);

        // 🔢 Example: Square and sort numbers
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6);
        List<Integer> squaresSorted = numbers.stream().map(x -> x * x).sorted().toList();
        System.out.println("Sorted squares: " + squaresSorted);

        // ➕ Example: Summing values using reduce
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = integers.stream().reduce((x, y) -> x + y).get();
        System.out.println("Sum using reduce: " + sum);

        // 🅰️ Example: Count occurrences of a character
        String sentence = "Hello World";
        long lCount = sentence.chars().filter(x -> x == 'l').count();
        System.out.println("Count of 'l': " + lCount);

        // ℹ️ Note: There are two types of operations in streams:
        // - Stateless: don’t depend on previous elements (e.g., map, filter)
        // - Stateful: require awareness of other elements (e.g., sorted, distinct, limit)
    }
}
