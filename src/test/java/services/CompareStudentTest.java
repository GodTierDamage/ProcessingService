package services;

import moduls.Student;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompareStudentTest {

    @Test
    public void compareStudentsByAVGExamScore(){
        Student student = new Student("Mr.Test", "Test.ID", 3, 5.0f);
        Student student1 = new Student("Mr.Test", "Test.ID", 3, 5.0f);
        Student student2 = new Student("Mr.Test", "Test.ID", 3, 3.0f);

        assertEquals("Wrong comparing result", 0.0f, CompareStudentsByAVGExamScore.compareByAVGExamScore(student, student1), 0.0f);
        assertEquals("Wrong comparing result", -1.0f, CompareStudentsByAVGExamScore.compareByAVGExamScore(student, student2), 0.0f);
        assertEquals("Wrong comparing result", 1.0f, CompareStudentsByAVGExamScore.compareByAVGExamScore(student2, student), 0.0f);
    }

    @Test
    public void compareStudentsByCurrentCourseNumber(){
        Student student = new Student("Mr.Test", "Test.ID", 3, 5.0f);
        Student student1 = new Student("Mr.Test", "Test.ID", 3, 5.0f);
        Student student2 = new Student("Mr.Test", "Test.ID", 1, 3.0f);

        assertEquals("Wrong comparing result", 0, CompareStudentsByCurrentCourseNumber.compareByCurrentCourseNumber(student, student1));
        assertEquals("Wrong comparing result", 1, CompareStudentsByCurrentCourseNumber.compareByCurrentCourseNumber(student, student2));
        assertEquals("Wrong comparing result", -1, CompareStudentsByCurrentCourseNumber.compareByCurrentCourseNumber(student2, student));
    }

    @Test
    public void compareStudentsByFullName(){
        Student student = new Student("Mr.Test", "Test.ID", 3, 5.0f);
        Student student1 = new Student("Mr.Test", "Test.ID", 3, 5.0f);
        Student student2 = new Student("Alibaba", "Test.ID", 1, 3.0f);

        assertEquals("Wrong comparing result", StringUtils.compare(student.getFullName(), student1.getFullName()),
                CompareStudentsByFullName.compareByFullName(student, student1));
        assertEquals("Wrong comparing result", StringUtils.compare(student2.getFullName(), student.getFullName()),
                CompareStudentsByFullName.compareByFullName(student2, student));
        assertEquals("Wrong comparing result", StringUtils.compare(student.getFullName(), student2.getFullName()),
                CompareStudentsByFullName.compareByFullName(student, student2));
    }

    @Test
    public void compareStudentByUniversityId(){
        Student student = new Student("Mr.Test", "Test.ID", 3, 5.0f);
        Student student1 = new Student("Mr.Test", "Test.ID", 3, 5.0f);
        Student student2 = new Student("Alibaba", "myTest.ID", 1, 3.0f);

        assertEquals("Wrong comparing result", StringUtils.compare(student.getUniversityId(), student1.getUniversityId()),
                CompareStudentsByUniversityId.compareByUniversityID(student, student1));
        assertEquals("Wrong comparing result", StringUtils.compare(student.getUniversityId(), student2.getUniversityId()),
                CompareStudentsByUniversityId.compareByUniversityID(student, student2));
        assertEquals("Wrong comparing result", StringUtils.compare(student2.getUniversityId(), student.getUniversityId()),
                CompareStudentsByUniversityId.compareByUniversityID(student2, student));
    }

    @Test
    public void compareStudentsByID(){
        Student student = new Student("Mr.Test", "Test.ID", 3, 5.0f);
        Student student1 = new Student("Mr.Test", "Test.ID", 3, 5.0f);
        Student student2 = new Student("Alibaba", "myTest.ID", 1, 3.0f);

        assertEquals("Wrong comparing result", 1, CompareStudentsByID.compareByID(student1, student));
        assertEquals("Wrong comparing result", -1, CompareStudentsByID.compareByID(student, student2));
        assertEquals("Wrong comparing result", 0, CompareStudentsByID.compareByID(student, student));
    }
}