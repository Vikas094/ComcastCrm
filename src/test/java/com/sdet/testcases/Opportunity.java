package com.sdet.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.sdet.objectRepoLib.BaseClass;
import com.sdet.objectRepoLib.CreateNewOpportunity;
import com.sdet.objectRepoLib.CreateNewOrganaztion;
import com.sdet.objectRepoLib.HomePage;
import com.sdet.objectRepoLib.LoginPage;
import com.sdet.objectRepoLib.OgganizationPage;
import com.sdet.objectRepoLib.OpportunitiesPage;
import com.sdet.objectRepoLib.OpportunityInfo;
import com.sdet.utils.ExcelUtility;
import com.sdet.utils.FileUtility;
import com.sdet.utils.JavaUtils;
import com.sdet.utils.WebDriverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vikas
 * 
 */

public class Opportunity extends BaseClass {
	private static String orgName;
	private LoginPage loginPage;
	private HomePage homePage;
	private boolean flag = false;
	private OpportunitiesPage opportunityPage;
	private CreateNewOpportunity createNewOpportunity;
	private OpportunityInfo opportunityInfo;
	private CreateNewOrganaztion createNewOrgnazation;
	private OgganizationPage orgPage;

	@Test(invocationCount = 1, enabled = true)
	public void createOrgnazationTest() throws Throwable {
		/* test data */
		orgName = elib.getExcelData("Opportunity", 9, 1) + JavaUtils.getRanDomData();
		String orgIndustry = elib.getExcelData("Opportunity", 9, 2);
		String orgType = elib.getExcelData("Opportunity", 9, 3);
		String orgRating = elib.getExcelData("Opportunity", 9, 4);

		/* Verify Home page */
		homePage = new HomePage(driver);
		flag = homePage.verifyHomePage();
		Assert.assertTrue(flag, "Home page is not displayed");
		Reporter.log("Home page is displayed", true);

		/* step 2 : navigate to Organization page */

		homePage.getOrgLnk().click();

		/* step 3 : navigate to create Organization Page */
		orgPage = new OgganizationPage(driver);
		orgPage.getCreateOrgImg().click();

		/* step 4 : create a Organization */
		createNewOrgnazation = new CreateNewOrganaztion(driver);
		createNewOrgnazation.creatOrganization(orgName, orgIndustry, orgType, orgRating);
	}

	@Test(priority = 1, dependsOnMethods = "createOrgnazationTest", enabled = true)
	public void createOpportunityOneTest() throws Throwable {

		/* Test Data */
		String opportName = elib.getExcelData("Opportunity", "tc_01", "Opportunity Name") + JavaUtils.getRanDomData();
		String realtedToOrg = elib.getExcelData("Opportunity", "tc_01", "Related To");
		String assignedTo = elib.getExcelData("Opportunity", "tc_01", "Assigned To");
		String closindDate = elib.getExcelData("Opportunity", "tc_01", "Expected Close Date");
		String salesStage = elib.getExcelData("Opportunity", "tc_01", "Sales Stage");

		/* Verify Home page */
		homePage = new HomePage(driver);
		flag = homePage.verifyHomePage();
		Assert.assertTrue(flag, "Home page is not displayed");
		Reporter.log("Home page is displayed", true);

		/* step 2 : navigate to Opportunities page */
		homePage.getOpportunitiesLink().click();

		/* Verify Opportunities list page */
		opportunityPage = new OpportunitiesPage(driver);
		String actOpportunityText = opportunityPage.verifyOpportunityPage();
		Assert.assertTrue(actOpportunityText.equals("Opportunities"), "Mismatch");
		Reporter.log("Opportunities list page is dislayed", true);

		/* step 3 : navigate to create Opportunities Page */
		opportunityPage.getCreateOpportImg().click();

		/* Verify Create Opportunity page */
		createNewOpportunity = new CreateNewOpportunity(driver);
		String actCeateOpportunityText = createNewOpportunity.verifyCreateOpportunityPage();
		Assert.assertTrue(actCeateOpportunityText.equals("Creating New Opportunity"), "Mismatch");
		Reporter.log("Creating New Opportunity page is displayed", true);

		/* step 4 : create a Opportunities */
		createNewOpportunity.creatOpportunity(opportName, orgName, assignedTo, closindDate, salesStage);

		/* verify created opportunity */
		opportunityInfo = new OpportunityInfo(driver);
		String actOrgNAmeSuccessFullMsg = opportunityInfo.verifyCreatedOpportunity();
		Assert.assertTrue(actOrgNAmeSuccessFullMsg.contains(opportName));
		Reporter.log("created Opportunities is succesfully verified", true);	

	}

	@Test(enabled = false, dependsOnMethods = "createOrgnazationTest")
	public void createOpportunityTwoTest() throws Throwable {	

		/* Test Data */
		String opportName = elib.getExcelData("Opportunity", 5, 1) + JavaUtils.getRanDomData();
		String realtedToOrg = elib.getExcelData("Opportunity", 5, 2);
		String assignedTo = elib.getExcelData("Opportunity", 5, 3);
		String closindDate = elib.getExcelData("Opportunity", 5, 4);
		String salesStage = elib.getExcelData("Opportunity", 5, 5);


		/* Verify Home page */
		homePage = new HomePage(driver);
		flag = homePage.verifyHomePage();
		Assert.assertTrue(flag, "Home page is not displayed");
		Reporter.log("Home page is displayed", true);

		/* step 2 : navigate to Opportunities page */
		homePage.getOpportunitiesLink().click();

		/* Verify Opportunities list page */
		opportunityPage = new OpportunitiesPage(driver);
		String actOpportunityText = opportunityPage.verifyOpportunityPage();
		Assert.assertTrue(actOpportunityText.equals("Opportunities"), "Mismatch");
		Reporter.log("Opportunities list page is dislayed", true);

		/* step 3 : navigate to create Opportunities Page */
		opportunityPage.getCreateOpportImg().click();

		/* Verify Create Opportunity page */
		createNewOpportunity = new CreateNewOpportunity(driver);
		String actCeateOpportunityText = createNewOpportunity.verifyCreateOpportunityPage();
		Assert.assertTrue(actCeateOpportunityText.equals("Creating New Opportunity"), "Mismatch");
		Reporter.log("Creating New Opportunity page is displayed", true);

		/* step 4 : create a Opportunities */
		createNewOpportunity.creatOpportunity(opportName, orgName, assignedTo, closindDate, salesStage);

		/* verify created opportunity */
		opportunityInfo = new OpportunityInfo(driver);
		String actOrgNAmeSuccessFullMsg = opportunityInfo.verifyCreatedOpportunity();
		Assert.assertTrue(actOrgNAmeSuccessFullMsg.contains(opportName));
		Reporter.log("created Opportunities is succesfully verified", true);
	}

	@Test(enabled = false, dependsOnMethods = "createOrgnazationTest")
	public void createOpportunityThreeTest() throws Throwable {

		/* Test Data */
		String opportName = elib.getExcelData("Opportunity", 13, 1) + JavaUtils.getRanDomData();
		String realtedToOrg = elib.getExcelData("Opportunity", 13, 2);
		String assignedTo = elib.getExcelData("Opportunity", 13, 3);
		String closindDate = elib.getExcelData("Opportunity", 13, 4);
		String salesStage = elib.getExcelData("Opportunity", 13, 5);


		/* Verify Home page */
		homePage = new HomePage(driver);
		flag = homePage.verifyHomePage();
		Assert.assertTrue(flag, "Home page is not displayed");
		Reporter.log("Home page is displayed", true);

		/* step 2 : navigate to Opportunities page */
		homePage.getOpportunitiesLink().click();

		/* Verify Opportunities list page */
		opportunityPage = new OpportunitiesPage(driver);
		String actOpportunityText = opportunityPage.verifyOpportunityPage();
		Assert.assertTrue(actOpportunityText.equals("Opportunities"), "Mismatch");
		Reporter.log("Opportunities list page is dislayed", true);

		/* step 3 : navigate to create Opportunities Page */
		opportunityPage.getCreateOpportImg().click();

		/* Verify Create Opportunity page */
		createNewOpportunity = new CreateNewOpportunity(driver);
		String actCeateOpportunityText = createNewOpportunity.verifyCreateOpportunityPage();
		Assert.assertTrue(actCeateOpportunityText.equals("Creating New Opportunity"), "Mismatch");
		Reporter.log("Creating New Opportunity page is displayed", true);

		/* step 4 : create a Opportunities */
		createNewOpportunity.creatOpportunity(opportName, orgName, assignedTo, closindDate, salesStage);

		/* verify created opportunity */
		opportunityInfo = new OpportunityInfo(driver);
		String actOrgNAmeSuccessFullMsg = opportunityInfo.verifyCreatedOpportunity();
		Assert.assertTrue(actOrgNAmeSuccessFullMsg.contains(opportName));
		Reporter.log("created Opportunities is succesfully verified", true);	

	}
}