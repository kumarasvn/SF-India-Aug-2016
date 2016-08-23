package simpleschool;

import java.util.Comparator;
import java.util.Objects;

public class Student {

    private String name;
    private String address;
    private String major;
    private float gpa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getMajor() {
        return major;
    }

    public float getGpa() {
        return gpa;
    }

    private Student() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    private static void validate(String name, String address, String major, float gpa) {
        if (name == null || name.length() < 1
                || address == null || address.length() < 1
                || major == null || major.length() < 1
                || gpa < 0 || gpa > 4) {
            throw new IllegalArgumentException("Bad student values!");
        }
    }

    public static Student newStudent(String name, String address, String major, float gpa) {
        validate(name, address, major, gpa);
        Student self = new Student();
        self.name = name;
        self.address = address;
        self.major = major;
        self.gpa = gpa;
        return self;
    }

    public static Student newStudentWithNameAndMajor(String name, String major) {
        Student self = new Student();
        self.address = "Unknown";
        self.gpa = 0;
        validate(name, self.address, major, self.gpa);
        self.name = name;
        self.major = major;
        return self;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", address=" + address + ", major=" + major + ", gpa=" + gpa + '}';
    }

//    private static class NameComparator implements Comparator<Student> {
//
//        @Override
//        public int compare(Student o1, Student o2) {
//            System.out.println("in static inner comparator");
//            return o1.getName().compareTo(o2.getName());
//        }
//    }
//
//    private static Comparator<Student> nameComparator = new NameComparator();
//    public static Comparator<Student> getNameComparator() {
//        return nameComparator;
//    }

    public static Comparator<Student> getNameComparator() {
        return (o1, o2) -> o1.getName().compareTo(o2.getName());
    }

//    public static Comparator<Student> getNameComparator() {
//        return (/*Student*/ o1, /*Student*/ o2) -> /*{
//            return */o1.getName().compareTo(o2.getName())/*;*/
//        /*}*/;
//    }
//    public static Comparator<Student> getNameComparator() {
//        return (Student o1, Student o2) -> {
//                    return o1.getName().compareTo(o2.getName());
//                };
//    }
//    public static Comparator<Student> getNameComparator() {
//        return /*new Comparator<Student>() {*/
////            @Override
//            /*public int compare*/(Student o1, Student o2) -> {
//                System.out.println("in static inner comparator");
//                return o1.getName().compareTo(o2.getName());
//            }
//        /*}*/;
//    }
//    public static Comparator<Student> getNameComparator() {
//        return new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                System.out.println("in static inner comparator");
//                return o1.getName().compareTo(o2.getName());
//            }
//        };
//    }
//    private static Comparator<Student> nameComparator = new Comparator<Student>() {
//        @Override
//        public int compare(Student o1, Student o2) {
//            System.out.println("in static inner comparator");
//            return o1.getName().compareTo(o2.getName());
//        }
//    };
//
//    public static Comparator<Student> getNameComparator() {
//        return nameComparator;
//    }
//    private static Comparator<Student> nameComparator = new /*NameComparator();
//    private static class NameComparator implements */ Comparator<Student>() {
//        @Override
//        public int compare(Student o1, Student o2) {
//            System.out.println("in static inner comparator");
//            return o1.getName().compareTo(o2.getName());
//        }
//    };
//
//    public static Comparator<Student> getNameComparator() {
//        return nameComparator;
//    }
}
