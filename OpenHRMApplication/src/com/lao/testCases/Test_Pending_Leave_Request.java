package com.lao.testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lao.commonFunctions.CommonFunctions;
import com.lao.pageObjects.Login_Page_Objects;
import com.lao.pageObjects.Dashboard_Page_Objects;

public class Test_Pending_Leave_Request extends CommonFunctions {
	String actualMsg = null;
	static Logger logger = Logger.getLogger(Test_Pending_Leave_Request.class);
	
	public void login() {
		PageFactory.initElements(driver, Login_Page_Objects.class);
		
		Login_Page_Objects.userName.sendKeys(properties.getProperty("username"));
		//Login_Page_Objects.passWord.sendKeys(properties.getProperty("password"));
		Login_Page_Objects.submitButton.click();
		logger.info("Login is done");
	}
	
	public void getPendingLeaveReq() {
		PageFactory.initElements(driver, Dashboard_Page_Objects.class);
		
		actualMsg = Dashboard_Page_Objects.pendingLeaveReq.getText();
		logger.info("Got pending leave request");
	}
	
	@Test
	public void verifyPendingLeaveReq()
	{
		login();
		getPendingLeaveReq();
		
		logger.info("Verify PendingLeaveReq");
		Assert.assertNotSame(actualMsg, "No Records are Available");

	}
}
