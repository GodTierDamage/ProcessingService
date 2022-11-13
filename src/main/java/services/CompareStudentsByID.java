package services;

import moduls.Student;

public class CompareStudentsByID implements StudentComparator{

    private CompareStudentsByID() {}

    public static CompareStudentsByID getInstance() {
        return new CompareStudentsByID();
    }

    public static int compareByID(Student o1, Student o2) {
        return new CompareStudentsByID().compare(o1, o2);
    }

    @Override
    public int compare(Student o1, Student o2) {
        if(o1 == null || o2 == null){
            throw new NullPointerException("Student not found");
        }
        return Long.compare(o1.getId(), o2.getId());
    }
}
