package moduls;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Student {

    private static final AtomicLong idIncrement = new AtomicLong();
    private final Long id;

    @SerializedName("ФИО")
    private String fullName;

    @SerializedName("id университета")
    private String universityId;

    @SerializedName("Курс")
    private int currentCourseNumber;

    @SerializedName("Средний экзаменационный бал")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return currentCourseNumber == student.currentCourseNumber && Float.compare(student.avgExamScore, avgExamScore) == 0 && Objects.equals(id, student.id) && Objects.equals(fullName, student.fullName) && Objects.equals(universityId, student.universityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, universityId, currentCourseNumber, avgExamScore);
    }
}
