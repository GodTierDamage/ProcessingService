public enum StudyProfile {

    COMPUTER_SCIENCE("Информатика и вычислительная техника"),
    MEDICINE("Медицина"),
    ECONOMY("Экономика"),
    PEDAGOGY("Педагогика"),
    LINGUISTICS("Лингвистика");

    private String profileName;

    StudyProfile(String profileName){
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    @Override
    public String toString() {
        return profileName;
    }
}
