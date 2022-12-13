package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import moduls.Student;
import moduls.University;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class JsonUtil {

    private static final Logger logger = Logger.getLogger(JsonUtil.class.getName());

    private static final Gson gson;

    static {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    private JsonUtil() {}

    public static String listToJson(List<?> list) {
        return gson.toJson(list);
    }

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

    public static List<Student> jsonToStudentsList(String jsonStudents){
        logger.info("Converting json to list with students");
        Type typeOfReturningList = TypeToken.getParameterized(ArrayList.class, Student.class).getType();
        return gson.fromJson(jsonStudents, typeOfReturningList);
    }

    public static List<University> jsonToUniversitiesList(String universities){
        logger.info("Converting json to list with universities");
        Type typeOfReturningList = TypeToken.getParameterized(ArrayList.class, University.class).getType();
        return gson.fromJson(universities, typeOfReturningList);
    }
}
