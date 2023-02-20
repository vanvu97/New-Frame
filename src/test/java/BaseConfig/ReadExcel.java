package BaseConfig;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import page.GetTextPage;

import java.io.FileInputStream;

public class ReadExcel {

    GetTextPage page;
    WebDriver driver;

    String pathExcel = "C:\\Users\\vuv1\\Desktop\\Test\\New-Frame\\src\\test\\resources\\Boo.xlsx";

    public void read() {
        GetTextPage page = new GetTextPage(driver);
        try {
            // Load the Excel file
            FileInputStream file = new FileInputStream(pathExcel);
            // Create a Workbook object
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            // Iterate through the sheets
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                // Check if the sheet contains the text "Data"
                if (sheet.getSheetName().contains(page.getQues())) {
                    // Iterate through the rows and cells
                    for (Row row : sheet) {
                        for (Cell cell : row) {
                            System.out.print(cell.getStringCellValue() + " ");
                        }
                        System.out.println();
                    }
                }
            }

            // Close the file
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
