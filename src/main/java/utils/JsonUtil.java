package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import moduls.Student;
import moduls.University;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    private static final Gson gson;

    static {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    private JsonUtil() {}

    public static String studentToJson(Student student) {
        return gson.toJson(student);
    }

    public static Student jsonToStudent(String jsonStudent) {
        return gson.fromJson(jsonStudent, Student.class);
    }

    public static String universityToJson(University university) {
        return gson.toJson(university);
    }

    public static University jsonToUniversity(String university){
        return gson.fromJson(university, University.class);
    }

    public static String studentsToJson(List<Student> students) {
        return gson.toJson(students);
    }

    public static List<Student> jsonToStudentsList(String jsonStudents){
        Type typeOfReturningList = TypeToken.getParameterized(ArrayList.class, Student.class).getType();
        return gson.fromJson(jsonStudents, typeOfReturningList);
    }

    public static String universitiesToJson(List<University> universities){
        return gson.toJson(universities);
    }

    public static List<University> jsonToUniversitiesList(String universities){
        Type typeOfReturningList = TypeToken.getParameterized(ArrayList.class, University.class).getType();
        return gson.fromJson(universities, typeOfReturningList);
    }
}
