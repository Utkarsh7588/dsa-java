import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class LambdaFunctions {
    public static void main(String[] args) {
        //Java 8 --> minimal code, functional programming
        //Java 8 --> lambda expression, streams.Streams, Date & Time API

        // lambda expression
        // Is an anonymous function( no name, no return type, no access modifier)

        Thread t1 = new Thread(() -> {
            System.out.println("Hello");
        });

        MathOperation subOperation = (int a, int b) -> {
            return a + b;
        };
        //can be reduced
        MathOperation sumOperation = (a, b) -> a + b;
        int res = sumOperation.operate(5, 4);

        // Predicate --> Functional interface ( Boolean valued function )
        Predicate<Integer> isEven = (a) -> a % 2 == 0;
        boolean test = isEven.test(5);
        Predicate<String> isStartsWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isStartsWithT = x -> x.toLowerCase().startsWith("t");
        //above 2 can be combined and a new predicate can be formed;
        Predicate<String> or = isStartsWithA.or(isStartsWithT);

        Function<Integer, Integer> doubleIt = x -> 2 * x;
        Function<Integer, Boolean> isOdd = x -> x % 2 != 0;
        Function<Integer, Integer> tripleIt = x -> 3 * x;
        Function<Integer, Integer> andThen = doubleIt.andThen(tripleIt);
        System.out.println(andThen.apply(2));

        Function<Integer, Integer> identity = Function.identity(); //returns the input itself

        Consumer<Integer> print = x -> System.out.println(x);

        Supplier<String> giveHello = () -> "Hello";

        //combined example
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if (predicate.test(supplier.get())) {
            consumer.accept(function.apply(supplier.get()));
        }

        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();

        Function<Integer, Integer> a = x -> 2 * x;
        UnaryOperator<Integer> b = x -> 2 * x;
        //both do the same thing

        BinaryOperator<Integer> c = (x, y) -> x + y;

        List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");
        students.forEach(x -> System.out.println(x));
        students.forEach(System.out::println);

        List<String> names = Arrays.asList("A", "B", "C");
        List<MobilePhone> mobilePhones = names.stream().map(MobilePhone::new).collect(Collectors.toList());
    }
}

// have to write all this which is reduced by lambda expression
//class Task implements Runnable{
//    @Override
//    public void run(){
//        System.out.println("hello");
//    }
//}
@FunctionalInterface//attenuation is given so compiler throws error if there are more than 1 method in interface
interface MathOperation {
    int operate(int a, int b);
//    int show(int a, float b);
}
class MobilePhone {
    String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}