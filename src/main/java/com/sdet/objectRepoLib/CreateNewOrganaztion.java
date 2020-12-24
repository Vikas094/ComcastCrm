package com.sdet.objectRepoLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet.utils.WebDriverUtils;



	public class CreateNewOrganaztion extends WebDriverUtils{
		WebDriver driver;
		public CreateNewOrganaztion(WebDriver driver) { 
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(name = "accountname")
		private WebElement orgNameEdt;
		
		@FindBy(name = "industry")
		private WebElement industriesLst;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		@FindBy(name = "accounttype")
		private WebElement typeLst;
		
		@FindBy(name = "rating")
		private WebElement ratingLst;
		
		

		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}

		public WebElement getIndustriesLst() {
			return industriesLst;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		

		/**
		 *  used to create org with mandatory feilds  
		 * @param orgName
		 */
		public void creatOrganization(String orgName) {
			orgNameEdt.sendKeys(orgName);
			saveBtn.click();
		}
		/**
		 * used create orgnization with below parameter
		 * @param orgName
		 * @param indsutry
		 * @param type
		 * @param rating
		 * @throws InterruptedException 
		 */
		public void creatOrganization(String orgName , String indsutry, String type , String rating) throws InterruptedException {
			orgNameEdt.sendKeys(orgName);
			select(industriesLst, indsutry);
			select(typeLst, type);
			select(ratingLst, rating);
			saveBtn.click();
			
			Thread.sleep(2000);
		}

}

