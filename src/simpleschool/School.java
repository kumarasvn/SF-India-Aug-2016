package simpleschool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class School {

//    public interface Criterion<E> {
//        boolean test(E s);
//    }

    public static <E> Comparator<E> reverseSort(Comparator<E> comp) {
        return (o1, o2) -> comp.compare(o2, o1);
    }
    
    public static <E> List<E> getSubList(Iterable<E> all, Predicate<E> criterion) {
        List<E> output = new ArrayList<>();
        for (E e : all) {
            if (criterion.test(e)) {
                output.add(e);
            }
        }
        return output;
    }

//    public interface StudentCriterion {
//
//        boolean test(Student s);
//    }
//
//    public static List<Student> selectStudents(Iterable<Student> all, StudentCriterion criterion) {
//        List<Student> output = new ArrayList<>();
//        for (Student s : all) {
//            if (criterion.test(s)) {
//                output.add(s);
//            }
//        }
//        return output;
//    }
//    public static List<Student> getSmartStudents(Iterable<Student> all, float threshold) {
//        List<Student> output = new ArrayList<>();
//        for (Student s : all) {
//            if (s.getGpa() > threshold) {
//                output.add(s);
//            }
//        }
//        return output;
//    }
    public static void main(String[] args) {
        Set<Student> roster = new HashSet<>();
        roster.add(Student.newStudent("Fred", "123 Acacia gardes", "Physics", 2.3F));
        roster.add(Student.newStudent("Sheila", "Over the Rainbow", "Math", 4.0F));
        roster.add(Student.newStudent("Jim", "Anyton", "Algebra", 3.3F));

//        System.out.println("class is: " + roster);

        List<Student> orderByName = new ArrayList<>(roster);
//        Set<Student> originalAndUnchanging = Collections.unmodifiableSet(roster);

//        Collections.sort(orderByName, new NameComparator());
//        orderByName.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
//        System.out.println("Sorted: " + orderByName);
        
        Comparator<Student> byName = (o1, o2) -> o1.getName().compareTo(o2.getName());
        System.out.println("input list is " + orderByName);
        orderByName.sort(reverseSort(byName));
        System.out.println("output list is " + orderByName);
        
        
        
//
//        List<Student> byGrade = new ArrayList<>(roster);
//        byGrade.sort((o1, o2) -> Float.compare(o1.getGpa(), o2.getGpa()));
//        System.out.println("By gpa " + byGrade);
//
//        Student s1 = Student.newStudent("Sheila", "Over the Rainbow", "Math", 4.0F);
//        Student s2 = Student.newStudent("Jim", "Anyton", "Algebra", 3.3F);
//        Comparator<Student> comp;
//        comp = (o1, o2) -> o1.getAddress().compareTo(o2.getAddress());
//        int x = ((Comparator<Student>) ((o1, o2) -> o1.getAddress().compareTo(o2.getAddress()))).compare(s1, s2);
//
//        System.out.println("--------------------------------------");
////        List<Student> smartList = getSmartStudents(roster, 3.0F);
//        List<Student> smartList = getSubList(roster, (s) -> s.getGpa() > 3.0F);
//        System.out.println("Smart students: " + smartList);
//
//        System.out.println("--------------------------------------");
//        System.out.println("NotSmart students: " 
//                + getSubList(roster, (s) -> s.getGpa() < 3.0F));
//
//        System.out.println("--------------------------------------");
//        System.out.println("First half name students: "
//                + getSubList(roster, (s) -> s.getName().charAt(0) < 'M'));
//
        List<String> text = Arrays.asList("Freddy", "Banana split", "Aardvaark", "Short", "x", "and some more that's really long");
//        System.out.println("Long words: " + getSubList(text, s->s.length() > 6));

        Comparator<String> orderByLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        System.out.println("Unsorted " + text);
        text.sort(orderByLength);
        System.out.println("By length " + text);
        text.sort(reverseSort(orderByLength));
        System.out.println("By descending length " + text);
        
        
    }
}
