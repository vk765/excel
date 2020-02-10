package core;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

  public ArrayList<String> getValuesFromExcel(File excel) {
    ArrayList<String> res = new ArrayList<>();
    try {
      FileInputStream file = new FileInputStream(excel);
      HSSFWorkbook workbook = new HSSFWorkbook(file);
      HSSFSheet sheet = workbook.getSheetAt(0);

      for (Row row : sheet) {
        Cell firstColumn = row.getCell(0);

        if (firstColumn != null) {
          res.add(firstColumn.getStringCellValue());
        }
      }
      file.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return res;
  }

  public Map<Double, String> getValuesFromExcelToMap(File excel) {
    Map<Double, String> res = new HashMap<>();
    try {
      FileInputStream file = new FileInputStream(excel);
      HSSFWorkbook workbook = new HSSFWorkbook(file);
      HSSFSheet sheet = workbook.getSheetAt(0);

      for (Row row : sheet) {
        Cell firstColumn = row.getCell(0);
        Cell code = row.getCell(2);

        if (firstColumn != null) {
          res.put(code.getNumericCellValue(), firstColumn.getStringCellValue());
        }
      }
      file.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return res;
  }
}
