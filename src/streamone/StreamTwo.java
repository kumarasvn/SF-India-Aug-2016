package streamone;

import java.util.Arrays;
import java.util.List;
import simpleschool.Student;

public class StreamTwo {

    public static void main(String[] args) {
        List<Student> school = Arrays.asList(
                Student.newStudent("Fred", "123 Acacia gardens", "Physics", 2.3F),
                Student.newStudent("Annie", "Over here", "Maths", 3.2F),
                Student.newStudent("Toni", "Somewhere", "Astronomy", 2.9F),
                Student.newStudent("Sarah", "123 Acacia gardens", "Aviation", 2.3F),
                Student.newStudent("Sheila", "Over the Rainbow", "Maths", 4.0F),
                Student.newStudent("Jim", "Anyton", "Algebra", 3.3F)
        );

//        school.stream()
//                .map(s->{s.setName(s.getName() + "Broken1!!"); return s;})
//                .forEach(s->System.out.println(s));
        school.stream()
                .map(s -> Student.newStudent(
                        s.getName() + "NotBroken",
                        s.getAddress(),
                        s.getMajor(),
                        s.getGpa()))
                .forEach(s -> System.out.println(s));

        System.out.println(school);

        System.out.println("---------------------------");
        school.stream().forEach(s -> System.out.println(s));

        System.out.println("---------------------------");
        school.stream()
                .sorted((s1, s2) -> Float.compare(s1.getGpa(), s2.getGpa()))
                .forEach(s -> System.out.println(s));

        System.out.println("---------------------------");
        school.stream()
                .filter(s -> s.getGpa() > 3.0F)
                .forEach(s -> System.out.println(s));

        System.out.println("---------------------------");
        school.stream()
                .filter(s -> s.getGpa() > 3.0F)
                .map(s -> s.getName())
                .forEach(s -> System.out.println(s));

        System.out.println("---------------------------");
        school.stream()
                .filter(s -> s.getGpa() > 3.0F)
                .map(s -> s.getName())
                .map(s -> "Congratulations " + s)
                .forEach(s -> System.out.println(s));

        System.out.println("---------------------------");
        System.out.println("Long names number "
                + school.stream()
                .filter(s -> s.getName().length() > 4)
                .count());

        System.out.println("---------------------------");
        school.stream()
                .mapToDouble(s -> s.getGpa())
                .max()
                .ifPresent(v -> System.out.println("Highest grade: " + v));

        System.out.println("---------------------------");
        System.out.println("Statistics: " 
                + school.stream()
                .mapToDouble(s -> s.getGpa())
                .summaryStatistics());


    }
}
