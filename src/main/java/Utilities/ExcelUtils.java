package Utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {

    public static String[][] getExcelData(String excelSheetName) {

        File file = new File(System.getProperty("user.dir")+ConfigReader.getProperty("TestDataPath"));

        try (FileInputStream fis = new FileInputStream(file);
             Workbook wb = WorkbookFactory.create(fis)) {

            Sheet sheet = wb.getSheet(excelSheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + excelSheetName);
            }

            int totalRows = sheet.getLastRowNum();
            Row headerRow = sheet.getRow(0);
            int totalColumns = headerRow.getLastCellNum();

            DataFormatter formatter = new DataFormatter();
            String[][] testData = new String[totalRows][totalColumns];

            for (int i = 1; i <= totalRows; i++) {

                Row row = sheet.getRow(i);

                for (int j = 0; j < totalColumns; j++) {

                    String value = "";

                    if (row != null) {
                        Cell cell = row.getCell(j);

                        if (cell != null) {
                            value = formatter.formatCellValue(cell);
                        }
                    }

                    testData[i - 1][j] = value;
                }
            }

            return testData;

        } catch (Exception e) {
            throw new RuntimeException("Error reading Excel data from sheet: " + excelSheetName, e);
        }
    }
}