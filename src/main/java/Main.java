import enums.StudentComparators;
import enums.UniversityComparators;
import moduls.RootElement;
import moduls.Statistic;
import moduls.Student;
import moduls.University;
import services.JsonWriter;
import services.XlsWriter;
import services.XmlWriter;
import utils.GenerateStatisticUtil;
import services.XSSFFileReader;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final String SHEETS_NAME_STUDENTS = "Студенты";
    private static final String SHEETS_NAME_UNIVERSITIES = "Университеты";
    public static final String PATH = "src/main/resources/universityInfo.xlsx";
    public static final String PATH_FOR_WRITING = "src/main/resources/statistics.xlsx";

    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }

        logger.info("Starting program");
        List<Student> students = XSSFFileReader.getStudentsFromFile(SHEETS_NAME_STUDENTS, PATH);
        List<University> universities = XSSFFileReader.getUniversitiesFromFile(SHEETS_NAME_UNIVERSITIES, PATH);

        students.sort(StudentComparators.COMPARE_BY_ID.getComparator());
        universities.sort(UniversityComparators.COMPARE_BY_ID.getComparator());

        List<Statistic> statistics = GenerateStatisticUtil.createListWithStatistic(students, universities);

        XlsWriter writer = new XlsWriter();
        writer.writeStatisticToFile(statistics, PATH_FOR_WRITING);

        RootElement elements = new RootElement();
        elements.setStudents(students);
        elements.setUniversities(universities);
        elements.setStatistics(statistics);
        elements.setDate(new Date());

        XmlWriter.createXmlFile(elements);
        JsonWriter.createJsonFiles(elements);

        logger.info("Ending program...");
    }
}
