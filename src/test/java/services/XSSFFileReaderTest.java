package services;

import moduls.Student;
import moduls.University;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class XSSFFileReaderTest {

    @Test
    public void getStudentsAndUniversitiesFromXSSFFile(){
        String studentsSheetName = "Студенты";
        String universitiesSheetName = "Университеты";
        String path = "src/main/resources/universityInfo.xlsx";

        List<Student> students = XSSFFileReader.getStudentsFromFile(studentsSheetName, path);
        List<University> universities = XSSFFileReader.getUniversitiesFromFile(universitiesSheetName, path);

        assertNotNull(students);
        assertNotNull(universities);
    }
}