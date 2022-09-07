package repo;

import model.Student;

import java.util.ArrayList;
import java.util.Arrays;


public class StudentDB {
    private Student[] students;

    public StudentDB(Student[] students){
        this.students = students;
    }


    public Student[] getAllStudents() {
        return students;
    }

    public Student randomStudent(){
        int rand = (int) (Math.random()* students.length);
        return students[rand];
    }


    public void addStudent(Student student){
        Student[] newAllStudents = new Student[students.length+1];
        System.arraycopy(students, 0, newAllStudents, 0, students.length);
        newAllStudents[newAllStudents.length-1] = student;
        students=newAllStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentDB studentDB = (StudentDB) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(students, studentDB.students);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(students);
    }

    @Override
    public String toString() {
        students = getAllStudents();
        return Arrays.toString(students);
    }

    public void removeStudent(Student student) {
        // index of student to be removed
        int indexOfStudentToBeRemoved = 0;

        // find index of student to be removed in students via for-loop
        for (int i = 0; i<students.length;i++){
            if(students[i].equals(student)){
                indexOfStudentToBeRemoved = i;
                break; // if found, then exit the loop
            }
        }

        // students after removing
        Student[] studentsAfterRemoving = new Student[students.length-1];

        // if removed student was the first student in students
        if(indexOfStudentToBeRemoved==0){
            for (int i = 1; i<students.length;i++){
                studentsAfterRemoving[i-1] = students[i];
            }
        // else:
        }else{
            for (int i=0; i<indexOfStudentToBeRemoved;i++){
                studentsAfterRemoving[i] = students[i];
            }
            for(int i= indexOfStudentToBeRemoved+1; i<students.length;i++){
                studentsAfterRemoving[i-1] = students[i];
            }
        }
        students = studentsAfterRemoving;
    }
}
