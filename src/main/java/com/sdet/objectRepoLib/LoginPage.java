package com.sdet.objectRepoLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 WebDriver driver;
	
	public LoginPage(WebDriver driver){ 
		  this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")        
	private WebElement userNameEdt;
	
	                                   
	@FindBy(name="user_password")      
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	@FindBy(xpath="//img[@alt='logo']")
	private WebElement loginLogo;

	public WebElement getUserNameEdt() { 
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	
	public WebElement getLoginLogo() {
		return loginLogo;
	}

	/** Login into the application
	 *
	 * @param username
	 * @param password
	 * 
	 * @return void
	 * 
	 * */
	public void loginToApp(String username , String password) {  
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginButton.click();
	}
	
	/** to verify login in to the application
	 * 
	 * return boolean
	 */
	public boolean verifyLogin() {
		boolean flag = loginLogo.isDisplayed();
		
		return flag;
	}

}
