package services;

import moduls.University;
import org.apache.commons.lang3.StringUtils;

public class CompareUniversitiesByFullName implements UniversityComparator{

    private CompareUniversitiesByFullName () {}

    public static CompareUniversitiesByFullName getInstance() {
        return new CompareUniversitiesByFullName();
    }

    public static int compareByFullName(University o1, University o2){
        return new CompareUniversitiesByFullName().compare(o1, o2);
    }

    @Override
    public int compare(University o1, University o2) {
        if(o1 == null || o2 == null || o1.getFullName() == null || o2.getFullName() == null) {
            throw new NullPointerException("Universities variable or fullName contains null");
        }
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
