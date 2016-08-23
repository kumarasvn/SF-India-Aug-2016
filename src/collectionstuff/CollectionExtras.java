package collectionstuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionExtras {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>(Arrays.asList("Fred", "Jim", "Sheila", "Albert", "Jo", "Tina"));
        
        ls.forEach(s->System.out.println(s));
        System.out.println("----------------------------------");
        
        ls.replaceAll(s->s + " gets a raise");
        ls.forEach(s->System.out.println(s));
        System.out.println("----------------------------------");
        ls.removeIf(s->s.length() > 17);
        ls.forEach(s->System.out.println(s));
        System.out.println("----------------------------------");
    }
}
