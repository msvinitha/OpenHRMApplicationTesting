package com.lao.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_Role_Page_Objects {
	
	@FindBy(id = "menu_admin_viewAdminModule") 
	public static WebElement adminLink;
	
	@FindBy(id = "menu_admin_UserManagement") 
	public static WebElement userManagementLink;
	
	@FindBy(id = "menu_admin_viewSystemUsers") 
	public static WebElement usersLink;
	
	@FindBy(id = "searchSystemUser_userType") 
	public static WebElement usersRoleDropdown;
	
	@FindBy(id = "searchSystemUser_status") 
	public static WebElement statusDropdown;
	
	@FindBy(id = "searchBtn") 
	public static WebElement searchButton;
	
	@FindBy(xpath = "//*[@id=\'resultTable\']/tbody/tr[1]/td[3]") 
	public static WebElement userRoleValue;
	
	@FindBy(xpath = "//*[@id=\'resultTable\']/tbody/tr[1]/td[5]") 
	public static WebElement statusValue;
	
	
	

}
