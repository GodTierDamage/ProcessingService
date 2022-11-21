package moduls;

import enums.StudyProfile;

public class Statistic {

    private StudyProfile studyProfile;
    private double avgExamScore;
    private long numberOfStudentsByStudyProfile;
    private long numberOfUniversitiesByStudyProfile = 0;
    private String namesOfUniversities;

    public Statistic(StudyProfile studyProfile, double avgExamScore,
                     long numberOfStudentsByStudyProfile, long numberOfUniversitiesByStudyProfile, String nameOfUniversity) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.numberOfStudentsByStudyProfile = numberOfStudentsByStudyProfile;
        this.numberOfUniversitiesByStudyProfile = numberOfUniversitiesByStudyProfile;
        this.namesOfUniversities = nameOfUniversity;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public long getNumberOfStudentsByStudyProfile() {
        return numberOfStudentsByStudyProfile;
    }

    public long getNumberOfUniversitiesByStudyProfile() {
        return numberOfUniversitiesByStudyProfile;
    }

    public String getNamesOfUniversities() {
        return namesOfUniversities;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public void setNumberOfStudentsByStudyProfile(int numberOfStudentsByStudyProfile) {
        this.numberOfStudentsByStudyProfile = numberOfStudentsByStudyProfile;
    }

    public void setNumberOfUniversitiesByStudyProfile(int numberOfUniversitiesByStudyProfile) {
        this.numberOfUniversitiesByStudyProfile = numberOfUniversitiesByStudyProfile;
    }

    public void setNamesOfUniversities(String namesOfUniversities) {
        this.namesOfUniversities = namesOfUniversities;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "studyProfile=" + studyProfile +
                ", avgExamScore=" + avgExamScore +
                ", numberOfStudentsByStudyProfile=" + numberOfStudentsByStudyProfile +
                ", numberOfUniversitiesByStudyProfile=" + numberOfUniversitiesByStudyProfile +
                ", namesOfUniversities='" + namesOfUniversities + '\'' +
                '}';
    }
}
