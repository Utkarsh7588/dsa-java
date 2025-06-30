package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationDemo {
    public static void main(String[] args) {
        // Create a list of names
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Create a stream with a filter operation
        // This stream filters out names whose length is <= 3
        // BUT this filter will NOT be executed immediately because it's an intermediate (lazy) operation
        Stream<String> stream = names.stream().filter(name -> {
            // This code block will not run yet
            System.out.println("Filtering: " + name);
            return name.length() > 3;
        });

        // Print something BEFORE the stream is evaluated to show lazy behavior
        System.out.println("Before terminal operation");

        // This is the terminal operation that triggers the stream processing
        // Now, and only now, the filter lambda will actually execute for each element
        List<String> result = stream.collect(Collectors.toList());

        // Print something AFTER the stream has been evaluated
        System.out.println("After terminal operation");

        // Print the final result of the filtered list
        System.out.println(result);

        // OUTPUT
        // Before terminal operation
        // Filtering: Alice
        // Filtering: Bob
        // Filtering: Charlie
        // Filtering: David
        // After terminal operation
        // [Alice, Charlie, David]
    }
}
