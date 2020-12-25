package com.sdet.testcases;

import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.MediaSize.Other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.sdet.utils.JavaUtils;
import com.sdet.utils.WebDriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script1 {

	/* Common data */
	String userName = "admin";
	String userPassword = "manager";
	String actmsg = "";
	String expmsg = "";

	/* test data */

	int randonResult = JavaUtils.getRanDomData();
	String orgName = "skillrary" + randonResult;
	String industryType = "Technology";
	String accountType = "Other";
	String rating = "Active";
	String searchOrg = orgName;
	String searchField = "Organization Name";

	@Test(invocationCount = 1, enabled = true)
	public void script1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		// Login into the application
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(userPassword);
		driver.findElement(By.id("submitButton")).click();

		// Click on organization link
		driver.findElement(By.linkText("Organizations")).click();

		// Click on create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']/..")).click();

		// Pass organization name
		driver.findElement(By.name("accountname")).sendKeys(orgName);

		// select industry type

		WebElement industryElm = driver.findElement(By.name("industry"));
		WebDriverUtils driverUtils = new WebDriverUtils();
		driverUtils.select(industryElm, industryType);

		// select account type
		WebElement accountTypeElm = driver.findElement(By.name("accounttype"));
		driverUtils.select(accountTypeElm, accountType);

		// select rating
		WebElement ratingElm = driver.findElement(By.name("rating"));
		driverUtils.select(ratingElm, rating);

		// click on save btn
		driver.findElement(By.xpath("//input[@name='button']")).click();

		// Navigate back
		driver.navigate().back();

		// Click on organization link
		driver.findElement(By.linkText("Organizations")).click();

		// Search created organization
		driver.findElement(By.className("txtBox")).sendKeys(searchOrg);

		// Select search field
		WebElement searchFieldElm = driver.findElement(By.name("search_field"));
		driverUtils.select(searchFieldElm, searchField);

		// click on search now
		driver.findElement(By.name("submit")).click();
	        Thread.sleep(7000);
//		actmsg=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[@class='lvtColData']/td[3]/a[text()='"+orgName+"']")).getText();
//		System.out.println(actmsg);
//		Assert.assertEquals(actmsg, orgName, "Mismatch");
//		Reporter.log("Name of the organization sucessfully created is===>>>" + actmsg, true);
//
//		// Navigate back
//		driver.navigate().back();
//
//		// Click on organization link
//		driver.findElement(By.linkText("Organizations")).click();
//
//		// for deletion of ornaziation
//
//		driver.findElement(By.xpath("//a[text()='" + orgName + "']/../../td[8]/a[text()='del']")).click();
//		driverUtils.acceptingAlert(driver);
	}
}
