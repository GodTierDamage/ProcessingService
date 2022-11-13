package enums;

import moduls.Student;
import services.*;

import java.util.Comparator;

public enum StudentComparators {

    COMPARE_BY_AVG_EXAM_SCORE(CompareStudentsByAVGExamScore.getInstance()),
    COMPARE_BY_CURRENT_COURSE_NUMBER(CompareStudentsByCurrentCourseNumber.getInstance()),
    COMPARE_BY_FULL_NAME(CompareStudentsByFullName.getInstance()),
    COMPARE_BY_ID(CompareStudentsByID.getInstance()),
    COMPARE_BY_UNIVERSITY_ID(CompareStudentsByUniversityId.getInstance());

    private final Comparator<Student> comparator;

    StudentComparators(Comparator <Student> comparator){
        this.comparator = comparator;
    }

    public Comparator<Student> getComparator(){
        return comparator;
    }
}
