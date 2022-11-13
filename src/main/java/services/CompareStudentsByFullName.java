package services;

import moduls.Student;
import org.apache.commons.lang3.StringUtils;

public class CompareStudentsByFullName implements StudentComparator {

    private CompareStudentsByFullName() {}

    public static CompareStudentsByFullName getInstance() {
        return new CompareStudentsByFullName();
    }

    public static int compareByFullName(Student o1, Student o2) {
        return new CompareStudentsByFullName().compare(o1, o2);
    }

    @Override
    public int compare(Student o1, Student o2) {
        if(o1 == null || o2 == null || o1.getFullName() == null || o2.getFullName() == null){
            throw new NullPointerException("Students variable or fullName contains null");
        }
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
