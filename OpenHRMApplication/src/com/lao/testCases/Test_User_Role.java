package com.lao.testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lao.commonFunctions.CommonFunctions;
import com.lao.pageObjects.User_Role_Page_Objects;

public class Test_User_Role extends CommonFunctions{
	
	static Logger logger = Logger.getLogger(Test_User_Role.class);
	
	public void moveToUsersPage()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(User_Role_Page_Objects.adminLink);
		actions.moveToElement(User_Role_Page_Objects.userManagementLink);
		actions.moveToElement(User_Role_Page_Objects.usersLink);
		actions.click().build().perform();
		logger.info("Moved to user page");
	}
	
	public void selectUserRole() {
		Select selectUserRole = new Select(User_Role_Page_Objects.usersRoleDropdown);
		selectUserRole.selectByIndex(1);
		logger.info("User role is selected");
	}
	
	public void selectStatus() {
		Select selectStatus = new Select(User_Role_Page_Objects.statusDropdown);
		selectStatus.selectByIndex(1);
		logger.info("Select status is selected");
	}
	
	@Test
	public void checkUserRole()
	{	
		PageFactory.initElements(driver,User_Role_Page_Objects.class );
		moveToUsersPage();
		selectUserRole();
		selectStatus();
		User_Role_Page_Objects.searchButton.click();
		
		String actualRole = User_Role_Page_Objects.userRoleValue.getText();
		String actualStatus = User_Role_Page_Objects.statusValue.getText();
		
		logger.info("Verify user role");
		Assert.assertEquals(actualRole, "Admin");
		logger.info("Verify status");
		Assert.assertEquals(actualStatus, "Enabled");
			
	}

}
