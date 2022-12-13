package utils;

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
    public void serializeAndDeserializeUniversityWithJson() {
        University university = new University("0213ID", "Первый Тестовый Университет", "ПТУ", 2022, StudyProfile.COMPUTER_SCIENCE);

        String universityToJson = JsonUtil.universityToJson(university);
        University universityFromJson = JsonUtil.jsonToUniversity(universityToJson);

        assertNotNull(universityToJson);
        assertNotNull(universityFromJson);
        assertEquals(university, universityFromJson);
    }
}