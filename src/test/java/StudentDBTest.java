import model.Student;
import org.junit.jupiter.api.Test;
import repo.StudentDB;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentDBTest {

    @Test
    void getAllStudentsTest(){
        //GIVEN
        Student[] students = new Student[2];
        students[0] = new Student("Jack", 2022001);
        students[1] = new Student("Marry", 2022002);
        StudentDB studentDB = new StudentDB(students);
        Student[] allStudents = studentDB.getAllStudents();



        //WHEN
        boolean actual = allStudents[0].equals(students[0])&&allStudents[1].equals(students[1]);
        //THEN
        assertEquals(true, actual);

    }

    @Test
    void toStringTest(){
        //GIVEN
        Student[] students = new Student[2];
        students[0] = new Student("Jack", 2022001);
        students[1] = new Student("Marry", 2022002);
        StudentDB studentDB = new StudentDB(students);


        //WHEN
        boolean actual = studentDB.toString().equals(Arrays.toString(students));
        //THEN
        assertEquals(true, actual);

    }

    @Test
    void addStudentTest(){
        //GIVEN
        Student[] students = new Student[2];
        students[0] = new Student("Jack", 2022001);
        students[1] = new Student("Marry", 2022002);
        StudentDB studentDB = new StudentDB(students);
        Student[] allStudents = studentDB.getAllStudents();
        Student[] NewAllStudents = studentDB.addStudent(new Student("John", 2022003));
        Student[] allStudents2 = studentDB.getAllStudents();



        //WHEN
        boolean actual = studentDB.toString().equals(Arrays.toString(allStudents2));
        //THEN
        assertEquals(true, actual);

    }

    @Test
    void removeStudentTest(){
        //GIVEN
        Student[] students = new Student[3];
        students[0] = new Student("Jack", 2022001);
        students[1] = new Student("Marry", 2022002);
        students[2] = new Student("John", 2022003);
        StudentDB studentDB = new StudentDB(students);
        Student[] allStudents = studentDB.getAllStudents();
        Student[] NewAllStudents = studentDB.removeStudent(students[2]);
        Student[] allStudents2 = studentDB.getAllStudents();



        //WHEN
        boolean actual = studentDB.toString().equals(Arrays.toString(allStudents2));
        //THEN
        assertEquals(true, actual);

    }
}
