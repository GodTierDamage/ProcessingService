package moduls;

import enums.StudyProfile;

public class University {

    private final String id;
    private String fullName;
    private String shortName;
    private final int yearOfFoundation;
    private final StudyProfile mainStudyProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainStudyProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainStudyProfile = mainStudyProfile;
    }

    @Override
    public String toString() {
        return String.format("""
                University name: %s
                University short name: %s
                University id: %s
                Year of foundation: %d
                Study profile: %s
                """, fullName, shortName, id, yearOfFoundation, mainStudyProfile.getProfileName());
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainStudyProfile() {
        return mainStudyProfile;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
