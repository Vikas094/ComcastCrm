package com.sdet.objectRepoLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	 WebDriver driver;
		
		public OpportunitiesPage(WebDriver driver) {     
	        this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(linkText = "Opportunities")
		private WebElement opportPageWelcomeMsg;
		
		@FindBy(xpath = "//img[@alt='Create Opportunity...']")
		private WebElement createOpportImg;


		public WebElement getOpportPageWelcomeMsg() {
			return opportPageWelcomeMsg;
		}

		
		public WebElement getCreateOpportImg() {
			return createOpportImg;
		}




		/** to verify opportunity list page is displayed
		 * 
		 * return String
		 */

		public String verifyOpportunityPage() {
			String welcomeTxt=  opportPageWelcomeMsg.getText();			
			return welcomeTxt;
		}
		
		
		

}
