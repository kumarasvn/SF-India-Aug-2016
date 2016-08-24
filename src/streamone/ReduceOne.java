package streamone;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ReduceOne {
    public static void main(String[] args) {
        OptionalInt sum =
        IntStream.iterate(1, v -> v + 1)
                .limit(10)
                .reduce((a,b) -> a + b);
        sum.ifPresent(System.out::println);
    }
}
