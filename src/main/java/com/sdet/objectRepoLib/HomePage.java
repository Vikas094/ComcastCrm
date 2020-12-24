package com.sdet.objectRepoLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet.utils.WebDriverUtils;

public class HomePage extends WebDriverUtils {
	
	 WebDriver driver;
		
		public HomePage(WebDriver driver) {     
	        this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//img[@title='vtiger-crm-logo.gif']")
		private WebElement homePageLogo;
		
		@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
		private WebElement adminstrationImg;
		
		@FindBy(linkText = "Sign Out")
	    private WebElement signOutLnk;
		
		
		@FindBy(linkText = "Contacts")
	    private WebElement contactLnk;
		
		@FindBy(linkText = "Opportunities")
	    private WebElement opportunitiesLink;
		
		@FindBy(linkText = "Organizations")
	    private WebElement orgLnk;
		
		@FindBy(linkText = "Leads")
	    private WebElement leadsLnk;
		
		@FindBy(linkText = "Products")
	    private WebElement productlnk;

		public WebElement getContactLnk() {
			return contactLnk;
		}

		public WebElement getOrgLnk() {
			return orgLnk;
		}

		public WebElement getLeadsLnk() {
			return leadsLnk;
		}
		
		
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getHomePageLogo() {
			return homePageLogo;
		}

		public WebElement getAdminstrationImg() {
			return adminstrationImg;
		}

		public WebElement getSignOutLnk() {
			return signOutLnk;
		}

		public WebElement getProductlnk() {
			return productlnk;
		}

		
		public WebElement getOpportunitiesLink() {
			return opportunitiesLink;
		}
		
		/** log out
		 * 
		 * return void 
		 */

		public void logout() {
			moveMouseToElemnet(driver, adminstrationImg);
			signOutLnk.click();
		}
		
		

		/** to verify Home page is displayed
		 * 
		 * return boolean
		 */
		public boolean verifyHomePage() {
			boolean flag = homePageLogo.isDisplayed();
			
			return flag;
		}
		

}
