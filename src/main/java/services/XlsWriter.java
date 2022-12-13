package services;

import moduls.Statistic;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsWriter {

    private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());

    public boolean writeStatisticToFile(List<Statistic> statistics, String pathToFile) {
        logger.info("Starting method writeStaticToFile");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Статистика");
        XSSFCellStyle headingCellStyle = workbook.createCellStyle();
        XSSFFont headingFont = workbook.createFont();
        createHeadingStyle(headingCellStyle, headingFont);
        createHeading(sheet, headingCellStyle);

        XSSFCellStyle baseCellStyle = workbook.createCellStyle();
        XSSFFont baseFont = workbook.createFont();
        createBaseStyle(baseCellStyle, baseFont);
        fillSheet(sheet, baseCellStyle, statistics);
        try {
            logger.info("Writing statistic to file");
            workbook.write(new FileOutputStream(pathToFile));
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            try {
                logger.info("Closing workbook");
                workbook.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return true;
    }

    private void createHeadingStyle(XSSFCellStyle style, XSSFFont font) {
        font.setBold(true);
        font.setFontHeight(14);
        font.setFontName("Times new Roman");
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);
    }

    private void createHeading(XSSFSheet sheet, XSSFCellStyle headingStyle) {
        String[] heading = {"Учебный профиль", "Средний бал", "Количество студентов", "Количество университетов", "Названия университетов"};
        XSSFRow row = sheet.createRow(0);
        for(int i = 0; i < heading.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellStyle(headingStyle);
            cell.setCellValue(heading[i]);
            sheet.autoSizeColumn(i);
        }
    }

    private void createBaseStyle(XSSFCellStyle style, XSSFFont font) {
        font.setBold(false);
        font.setFontHeight(12);
        font.setFontName("Times new Roman");
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);
    }

    private void fillSheet(XSSFSheet sheet,  XSSFCellStyle cellStyle, List<Statistic> statistics) {
        for(int i = 1; i <= statistics.size(); i++) {
            XSSFRow row = sheet.createRow(i);
            Statistic statistic = statistics.get(i - 1);

            XSSFCell cell = row.createCell(0, CellType.STRING);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(statistic.getStudyProfile().getProfileName());

            cell = row.createCell(1, CellType.NUMERIC);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(statistic.getAvgExamScore());

            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(statistic.getNumberOfStudentsByStudyProfile());

            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(statistic.getNumberOfUniversitiesByStudyProfile());

            cell = row.createCell(4, CellType.STRING);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(statistic.getNamesOfUniversities());
        }
    }
}