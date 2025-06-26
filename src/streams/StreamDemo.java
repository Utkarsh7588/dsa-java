package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // feature introduced in java 8
        // process collections of data in a functional and declarative manner
        // simplify data processing
        // embrace functional programming
        // enable easy parallelism

        // what is stream?
        // a sequence of elements supporting functional and declarative manner

        // how to use streams?
        // source, intermediate opertaions & terminal operation

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().filter(x -> x % 2 == 0).count());

        // creating streams
        // 1. from collections
        List<Integer> list =Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream=list.stream();
        // 2. from arrays
        String[] array={"a","b","c"};
        Stream<String> stream1=Arrays.stream(array);

        // 3.using Stream.of()
        Stream<String> stream2=Stream.of("a","b");

        // 4. infinite streams
        Stream<Integer> generate=Stream.generate(()->1);
        Stream.iterate(1,x->x+1);
    }
}
