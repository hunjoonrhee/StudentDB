package repo;

import model.Student;

import java.util.ArrayList;
import java.util.Arrays;


public class StudentDB {
    private Student[] students;
    private Student[] presentStudents;
    private Student[] allStudents;
    private boolean isadded=false;
    private boolean isremoved=false;

    public StudentDB(Student[] students){
        this.students = students;
        this.presentStudents = students; // das wird je nach Änderung (Add, Remove) aktualisiert.
    }


    public Student[] getAllStudents() {
        if(isadded || isremoved){
            return allStudents = presentStudents;
        }else{
            allStudents = students;
            return allStudents;
        }
    }

    public Student randomStudent(){
        int rand = (int) (Math.random()* students.length);
        return students[rand];
    }

    public Student[] getPresentStudents(){
        return this.presentStudents;
    }

    public void addStudent(Student student){
        presentStudents = getPresentStudents();
        isadded = true;

        Student[] newAllStudents = new Student[presentStudents.length+1];
        System.arraycopy(presentStudents, 0, newAllStudents, 0, presentStudents.length);
        newAllStudents[newAllStudents.length-1] = student;
        presentStudents=newAllStudents;
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
        allStudents = getAllStudents();
        return Arrays.toString(allStudents);
    }

    public void removeStudent(Student student) {
        presentStudents = getPresentStudents();
        isremoved=true;
        int index = 0;
        for (int i = 0; i<presentStudents.length;i++){
            if(presentStudents[i].equals(student)){
                index = i;
                break;
            }
        }
        Student[] reducedStudents = new Student[presentStudents.length-1];
        if(index==0){
            for (int i = 1; i<presentStudents.length;i++){
                reducedStudents[i-1] = presentStudents[i];
            }
        }else{
            for (int i=0; i<index;i++){
                reducedStudents[i] = presentStudents[i];
            }
            for(int i= index+1; i<presentStudents.length;i++){
                reducedStudents[i-1] = presentStudents[i];
            }
        }
        presentStudents = reducedStudents;
    }
}
