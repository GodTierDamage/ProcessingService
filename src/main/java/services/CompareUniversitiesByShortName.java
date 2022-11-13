package services;

import moduls.University;
import org.apache.commons.lang3.StringUtils;

public class CompareUniversitiesByShortName implements UniversityComparator{

    private CompareUniversitiesByShortName() {}

    public static CompareUniversitiesByShortName getInstance() {
        return new CompareUniversitiesByShortName();
    }

    public static int compareByShortName(University o1, University o2) {
        return new CompareUniversitiesByShortName().compare(o1, o2);
    }

    @Override
    public int compare(University o1, University o2) {
        if(o1 == null || o2 == null || o1.getShortName() == null || o2.getShortName() == null) {
            throw new NullPointerException("Universities variable or shortName contains null");
        }
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }
}
