package simpleschool;

import java.util.Arrays;
import java.util.List;

public class StreamThree {
    public static void main(String[] args) {
        List<Student> school = Arrays.asList(
                Student.newStudent("Fred", "123 Acacia gardens", "Physics", 2.3F,
                        "Maths", "Physics"),
                Student.newStudent("Annie", "Over here", "Maths", 3.2F,
                        "Maths", "Astronomy", "Art"),
                Student.newStudent("Toni", "Somewhere", "Astronomy", 2.9F,
                        "Astronomy", "Geophysics"),
                Student.newStudent("Sarah", "123 Acacia gardens", "Aviation", 2.3F),
                Student.newStudent("Sheila", "Over the Rainbow", "Maths", 4.0F,
                        "Maths", "Statistics", "Applied Maths"),
                Student.newStudent("Jim", "Anyton", "Algebra", 3.3F)
        );
        
        school.stream()
                .flatMap(s->s.getCourses().stream())
                .forEach(s->System.out.println(s));

    }
}
