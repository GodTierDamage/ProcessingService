package Utils;

import enums.StudentComparators;
import enums.UniversityComparators;
import moduls.Student;
import moduls.University;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class ComparatorUtilsTest {

    @Test
    public void getStudentsComparator() {
        Comparator<Student> compareByID = ComparatorUtils.getStudentsComparator(StudentComparators.COMPARE_BY_ID);
        Comparator<Student> compareByAVG = ComparatorUtils.getStudentsComparator(StudentComparators.COMPARE_BY_AVG_EXAM_SCORE);
        Comparator<Student> compareByCourseNumber = ComparatorUtils.getStudentsComparator(StudentComparators.COMPARE_BY_CURRENT_COURSE_NUMBER);
        Comparator<Student> compareByUniversityID = ComparatorUtils.getStudentsComparator(StudentComparators.COMPARE_BY_UNIVERSITY_ID);
        Comparator<Student> compareByFullName = ComparatorUtils.getStudentsComparator(StudentComparators.COMPARE_BY_FULL_NAME);

        assertNotNull(compareByID);
        assertNotNull(compareByAVG);
        assertNotNull(compareByCourseNumber);
        assertNotNull(compareByUniversityID);
        assertNotNull(compareByFullName);
    }

    @Test
    public void getUniversitiesComparator(){
        Comparator<University> compareById = ComparatorUtils.getUniversitiesComparator(UniversityComparators.COMPARE_BY_ID);
        Comparator<University> compareByStudyProfile = ComparatorUtils.getUniversitiesComparator(UniversityComparators.COMPARE_BY_STUDY_PROFILE);
        Comparator<University> compareByFullName = ComparatorUtils.getUniversitiesComparator(UniversityComparators.COMPARE_BY_FULL_NAME);
        Comparator<University> compareByShortName = ComparatorUtils.getUniversitiesComparator(UniversityComparators.COMPARE_BY_SHORT_NAME);
        Comparator<University> compareByYearOfFoundation = ComparatorUtils.getUniversitiesComparator(UniversityComparators.COMPARE_BY_YEAR_OF_FOUNDATION);

        assertNotNull(compareById);
        assertNotNull(compareByStudyProfile);
        assertNotNull(compareByFullName);
        assertNotNull(compareByShortName);
        assertNotNull(compareByYearOfFoundation);
    }
}