package predicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class PredicateStuff {
    public static <E> Predicate<E> not(Predicate<E> pred) {
        return i -> ! pred.test(i);
    }
    
    public static <E> Predicate<E> and(Predicate<E> first, Predicate<E> second) {
        return i -> first.test(i) && second.test(i);
    }
    
    public static <E> List<E> filterStuff(Iterable<E> input, Predicate<E> p) {
        List<E> out = new ArrayList<>();
        for (E e : input) {
            if (p.test(e)) out.add(e);
        }
        return out;
    }
    
    public interface ExtractNumber<E> {
        int getNumber(E e);
    }

    public static <E> Predicate<E> getNumberComparison(int threshold, ExtractNumber<E> extract) {
        System.out.println("Getting comparison using extract number");
        return e -> extract.getNumber(e) > threshold;
    }
    
    
    public static <E> Predicate<E> getNumberComparison(int threshold, ToIntFunction<E> extract) {
        System.out.println("Getting comparison using ToIntFunction");
        return e -> extract.applyAsInt(e) > threshold;
    }
    
//    public static Predicate<String> getLengthPredicate(final int threshold) {
////        threshold++;
//        return s -> s.length() > threshold;
//    }
    
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Fred", "Jim", "Sheila", 
                "aardvark", "banana", "strange ideas", "bee", "not");
//        Predicate<String> longer = s -> s.length() > 4;
//        Predicate<String> longer = getLengthPredicate(4);
        Predicate<String> longer = getNumberComparison(4, (ExtractNumber<String>)(s -> s.length()));
        
        System.out.println("Filtered by length: " + filterStuff(ls, longer));
        System.out.println("Filtered by not(length): " + filterStuff(ls, not(longer)));
        Predicate<String> upperCaseFirst = s -> Character.isUpperCase(s.charAt(0));
        
        System.out.println("short lowercase strings: " 
                + filterStuff(ls, and(not(longer), not(upperCaseFirst))));
        
//        System.out.println("Longer than five" + filterStuff(ls, s->s.length() > 5));
//        System.out.println("Longer than five" + filterStuff(ls, getLengthPredicate(5)));
    }
}
