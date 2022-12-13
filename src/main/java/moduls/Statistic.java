package moduls;

import enums.StudyProfile;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "statisticsEntry")
public class Statistic {

    @XmlElement(name = "universityProfile")
    private StudyProfile studyProfile;

    @XmlElement(name = "avgScore")
    private double avgExamScore;

    @XmlTransient
    private long numberOfStudentsByStudyProfile;

    @XmlTransient
    private long numberOfUniversitiesByStudyProfile = 0;

    @XmlTransient
    private String namesOfUniversities;

    public Statistic() {}

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
