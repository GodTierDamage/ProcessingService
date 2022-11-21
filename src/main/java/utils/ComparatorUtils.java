package utils;

import enums.StudentComparators;
import enums.UniversityComparators;
import moduls.Student;
import moduls.University;

import java.util.Comparator;

public class ComparatorUtils {

    private ComparatorUtils(){}

    public static Comparator<Student> getStudentsComparator(StudentComparators comparator){
        return comparator.getComparator();
    }

    public static Comparator<University> getUniversitiesComparator(UniversityComparators comparator) {
        return comparator.getComparator();
    }
}
