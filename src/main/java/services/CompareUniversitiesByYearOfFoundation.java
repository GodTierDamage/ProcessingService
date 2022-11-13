package services;

import moduls.University;

public class CompareUniversitiesByYearOfFoundation implements UniversityComparator{

    private CompareUniversitiesByYearOfFoundation () {}

    public static CompareUniversitiesByYearOfFoundation getInstance() {
        return new CompareUniversitiesByYearOfFoundation();
    }

    public static int compareByYearOfFoundation(University o1, University o2){
        return new CompareUniversitiesByYearOfFoundation().compare(o1, o2);
    }

    @Override
    public int compare(University o1, University o2) {
        if(o1 == null || o2 == null) {
            throw new NullPointerException("Universities variable contains null");
        }
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
