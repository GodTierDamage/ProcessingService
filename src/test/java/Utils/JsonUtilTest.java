package Utils;

import enums.StudyProfile;
import moduls.Student;
import moduls.University;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JsonUtilTest {

    @Test
    public void serializeAndDeserializeStudentWithJson() {
        Student student = new Student("Mr.Test", "03Un", 4, 3.5f);

        String json = JsonUtil.studentToJson(student);
        assertNotNull(json);

        Student student1 = JsonUtil.jsonToStudent(json);
        assertNotNull(student1);
        assertEquals(student1, student);
    }

    @Test
    public void serializeAndDeserializeListOfStudentWithJson() {
        Student student = new Student("Mr.Test", "03Un", 4, 3.5f);
        Student student1 = new Student("Mr.Test1", "03Un", 4, 3.5f);
        Student student2 = new Student("Mr.Test2", "03Un", 4, 3.5f);

        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(student);
        listOfStudents.add(student1);
        listOfStudents.add(student2);

        String studentsJson = JsonUtil.studentsToJson(listOfStudents);
        List<Student> fromJsonList = JsonUtil.jsonToStudentsList(studentsJson);

        assertNotNull(studentsJson);
        assertNotNull(fromJsonList);
        assertEquals(listOfStudents, fromJsonList);

        Student stdFromJson = fromJsonList.get(0);
        Student stdFromJson1 = fromJsonList.get(1);
        Student stdFromJson2 = fromJsonList.get(2);

        assertEquals(student, stdFromJson);
        assertEquals(student1, stdFromJson1);
        assertEquals(student2, stdFromJson2);
    }

    @Test
    public void serializeAndDeserializeUniversityWithJson() {
        University university = new University("0213ID", "Первый Тестовый Университет", "ПТУ", 2022, StudyProfile.COMPUTER_SCIENCE);

        String universityToJson = JsonUtil.universityToJson(university);
        University universityFromJson = JsonUtil.jsonToUniversity(universityToJson);

        assertNotNull(universityToJson);
        assertNotNull(universityFromJson);
        assertEquals(university, universityFromJson);
    }

    @Test
    public void serializeAndDeserializeUniversitiesListWithJson() {
        University university1 = new University("0213ID", "Первый Тестовый Университет", "ПТУ", 2022, StudyProfile.COMPUTER_SCIENCE);
        University university2 = new University("0213ID", "Второй Тестовый Университет", "ВТУ", 2022, StudyProfile.COMPUTER_SCIENCE);
        University university3 = new University("0213ID", "Третий Тестовый Университет", "ТТУ", 2022, StudyProfile.COMPUTER_SCIENCE);
        List<University> universities = new ArrayList<>();

        universities.add(university1);
        universities.add(university2);
        universities.add(university3);

        String universitiesToJson = JsonUtil.universitiesToJson(universities);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversitiesList(universitiesToJson);
        University universityFromJson1 = universitiesFromJson.get(0);
        University universityFromJson2 = universitiesFromJson.get(1);
        University universityFromJson3 = universitiesFromJson.get(2);

        assertNotNull(universitiesToJson);
        assertNotNull(universitiesFromJson);
        assertNotNull(universityFromJson1);
        assertNotNull(universityFromJson2);
        assertNotNull(universityFromJson3);

        assertEquals(universities, universitiesFromJson);
        assertEquals(university1, universityFromJson1);
        assertEquals(university2, universityFromJson2);
        assertEquals(university3, universityFromJson3);

    }
}