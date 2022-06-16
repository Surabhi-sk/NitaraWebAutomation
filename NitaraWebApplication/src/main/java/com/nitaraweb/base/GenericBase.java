package com.nitaraweb.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.log4testng.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class GenericBase extends PageInitialiser{

	protected static WebDriver driver;
	protected static Properties properties;
	protected static ChromeOptions chromeOptions;
	protected static Logger log;

	public GenericBase() {

		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream("src\\main\\java\\com\\nitaraweb\\config\\config.properties");
			properties.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("io exception");

		}

	}

	@BeforeTest
	protected void initializaton() {
		String browserName = properties.getProperty("browser");
		driver = getDriver(browserName);

		PageInitialiser.initializeAllPages();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		//		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}


	private static WebDriver getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			return new ChromeDriver(chromeOptions);
		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "<Add location>");
			return new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","<Add location>");
			return new InternetExplorerDriver();
		}
		return null;
	}

	@AfterTest
	public void tearDownMain() {
		//driver.manage().deleteAllCookies();
		driver.close();
	}

}
