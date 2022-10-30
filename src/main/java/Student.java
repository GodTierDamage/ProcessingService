public class Student {

    private final int id;
    private String firstName;
    private String secondName;
    private String surname;
    private int universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    public Student(int id, String firstName, String secondName, String surname,
                   int universityId, int currentCourseNumber, float avgExamScore) {
        if(secondName == null){
            secondName = "";
        }
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return String.format("""
                Student: %s %s%s
                id: %d
                university id: %d
                number of current course: %d
                average score for exam: %.1f
                """, surname, firstName, secondName.equals("")? "" : " " + secondName,
        id, universityId, currentCourseNumber, avgExamScore);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public int getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }
}
