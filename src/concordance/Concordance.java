package concordance;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {
    public static void main(String[] args) throws Throwable {
        try (Stream<String> stream = Files.lines(Paths.get("PrideAndPrejudice.txt"))) {
                stream
                        .flatMap(s-> Stream.of(s.split("\\W+")))
                        .filter(s->s.length() > 0)
                        .map(String::toLowerCase) //.map(s->s.toLowerCase())
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted((e1, e2)-> e2.getValue().compareTo(e1.getValue()))
                        .limit(200)
                        .forEach(System.out::println);
//                        .forEach(e->System.out.printf("%25s : %5d\n", e.getKey(), e.getValue()))
                ;
        }
    }
}
