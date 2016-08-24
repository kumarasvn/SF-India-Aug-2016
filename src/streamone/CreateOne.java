package streamone;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateOne {
    public static void main(String[] args) {
        Stream
//                .generate(Math::random)
                .generate(()->ThreadLocalRandom.current().nextInt(1,7) 
                        + ThreadLocalRandom.current().nextInt(1, 7)
                        + ThreadLocalRandom.current().nextInt(1, 7)
                        + ThreadLocalRandom.current().nextInt(1, 7)
                )
                .limit(10_000)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2)-> e1.getKey().compareTo(e2.getKey()))
                .forEach(e->System.out.printf("%3d: %s\n", e.getKey(), 
                        Stream.generate(()->"*").limit(e.getValue()/12).collect(Collectors.joining())));
    }
}
