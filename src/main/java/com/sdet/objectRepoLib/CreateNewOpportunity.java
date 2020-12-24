package com.sdet.objectRepoLib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet.utils.WebDriverUtils;

public class CreateNewOpportunity extends WebDriverUtils {
	
	 WebDriver driver;
		
		public CreateNewOpportunity(WebDriver driver) {     
	        this.driver = driver;
			PageFactory.initElements(driver, this);
		}		
		
		@FindBy(name = "potentialname")
		private WebElement  opportNamee;
		
		@FindBy(xpath = "//div[@class='small']//following-sibling::span[text()='Creating New Opportunity']")
		private WebElement  createOpportPageWelcomeMsg;
		
		
		@FindBy(xpath = "//input[@name='related_to']//following-sibling::img[@title='Select']")
		private WebElement  relateToLookUp;
		
		@FindBy(name = "search_text")
		private WebElement  searchTxt;
		
		
		@FindBy(name = "search")
		private WebElement search;
		
		
		@FindBy(xpath = "//input[@type='radio']")
		private List<WebElement>  assignedToRadioBtnList;
		
		@FindBy(name = "assigned_group_id")
		private WebElement  groupDropDownSelect;
		
		@FindBy(name = "closingdate")
		private WebElement  closingDate;
		
		@FindBy(name = "sales_stage")
		private WebElement  salesStageSelect;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement  saveBtn;
		
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement  sucessMsg;
		

		public WebElement getCreateOpportPageWelcomeMsg() {
			return createOpportPageWelcomeMsg;
		}
		
		
		
		
	
		public WebElement getOpportName() {
			return opportNamee;
		}





		public WebElement getRelateToLookUp() {
			return relateToLookUp;
		}





		public WebElement getSearchTxt() {
			return searchTxt;
		}





		public WebElement getSearch() {
			return search;
		}





		public List<WebElement> getAssignedToRadioBtnList() {
			return assignedToRadioBtnList;
		}





		public WebElement getGroupDropDownSelect() {
			return groupDropDownSelect;
		}





		public WebElement getSalesStageSelect() {
			return salesStageSelect;
		}





		public WebElement getSaveBtn() {
			return saveBtn;
		}





		public WebElement getSucessMsg() {
			return sucessMsg;
		}
		
		



		
		public WebElement getOpportNamee() {
			return opportNamee;
		}





		public WebElement getClosingDate() {
			return closingDate;
		}





		/** to verify create opportunity  page is displayed
		 * 
		 * return String
		 */


		public String verifyCreateOpportunityPage() {
			String welcomeTxt=  createOpportPageWelcomeMsg.getText();			
			return welcomeTxt;
		}
		
		
		/**
		 * used create Opportunity with below parameter
		 * @param opportName
		 * @param orgName
		 * @param assignedToGroup
		 * @param ExpectedCloseDate
		 * @param salesStage
		 */
		public void creatOpportunity(String opportName , String orgName, String assignedToGroup , String expectedCloseDate,String salesStage ) {
			
			opportNamee.sendKeys(opportName);
			relateToLookUp.click();
			switchToWindow(driver, "Accounts&action");
            searchTxt.sendKeys(orgName);
            search.click();
            driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
        	switchToWindow(driver, "Potentials&action");
        	List<WebElement> list = assignedToRadioBtnList;
        	for (WebElement list1 : list) {
    			if (list1.getAttribute("value").equals("T")) {
    				list1.click();
    			}
    			else if(list1.getAttribute("value").equals("U"))
    			{
    				list1.click();
    			}
    		}
        	WebElement groupDropDownselect = groupDropDownSelect;
        	select(groupDropDownSelect, assignedToGroup);
        	
        	closingDate.sendKeys(expectedCloseDate);
        	
        	WebElement salesStageselect = salesStageSelect;
        	select(salesStageselect, salesStage);
        	
        	saveBtn.click();
		}
		
		
		

}
