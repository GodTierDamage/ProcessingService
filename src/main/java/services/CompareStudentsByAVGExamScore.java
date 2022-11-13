package services;

import moduls.Student;

public class CompareStudentsByAVGExamScore implements StudentComparator{

    private CompareStudentsByAVGExamScore() {}

    public static CompareStudentsByAVGExamScore getInstance(){
        return new CompareStudentsByAVGExamScore();
    }

    public static int compareByAVGExamScore(Student o1, Student o2) {
        return new CompareStudentsByAVGExamScore().compare(o1, o2);
    }

    @Override
    public int compare(Student o1, Student o2) {
        if(o1 == null || o2 == null){
            throw new NullPointerException("Students variable contains null");
        }
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
