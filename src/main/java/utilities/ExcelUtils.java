package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static void loadExcel() throws IOException {

        FileInputStream fis = new FileInputStream(
                "./src/test/resources/testdata/LoginData.xlsx");

        workbook = new XSSFWorkbook(fis);

        sheet = workbook.getSheet("Login");
    }
    public static String getCellData(int rowNum, int colNum) {

        Row row = sheet.getRow(rowNum);

        Cell cell = row.getCell(colNum);

        return cell.toString();
    }
    public static int getRowCount() {

        return sheet.getPhysicalNumberOfRows();
    }
}