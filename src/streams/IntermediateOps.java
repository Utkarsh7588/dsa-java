package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        // Intermediate operations transform a stream into another stream.
        // They are *lazy*, meaning they don't perform any processing until a terminal operation is invoked.

        List<String> list = Arrays.asList("Akshit", "Akshit", "Akshay", "Ram", "Shyam", "Ghanshyam");

        // .filter() is an intermediate operation: returns a stream with elements that start with "A"
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("A"));
        // No actual filtering happens until a terminal operation is called

        // 1. count() - terminal operation that triggers the stream
        // This counts how many names start with "A"
        long res = list.stream().filter(x -> x.startsWith("A")).count();
        System.out.println("Count of names starting with A: " + res);

        // 2. map() - intermediate operation that transforms each element
        // This converts all names in the list to uppercase
        Stream<String> stringStream = list.stream().map(String::toUpperCase);
        // stringStream is still lazy; nothing is printed until a terminal op like forEach, count, etc.

        // 3. sorted() - sorts the stream in natural order (alphabetical here)
        Stream<String> sortedStream = list.stream().sorted();

        // Custom sorting using Comparator: by length of string
        Stream<String> sortedStreamUsingComparator = list.stream().sorted((a, b) -> a.length() - b.length());

        // 4. distinct() - removes duplicates in the stream
        // This counts how many unique names start with "A"
        System.out.println("Unique names starting with A: " + list.stream().filter(x -> x.startsWith("A")).distinct().count());

        // 5. limit(n) - returns a stream with only the first 'n' elements
        // Here we generate an infinite stream using iterate, but take only first 100 elements
        System.out.println("Count from limit: " + Stream.iterate(1, x -> x + 1).limit(100).count()); // Outputs 100

        // 6. skip(n) - skips the first 'n' elements in the stream
        // Skips first 10 and takes next 100 elements from the infinite stream
        System.out.println("Count after skipping 10 and limiting 100: " + Stream.iterate(1, x -> x + 1).skip(10).limit(100).count()); // Outputs 100

        // 7. peek() - intermediate operation for debugging
        // It performs an action on each element as it is consumed, without modifying the stream
        // Here we print each number (from 11 to 110) as the stream is being counted
        Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println) // acts like a debug print
                .count(); // Terminal operation that triggers the stream

        // 8. flatMap()
        // ✅ Purpose: flatten nested structures (List<List<T>>, array of arrays, etc.)
        // It also allows you to transform and flatten at the same time.

        // Example 1: Flattening a List of Lists of Strings
        List<List<String>> listOfLists = Arrays.asList(Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape"));

        // Accessing a nested element directly
        System.out.println(listOfLists.get(1).get(1));  // Output: kiwi

        // Flatten the list of lists → Stream<String>, then convert to uppercase
        List<String> flattenedUppercase = listOfLists.stream().flatMap(innerList -> innerList.stream()) // flatten: Stream<List<String>> → Stream<String>
                .map(String::toUpperCase)                 // transform each element to uppercase
                .toList();                                // collect to List

        System.out.println(flattenedUppercase);  // Output: [APPLE, BANANA, ORANGE, KIWI, PEAR, GRAPE]

        // Example 2: Flattening a list of sentences into words
        List<String> sentences = Arrays.asList("Hello world",
                "Java streams are powerful",
                "flatMap is useful");

        // Convert List<String> (sentences) → List<String> (words), then uppercase
        List<String> words = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))) // split each sentence into words
                .map(String::toUpperCase)                                // transform each word to uppercase
                .toList();                                               // collect into a List

        System.out.println(words);
        // Output: [HELLO, WORLD, JAVA, STREAMS, ARE, POWERFUL, FLATMAP, IS, USEFUL]

    }
}
