package com.sdet.objectRepoLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfo {
	
	
	WebDriver driver;
	
	public OpportunityInfo(WebDriver driver) {     
        this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement sucessMssg;

	public WebElement getSucessMssg() {
		return sucessMssg;
	}
	
	

	/** to verify created opportunity 
	 * 
	 * return String
	 */

	public String verifyCreatedOpportunity() {
		String sucessTxt=  sucessMssg.getText();		
		return sucessTxt;
	}
	
	
	

}
