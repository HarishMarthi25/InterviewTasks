package com.basic.auth;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.basic.auth.config.Config;
import com.basic.auth.utils.ReportUtil;
import com.basic.auth.utils.TestUtils;

public class TestBase {
	public WebDriver driver;
	public ExcelReader excelReader;

	public String startTime = TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa");

	@BeforeSuite
	public void initializeReport() {
		ReportUtil.startTesting(Config.ReportsPath, startTime, "Test", "1.5");
		ReportUtil.startSuite("Suite1");
	}

	@BeforeClass
	@Parameters("browserType")
	public void setUpBrowser(String browserType) throws MalformedURLException {
		if (System.getProperty("os.name").contains("Window")) {
			if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty(Config.CHROME_DRIVER_KEY, Config.Chrome_Driver_Path);
				System.out.println(" Windows OS Executing on Chrome Browser");
				driver = new ChromeDriver();
			} else if (browserType.equalsIgnoreCase("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty(Config.FIREFOX_DRIVER_KEY, Config.Firefox_Driver_path);
				System.out.println(" Windows OS  Executing on Firefox Browser");
				driver = new FirefoxDriver();
			} else if (browserType.equalsIgnoreCase("ie")) {
				System.setProperty(Config.IE_DRIVER_KEY, Config.IE_Driver_path);
				System.out.println(" Windows OS Executing on Internet Explorer Browser");
				driver = new InternetExplorerDriver();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/*@AfterClass
	public void tearDown() {
		driver.close();
	}*/

	public String[][] getData(String excelName, String sheetName) {
		excelReader = new ExcelReader();
		return excelReader.getExcelData(excelName, sheetName);
	}

	@AfterSuite
	public void stopReorts() {
		ReportUtil.addTestCase("Login Scenario", startTime, TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa"), "Pass");
		ReportUtil.endSuite();
		ReportUtil.updateEndTime(TestUtils.now("dd.MMMM.yyyy hh.mm.ss aaa"));
	}
}
