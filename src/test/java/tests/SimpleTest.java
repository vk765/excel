package tests;

import core.ExcelReader;
import io.github.sskorol.core.DataSupplier;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

public class SimpleTest {

  @DataSupplier(runInParallel = true)
  public List<String> getNumbers() {
    return new ExcelReader().getValuesFromExcel(new File("/Users/user/Downloads/numbers.xls"));
  }

  @Test(dataProvider = "getNumbers")
  public void registerPersonalAccount(String phone) {
    // Do something
  }

  @Test
  public void toMapTest() {
    Map<Double, String> map =
        new ExcelReader().getValuesFromExcelToMap(new File("/Users/user/Downloads/numbers.xls"));
    map.values().forEach(System.out::println);
  }
}
