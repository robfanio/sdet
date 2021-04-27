package Test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.XlUtils;

public class LogIn_TestDD_001 extends BaseTest {
	
	@Test(dataProvider="SignInData")
	public void SignIn(String user, String pswd) {
		LoginPage lg = new LoginPage(driver);
		lg.SignIn(user, pswd);
	}
	
	@DataProvider(name = "SignInData")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\SdetData.xlsx";
		int row = XlUtils.getRowCount(path, "Sheet1");
		int col =XlUtils.getCellCount(path, "Sheet1", 1);
		String LoginData[][] = new  String[row][col];
		
		
		for(int i =1;i<row;i++) {//outer forLoops to for row

			for(int j=0;j<col;j++) {//inner forLoops for column
				
				LoginData[i-1][j] = XlUtils.getCellData(path, "Sheet1", i, j);
			}
		
		}
		return LoginData;
		
	}
}
