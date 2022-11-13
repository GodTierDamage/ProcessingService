package enums;

import moduls.Student;
import moduls.University;
import services.*;

import java.util.Comparator;

public enum UniversityComparators {

    COMPARE_BY_FULL_NAME(CompareUniversitiesByFullName.getInstance()),
    COMPARE_BY_ID(CompareUniversitiesByID.getInstance()),
    COMPARE_BY_SHORT_NAME(CompareUniversitiesByShortName.getInstance()),
    COMPARE_BY_STUDY_PROFILE(CompareUniversitiesByStudyProfile.getInstance()),
    COMPARE_BY_YEAR_OF_FOUNDATION(CompareUniversitiesByYearOfFoundation.getInstance());

    private final Comparator<University> comparator;

    UniversityComparators(Comparator<University> comparator){
        this.comparator = comparator;
    }

    public Comparator<University> getComparator(){
        return comparator;
    }
}
