package com.hover.details.config;

public class Config {

	public static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
	public static final String FIREFOX_DRIVER_KEY = "webdriver.gecko.driver";
	public static final String IE_DRIVER_KEY = "webdriver.ie.driver";

	public static final String Project_Base_Path = System.getProperty("user.dir");

	public static final String Chrome_Driver_Path = Project_Base_Path + "/res/drivers/chromedriver.exe";
	public static final String Firefox_Driver_path = Project_Base_Path + "/res/drivers/geckodriver.exe";
	public static final String IE_Driver_path = Project_Base_Path + "/res/drivers/IEDriverServer.exe";

	public static final String AppUrl = "https://the-internet.herokuapp.com/hovers";


}
