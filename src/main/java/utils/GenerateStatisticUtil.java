package utils;

import enums.StudyProfile;
import moduls.Statistic;
import moduls.Student;
import moduls.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class GenerateStatisticUtil {

    private GenerateStatisticUtil() {
    }

    public static List<Statistic> createListWithStatistic(List<Student> students, List<University> universities) {
        List<Student> studentListForSearching = new ArrayList<>(students);
        List<Statistic> statistics = new ArrayList<>();
        StudyProfile[] studyProfiles = StudyProfile.values();
        for (StudyProfile studyProfile : studyProfiles) {
            List<University> universitiesByStudyProfile = filterUniversitiesByStudyProfile(universities, studyProfile);
            List<Student> studentsByStudyProfile = filterStudentsByUniversity(universitiesByStudyProfile, studentListForSearching);
            BigDecimal avg = BigDecimal.valueOf(countAvg(studentsByStudyProfile)
                    .orElse(0.0))
                    .setScale(2, RoundingMode.DOWN);
            long numberOfStudent = studentsByStudyProfile.size();
            long numberOfUniversities = universitiesByStudyProfile.size();
            String namesOfUniversities = selectShortNamesOfUniversities(universitiesByStudyProfile);
            statistics.add(new Statistic(studyProfile, avg.doubleValue(), numberOfStudent, numberOfUniversities, namesOfUniversities));
        }
        return statistics;
    }

    private static List<University> filterUniversitiesByStudyProfile(List<University> universities, StudyProfile studyProfile) {
        return universities.stream()
                .filter(university -> university.getMainStudyProfile().equals(studyProfile)).toList();
    }

    private static List<Student> filterStudentsByUniversity(List<University> universities, List<Student> students) {
        List<Student> newStudentsList = new ArrayList<>();
        for (University university : universities) {
            List<Student> findStudents = students.stream()
                    .filter(student -> student.getUniversityId().equals(university.getId()))
                    .toList();
            newStudentsList.addAll(findStudents);
        }
        students.removeAll(newStudentsList);
        return newStudentsList;
    }

    private static OptionalDouble countAvg(List<Student> students) {
        return students.stream()
                .mapToDouble(Student::getAvgExamScore)
                .average();
    }

    private static String selectShortNamesOfUniversities(List<University> universities) {
        if (universities.size() == 0) {
            return "Universities not found";
        }
        StringBuilder builder = new StringBuilder("");
        for (University university : universities) {
            builder.append(university.getShortName()).append(", ");
        }
        return builder.substring(0, builder.lastIndexOf(","));
    }
}





