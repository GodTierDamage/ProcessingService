package services;

import moduls.University;
import org.apache.commons.lang3.StringUtils;

public class CompareUniversitiesByStudyProfile implements UniversityComparator{

    private CompareUniversitiesByStudyProfile () {}

    public static CompareUniversitiesByStudyProfile getInstance() {
        return new CompareUniversitiesByStudyProfile();
    }

    public static int compareByStudyProfile(University o1, University o2){
        return new CompareUniversitiesByStudyProfile().compare(o1, o2);
    }

    @Override
    public int compare(University o1, University o2) {
        if(o1 == null || o2 == null || o1.getMainStudyProfile() == null || o2.getMainStudyProfile() == null) {
            throw new NullPointerException("Universities variable or mainStudyProfile contains null");
        }
        return StringUtils.compare(o1.getMainStudyProfile().getProfileName(), o2.getMainStudyProfile().getProfileName());
    }
}
