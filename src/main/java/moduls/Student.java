package moduls;

import java.util.concurrent.atomic.AtomicLong;

public class Student {

    private static final AtomicLong idIncrement = new AtomicLong();
    private final Long id;
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    public Student (String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.id = idIncrement.incrementAndGet();
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return String.format("""
                Student: %s
                id: %d
                university id: %s
                number of current course: %d
                average score for exam: %.1f
                """, fullName, id, universityId, currentCourseNumber, avgExamScore);
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setFullName(String newName) {
        fullName = newName;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }
}
