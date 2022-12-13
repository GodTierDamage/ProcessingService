package services;

import moduls.RootElement;
import utils.JsonUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {

    private static final Logger log = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() {
    }

    public static void createJsonFiles(RootElement rootElement) {
        log.info("Starting createJsonFiles");

        Path path = Path.of("src/main/resources/jsonReqs");
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
                log.info("New directory created");
            } catch (IOException e) {
                log.log(Level.SEVERE, "Directory has not been created", e);
            }
        }
        studentsToJson(rootElement, path.toString());
        universitiesToJson(rootElement, path.toString());
        statisticsToJson(rootElement, path.toString());
        log.info("Files was written");
    }

    private static void studentsToJson(RootElement rootElement, String path) {
        String students = JsonUtil.listToJson(rootElement.getStudents());
        String studentsPath = path + "/students" + rootElement.getDate().getTime() + ".json";
        writeJsonToFile(studentsPath, students);
    }

    private static void universitiesToJson(RootElement rootElement, String path) {
        String universities = JsonUtil.listToJson(rootElement.getUniversities());
        String universitiesPath = path + "/universities" + rootElement.getDate().getTime() + ".json";
        writeJsonToFile(universitiesPath, universities);
    }

    private static void statisticsToJson(RootElement rootElement, String path) {
        String statistics = JsonUtil.listToJson(rootElement.getStatistics());
        String statisticsPath = path + "/statistics" + rootElement.getDate().getTime() + ".json";
        writeJsonToFile(statisticsPath, statistics);
    }

    private static void writeJsonToFile(String path, String json) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8))) {
            writer.write(json);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Writing error", e);
        }
    }
}
