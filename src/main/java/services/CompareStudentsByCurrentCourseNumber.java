package services;

import moduls.Student;

public class CompareStudentsByCurrentCourseNumber implements StudentComparator{

    private CompareStudentsByCurrentCourseNumber() {}

    public static CompareStudentsByCurrentCourseNumber getInstance() {
        return new CompareStudentsByCurrentCourseNumber();
    }

    public static int compareByCurrentCourseNumber(Student o1, Student o2){
        return new CompareStudentsByCurrentCourseNumber().compare(o1, o2);
    }

    @Override
    public int compare(Student o1, Student o2) {
        if(o1 == null || o2 == null){
            throw new NullPointerException("Students variable contains null");
        }
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
