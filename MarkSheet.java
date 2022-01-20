package ITSOL.StudentGPA;

import java.io.Serializable;
import java.util.Arrays;

public class MarkSheet implements Serializable {
    private Student student;
    private Subject[] subjects;
    private int[] marks;

    public MarkSheet() {
    }

    public MarkSheet(Student student, Subject[] subjects, int[] marks) {
        this.student = student;
        this.subjects = subjects;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "MarkSheet{" +
                "student=" + student +
                ", subjects=" + Arrays.toString(subjects) +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }
}
