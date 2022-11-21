import moduls.Statistic;
import moduls.Student;
import moduls.University;
import services.XlsWriter;
import utils.GenerateStatisticUtil;
import services.XSSFFileReader;

import java.util.List;

public class Main {

    private static final String SHEETS_NAME_STUDENTS = "Студенты";
    private static final String SHEETS_NAME_UNIVERSITIES = "Университеты";
    public static final String PATH = "src/main/resources/universityInfo.xlsx";
    public static final String PATH_FOR_WRITING = "src/main/resources/statistics.xlsx";

    public static void main(String[] args) {

        List<Student> students = XSSFFileReader.getStudentsFromFile(SHEETS_NAME_STUDENTS, PATH);
        List<University> universities = XSSFFileReader.getUniversitiesFromFile(SHEETS_NAME_UNIVERSITIES, PATH);

        List<Statistic> statistics = GenerateStatisticUtil.createListWithStatistic(students, universities);

        XlsWriter writer = new XlsWriter();

        if(writer.writeStatisticToFile(statistics, PATH_FOR_WRITING)) {
            System.out.println("Writing completed successfully");
            System.out.println("Check table to path " + PATH_FOR_WRITING);
        } else {
            System.out.println("Something went wrong");
        }

//
//        String jsonStudents = JsonUtil.studentsToJson(students);
//        String jsonUniversities = JsonUtil.universitiesToJson(universities);
//
////        System.out.println(jsonStudents);
////        System.out.println(jsonUniversities);
//
//        List<Student> studentsFromJson = JsonUtil.jsonToStudentsList(jsonStudents);
//        List<University> universityFromJson = JsonUtil.jsonToUniversitiesList(jsonUniversities);
//
////        System.out.println(students.equals(studentsFromJson));
////        System.out.println(universities.equals(universityFromJson));
//
//        universities.forEach(university -> {
//            String universityToJson = JsonUtil.universityToJson(university);
//            System.out.println(universityToJson);
//            University fromJsonUniversity = JsonUtil.jsonToUniversity(universityToJson);
//            System.out.println(fromJsonUniversity);
//        });

//        System.out.println("Сортировка студентов по среднему экзаменационному балу в порядке убывания");
//        System.out.println("________________________________________________________________");
//        Comparator<Student> studentComparator = ComparatorUtils.getStudentsComparator(StudentComparators.COMPARE_BY_AVG_EXAM_SCORE);
//        students.stream().sorted(studentComparator).forEach(System.out::println);
//
//        System.out.println("________________________________________________________________");
//        System.out.println("Сортировка студентов по id");
//        System.out.println("________________________________________________________________");
//        studentComparator = ComparatorUtils.getStudentsComparator(StudentComparators.COMPARE_BY_ID);
//        students.stream().sorted(studentComparator).forEach(System.out::println);
//
//        System.out.println("________________________________________________________________");
//        System.out.println("Сортировка студентов по ФИО");
//        System.out.println("________________________________________________________________");
//        studentComparator = ComparatorUtils.getStudentsComparator(StudentComparators.COMPARE_BY_FULL_NAME);
//        students.stream().sorted(studentComparator).forEach(System.out::println);
//
//        System.out.println("________________________________________________________________");
//        System.out.println("Сортировка студентов по курсу обучения");
//        System.out.println("________________________________________________________________");
//        studentComparator = ComparatorUtils.getStudentsComparator(StudentComparators.COMPARE_BY_CURRENT_COURSE_NUMBER);
//        students.stream().sorted(studentComparator).forEach(System.out::println);
//
//        System.out.println("________________________________________________________________");
//        System.out.println("Сортировка студентов по id университета");
//        System.out.println("________________________________________________________________");
//        studentComparator = ComparatorUtils.getStudentsComparator(StudentComparators.COMPARE_BY_UNIVERSITY_ID);
//        students.stream().sorted(studentComparator).forEach(System.out::println);
//
//        System.out.println("________________________________________________________________");
//        System.out.println("Сортировка университетов по id");
//        System.out.println("________________________________________________________________");
//        Comparator<University> universityComparator = ComparatorUtils.getUniversitiesComparator(UniversityComparators.COMPARE_BY_ID);
//        universities.stream().sorted(universityComparator).forEach(System.out::println);
//
//        System.out.println("________________________________________________________________");
//        System.out.println("Сортировка университетов по полному названию");
//        System.out.println("________________________________________________________________");
//        universityComparator = ComparatorUtils.getUniversitiesComparator(UniversityComparators.COMPARE_BY_FULL_NAME);
//        universities.stream().sorted(universityComparator).forEach(System.out::println);
//
//        System.out.println("________________________________________________________________");
//        System.out.println("Сортировка университетов по аббревиатуре названия");
//        System.out.println("________________________________________________________________");
//        universityComparator = ComparatorUtils.getUniversitiesComparator(UniversityComparators.COMPARE_BY_SHORT_NAME);
//        universities.stream().sorted(universityComparator).forEach(System.out::println);
//
//        System.out.println("________________________________________________________________");
//        System.out.println("Сортировка университетов по учебному профилю");
//        System.out.println("________________________________________________________________");
//        universityComparator = ComparatorUtils.getUniversitiesComparator(UniversityComparators.COMPARE_BY_STUDY_PROFILE);
//        universities.stream().sorted(universityComparator).forEach(System.out::println);
//
//        System.out.println("________________________________________________________________");
//        System.out.println("Сортировка университетов по году основания");
//        System.out.println("________________________________________________________________");
//        universityComparator = ComparatorUtils.getUniversitiesComparator(UniversityComparators.COMPARE_BY_YEAR_OF_FOUNDATION);
//        universities.stream().sorted(universityComparator).forEach(System.out::println);
    }
}
