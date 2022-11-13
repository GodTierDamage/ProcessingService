package services;

import moduls.University;
import org.apache.commons.lang3.StringUtils;

public class CompareUniversitiesByID implements UniversityComparator{

    private CompareUniversitiesByID() {}

    public static CompareUniversitiesByID getInstance() {
        return new CompareUniversitiesByID();
    }

    public static int compareByID(University o1, University o2){
        return new CompareUniversitiesByID().compare(o1, o2);
    }

    @Override
    public int compare(University o1, University o2) {
        if(o1 == null || o2 == null || o1.getId() == null || o2.getId() == null){
            throw new NullPointerException("Universities variable or ID contains null");
        }
        return StringUtils.compare(o1.getId(), o2.getId());
    }
}
