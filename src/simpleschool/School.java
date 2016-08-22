package simpleschool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class School {
    public static void main(String[] args) {
        Set<Student> roster = new HashSet<>();
        roster.add(Student.newStudent("Fred", "123 Acacia gardes", "Physics", 2.3F));
        roster.add(Student.newStudent("Sheila", "Over the Rainbow", "Math", 4.0F));
        roster.add(Student.newStudent("Jim", "Anyton", "Algebra", 3.3F));
        
        System.out.println("class is: " + roster);
        
        List<Student> orderByName = new ArrayList<>(roster);
        Set<Student> originalAndUnchanging = Collections.unmodifiableSet(roster);
        
//        Collections.sort(orderByName, new NameComparator());
        orderByName.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("Sorted: " + orderByName);
    }
}
