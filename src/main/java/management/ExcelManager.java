package management;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelManager {

    private Sheet sh;
    private Workbook wb;
    private FileInputStream fis;
    private FileOutputStream fos;
    private Cell cell;
    private Row row;
    private CellStyle cellStyle;
    private Color color;
    private String excelFilePath;

    private Map<String, Integer> columns = new HashMap<>();


    public void setExcelFile(String excelPath, String sheetName) {

        try {
            File f = new File(excelPath);

            if (!f.exists()) {
                f.createNewFile();
                System.out.println("File doesn't exist! Creating new file...");
            }
            fis = new FileInputStream(excelPath);
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet(sheetName);
            if (sh == null) {
                sh = wb.createSheet(sheetName);
            }
            this.excelFilePath = excelPath;

            sh.getRow(0).forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void setCellData(String text, int rownum, int colnum) throws IOException {
        try {
            row = sh.getRow(rownum);
            if (row == null) {
                row = sh.createRow(rownum);
            }
            cell = row.getCell(colnum);
            if (cell == null) {
                cell = row.createCell(colnum);
            }
            cell.setCellValue(text);

            fos = new FileOutputStream(excelFilePath);
            wb.write(fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            throw (e);
        }
    }

    public String getCellData(int rownum, int colnum) {

        try {
            cell = sh.getRow(rownum).getCell(colnum);
            String cellData = null;
            switch (cell.getCellType()) {
                case STRING:
                    cellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellData = String.valueOf(cell.getDateCellValue());
                    } else {
                        cellData = String.valueOf((long) cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    cellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    cellData = "";
                    break;
            }
            return cellData;
        } catch (Exception e) {
            return "";
        }
    }

    public String getCellData(String colName, int rownum) {
        return getCellData(rownum, columns.get(colName));
    }
}