import model.Student;
import org.junit.jupiter.api.Test;
import repo.StudentDB;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentDBTest {

    @Test
    void getAllStudentsShouldReturnAllCreatedStudents(){
        //GIVEN
        Student[] students = new Student[2];

        students[0] = new Student("Jack", 2022001);
        students[1] = new Student("Marry", 2022002);

        StudentDB studentDB = new StudentDB(students);
        Student[] allStudents = studentDB.getAllStudents();



        //WHEN

        //THEN
        assertArrayEquals(students, allStudents);

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
    void whenAStudentIsAddedStudentDBLengthShouldBeIncreaseByOne(){
        //GIVEN
        Student[] students = new Student[2];

        students[0] = new Student("Jack", 2022001);
        students[1] = new Student("Marry", 2022002);

        StudentDB studentDB = new StudentDB(students);
        int previousLength = studentDB.getAllStudents().length;



        //WHEN
        studentDB.addStudent(new Student("John", 2022003));
        int newLength = studentDB.getAllStudents().length;
        //THEN
        assertEquals(newLength, previousLength+1);

    }

    @Test
    void whenAStudentIsAddedTheStudentShouldBeAvailableAtTheLastIndex(){
        //GIVEN
        Student[] students = new Student[2];

        students[0] = new Student("Jack", 2022001);
        students[1] = new Student("Marry", 2022002);

        StudentDB studentDB = new StudentDB(students);
        Student studentToAdd = new Student("John", 2022003);
        studentDB.addStudent(studentToAdd);


        //WHEN
        int numberOfStudents = studentDB.getAllStudents().length;
        Student studentAtLastIndex = studentDB.getAllStudents()[numberOfStudents-1];
        //THEN
        assertEquals(studentToAdd, studentAtLastIndex);

    }


    @Test
    void whenAStudentIsRemovedStudentDBLengthShouldBeDecreasedByOne(){
        //GIVEN
        Student[] students = new Student[3];

        students[0] = new Student("Jack", 2022001);
        students[1] = new Student("Marry", 2022002);
        students[2] = new Student("John", 2022003);

        StudentDB studentDB = new StudentDB(students);
        int previousLength = studentDB.getAllStudents().length;




        //WHEN
        studentDB.removeStudent(students[2]);
        int newLength = studentDB.getAllStudents().length;
        // THEN
        assertEquals(newLength, previousLength-1);

    }
}
