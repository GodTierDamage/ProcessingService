package utils;

import moduls.Statistic;
import moduls.Student;
import moduls.University;
import org.junit.Test;
import services.XSSFFileReader;

import java.util.List;

import static org.junit.Assert.*;

public class GenerateStatisticUtilTest {

    @Test
    public void generateStatisticFromStudentsAndUniversities() {
        String SHEETS_NAME_STUDENTS = "Студенты";
        String SHEETS_NAME_UNIVERSITIES = "Университеты";
        String PATH = "src/main/resources/universityInfo.xlsx";
        List<Student> students = XSSFFileReader.getStudentsFromFile(SHEETS_NAME_STUDENTS, PATH);
        List<University> universities = XSSFFileReader.getUniversitiesFromFile(SHEETS_NAME_UNIVERSITIES, PATH);

        assertNotNull(students);
        assertNotNull(universities);

        List<Statistic> statistics = GenerateStatisticUtil.createListWithStatistic(students, universities);

        assertNotNull(statistics);
    }

}