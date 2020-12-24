package com.sdet.objectRepoLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.sdet.utils.ExcelUtility;
import com.sdet.utils.FileUtility;
import com.sdet.utils.WebDriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public WebDriverUtils wLib = new WebDriverUtils();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();	
	public DataBaseUtilities dbLib = new DataBaseUtilities();
	public static WebDriver driver;
	
	
	@BeforeSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configBeforeSuite() {
		System.out.println("====================Connect To DB========================");
		//dbLib.connectToDB();
	}
	
	
	@BeforeClass(groups = {"SmokeTest", "RegressionTest"})
	public void configBeforeClass() throws Throwable {
		System.out.println("=========launch the browser==============");
		/*Common  Data*/
		String URL  = fLib.getPropertyKeyValue("url");

		String BROWSER  = fLib.getPropertyKeyValue("browser");

		 if(BROWSER.equals("chrome")) {
			 WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		 }else if(BROWSER.equals("firefox")) {
			 driver = new FirefoxDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver(); 
		 }
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	//@Parameters("browser")
	//@BeforeClass(groups = {"SmokeTest", "RegressionTest"})
	public void configBeforeParllelClass(String BROWSER) throws Throwable {
		System.out.println("=========launch the browser==============");
		/*Common  Data*/
		String URL  = fLib.getPropertyKeyValue("url");


		 if(BROWSER.equals("chrome")) {
		    driver = new ChromeDriver();
		 }else if(BROWSER.equals("firefox")) {
			 driver = new FirefoxDriver();
		 }else if(BROWSER.equals("ie")) {
			 driver = new InternetExplorerDriver();
		 }else {
			 driver = new ChromeDriver(); 
		 }
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	
	@BeforeMethod(groups = {"SmokeTest", "RegressionTest"})
	public void cofigBeforeMtd() throws Throwable {
		System.out.println("=======login======");
		String USERNAME  = fLib.getPropertyKeyValue("username");
		String PASSWORD  = fLib.getPropertyKeyValue("password");
		
		/*step 1 : login to app*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}
	
	
	@AfterMethod(groups = {"SmokeTest", "RegressionTest"})
	public void configAfterMethode() {
		System.out.println("=======logout======");
		HomePage hp = new HomePage(driver);
		hp.logout();
		
	}
	  
	
	@AfterClass(groups = {"SmokeTest", "RegressionTest"})
	public void confifAfterClass() {
		System.out.println("=========close the browser==============");
		driver.quit();
	}

	@AfterSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configAsterSuite() throws Throwable {
		System.out.println("====================DissConnect To DB========================");
		//dbLib.closeDb();
	}

}
