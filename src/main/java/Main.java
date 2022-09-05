import model.Student;
import repo.StudentDB;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[9];
        students[0] = new Student("Jack", 2022001);
        students[1] = new Student("Marry", 2022002);
        students[2] = new Student("John", 2022003);
        students[3] = new Student("Branko", 2022004);
        students[4] = new Student("Basti", 2022005);
        students[5] = new Student("Rosina", 2022006);
        students[6] = new Student("Julia", 2022007);
        students[7] = new Student("Pascal", 2022008);
        students[8] = new Student("Munir", 2022009);
        StudentDB studentDB = new StudentDB(students);
        System.out.println(studentDB);
        studentDB.addStudent(new Student("Joon", 2022010));
        System.out.println(studentDB);
        Student [] allStudents = studentDB.getAllStudents();
        studentDB.removeStudent(allStudents[0]);
        System.out.println(studentDB);
        Student randomStudent = studentDB.randomStudent();
        System.out.println(randomStudent);


    }
}
