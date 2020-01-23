package com.broken.images;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.broken.images.config.Config;

public class TestBase {
	public WebDriver driver;

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
		driver.get(Config.AppUrl);
	}

	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}

}
