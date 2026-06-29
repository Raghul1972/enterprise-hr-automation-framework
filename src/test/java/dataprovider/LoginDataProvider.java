package dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtils;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {

        ExcelUtils.loadExcel();

        int rows = ExcelUtils.getRowCount();

        Object[][] data = new Object[rows - 1][2];

        for (int i = 1; i < rows; i++) {

            data[i - 1][0] = ExcelUtils.getCellData(i, 0);

            data[i - 1][1] = ExcelUtils.getCellData(i, 1);
        }

        return data;
    }
}