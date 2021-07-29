package day4;
/*
 * ArrayLists with Classes/Objects
 */
import java.util.ArrayList;
import java.util.Iterator;

class Student {
    public int id;
    public String name;
    public String email;

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class Demo5 {
    public static void main(String[] args) {
        // user define class object
        Student student1 = new Student(1, "Mark", "m@gmail.com");
        Student student2 = new Student(2, "Paul", "p@gmail.com");
        Student student3 = new Student(3, "Watson", "w@gmail.com");

        // create arrayList
        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);



        // iterator
        Iterator iterator = students.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // for-each
        for(Student student: students){
            System.out.println(student);
        }

    }
}

