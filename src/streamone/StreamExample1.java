package streamone;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import simpleschool.Student;

public class StreamExample1 {

    public static void main(String[] args) {
        List<Student> school = Arrays.asList(
                Student.newStudent("Fred", "123 Acacia gardes", "Physics", 2.3F),
                Student.newStudent("Sheila", "Over the Rainbow", "Math", 4.0F),
                Student.newStudent("Jim", "Anyton", "Algebra", 3.3F)
        );
//        int[] smartCount = {0};

//        long smartCount = 
//        school.stream()
//                .filter(s -> s.getGpa() > 3.0F)
//                .map(s -> s.getName())
//                .count();
//        List<Student> smartList = 
        school.stream()
                .peek(s -> System.out.println("Upstrem finds " + s))
                .filter(s -> s.getGpa() > 3.0F)
                .peek(s -> System.out.println("Downstrem finds " + s))
                .allMatch(s -> s.getName().length() < 100)
                ;
//                .collect(Collectors.toList());

//        System.out.printf("There are %d smart students\n", smartList.size());
//        smartList.stream()
//                .map(s->s.getName())
//                .forEach(s->System.out.println(s));
        // DO NOT DO THIS!!!!
//                .forEach(s->{System.out.println("> " + s); smartCount[0]++;});
//        System.out.printf("There are %d smart students\n", smartCount[0]);
//        System.out.println(school);
    }
}
