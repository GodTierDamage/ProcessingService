package services;

import moduls.Student;
import org.apache.commons.lang3.StringUtils;

public class CompareStudentsByUniversityId implements StudentComparator{

    private CompareStudentsByUniversityId () {}

    public static CompareStudentsByUniversityId getInstance() {
        return new CompareStudentsByUniversityId();
    }

    public static int compareByUniversityID(Student o1, Student o2){
        return new CompareStudentsByUniversityId().compare(o1, o2);
    }

    @Override
    public int compare(Student o1, Student o2) {
        if(o1 == null || o2 == null || o1.getUniversityId() == null || o2.getUniversityId() == null){
            throw new NullPointerException("Students variable or universityId contains null");
        }
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}
