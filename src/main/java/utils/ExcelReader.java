package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelReader {
    public static String getCellData(String sheetName, int row, int column) {
        try (FileInputStream fis = new FileInputStream("src/test/resources/testdata/TestData.xlsx")) {
            Workbook wb = WorkbookFactory.create(fis);
            return wb.getSheet(sheetName).getRow(row).getCell(column).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
