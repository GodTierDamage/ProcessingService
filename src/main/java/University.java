public class University {

    private final int id;
    private String fullName;
    private String shortName;
    private int yearOfFoundation;
    private StudyProfile mainStudyProfile;

    public University(int id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainStudyProfile) {
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
                University id: %d
                Main profile: %s
                Year of foundation: %d
                """, fullName, shortName, id, mainStudyProfile, yearOfFoundation);
    }

    public int getId() {
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
