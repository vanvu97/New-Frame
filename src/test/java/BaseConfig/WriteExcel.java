package BaseConfig;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class WriteExcel {

    String a;
    String b;
    String c;
    String pathExcel = "C:\\Users\\vuv1\\Desktop\\Test\\New-Frame\\src\\test\\resources\\Boo.xlsx";

    public void create(String sheetName) throws FileNotFoundException {
        File xlsxFile = new File(pathExcel);

        try {
            FileInputStream inputStream = new FileInputStream(xlsxFile);
            //Creating workbook from input stream
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.createSheet(sheetName);

            System.out.println("Created Sheet "+"'"+sheetName+"'");

            //Close input stream
            inputStream.close();

            //Crating output stream and writing the updated workbook
            FileOutputStream os = new FileOutputStream(xlsxFile);
            workbook.write(os);

            //Close the workbook and output stream
            workbook.close();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSheet() throws IOException {
        String sheetName = null;
        File xlsxFile = new File(pathExcel);

        FileInputStream inputStream = new FileInputStream(xlsxFile);

        //Creating workbook from input stream
        Workbook workbook = WorkbookFactory.create(inputStream);

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet firstSheet = workbook.getSheetAt(i);
            sheetName = firstSheet.getSheetName();
            System.out.println(sheetName);
        }
        inputStream.close();

        //Crating output stream and writing the updated workbook
        FileOutputStream os = new FileOutputStream(xlsxFile);
        workbook.write(os);

        //Close the workbook and output stream
        workbook.close();
        os.close();
        return sheetName;
    }

    public void write(String a, String b, String c, String sheetN) {
        File xlsxFile = new File(pathExcel);
        Object[][] newStudents = {
                {this.a = a, this.b = b, this.c = c}
        };

        try {
            //Creating input stream
            FileInputStream inputStream = new FileInputStream(xlsxFile);

            //Creating workbook from input stream
            Workbook workbook = WorkbookFactory.create(inputStream);

            //Reading first sheet of excel file
            Sheet sheet = workbook.getSheet(sheetN);

            //Getting the count of existing records
            int rowCount = sheet.getLastRowNum();

            //Iterating new students to update
            for (Object[] student : newStudents) {

                //Creating new row from the next row count
                Row row = sheet.createRow(++rowCount);

                int columnCount = 0;

                //Iterating student informations
                for (Object info : student) {

                    //Creating new cell and setting the value
                    Cell cell = row.createCell(columnCount++);
                    if (info instanceof String) {
                        cell.setCellValue((String) info);
                    } else if (info instanceof Integer) {
                        cell.setCellValue((Integer) info);
                    }
                }
            }
            //Close input stream
            inputStream.close();

            //Crating output stream and writing the updated workbook
            FileOutputStream os = new FileOutputStream(xlsxFile);
            workbook.write(os);

            //Close the workbook and output stream
            workbook.close();
            os.close();

            System.out.println("Excel file has been updated successfully.");

        } catch (EncryptedDocumentException | IOException e) {
            System.err.println("Exception while updating an existing excel file.");
            e.printStackTrace();
        }
    }


}
