package repo;

import model.Student;

import java.util.ArrayList;
import java.util.Arrays;


public class StudentDB {
    private Student[] students;
    private Student[] allStudents;

    public StudentDB(Student[] students){
        this.students = students;
    }


    public Student[] getAllStudents() {
        allStudents = students;
        return allStudents;
    }

    public Student randomStudent(){
        int rand = (int) (Math.random()* students.length);
        return students[rand];
    }

    public Student[] addStudent(Student student){
        allStudents = getAllStudents();
        Student[] newAllStudents = new Student[allStudents.length+1];
        System.arraycopy(allStudents, 0, newAllStudents, 0, allStudents.length);
        allStudents = newAllStudents;
        allStudents[allStudents.length-1] = student;
        return allStudents;

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
        Student[] allStudents = getAllStudents();
        return Arrays.toString(allStudents);
    }

    public Student[] removeStudent(Student student) {
        Student[] allStudents = getAllStudents();
        int index = 0;
        for (int i = 0; i<allStudents.length;i++){
            if(allStudents[i].equals(student)){
                index = i;
                break;
            }
        }
        Student[] reducedStudents = new Student[allStudents.length-1];
        if(index==0){
            for (int i = 1; i<allStudents.length;i++){
                reducedStudents[i-1] = allStudents[i];
            }
        }else{
            for (int i=0; i<index;i++){
                reducedStudents[i] = allStudents[i];
            }
            for(int i= index+1; i<allStudents.length;i++){
                reducedStudents[i-1] = allStudents[i];
            }
        }
        return reducedStudents;
    }
}
