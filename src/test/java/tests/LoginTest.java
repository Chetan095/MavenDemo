package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.RetryAnalyzer;

public class LoginTest extends BaseTest {
	
	@Test(dataProvider = "loginData")
	public void loginTest (String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
	}
	
	@DataProvider
	public Object[][] loginData(){
		return ExcelUtils.getTestData("D:\\Selenium Screenshots\\LoginData.xlsx", "Sheet1");
	}
	@Test (retryAnalyzer = RetryAnalyzer.class)
	public void failedTest() {
		driver.findElement(By.id("submit")).click();
		
	}
	
}
