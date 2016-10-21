package com.snb.automation.objectrepository;

public class OR {

	// region CSR Portal WebLocators

	// CSR Landing Page
	public static final String CSRuserNameTxtField = "j_username";
	public static final String CSRpasswordTxtField = "j_password";
	public static final String CSRloginBtn = "csr-button-sign-in";
	
	//public static final String CSRloginBtn = "//*[@type = 'submit']";
	public static final String CSRLogout = ".//*[@id='main']/div/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div/div[2]/ul/li/div/div[1]/span";
	public static final String CSRForgotUsernameLink = "";
	public static final String CSRForgotPasswordLink = ""; 
	
	//CSR Home Page and OAP users list to Emulate
	public static final String OAPFindUserField = "";
	public static final String OAPFindUserSearch = "";
	public static final String CSREnrollUserBtn = "";
	public static final String CSRNavigationForwardBtn = "";
	public static final String CSRNavigationBackwardBtn = "";
	public static final String OAPUserStatusDropDown = "";
	public static final String OAPListLinks = ""; //if we click on the links present in the FirstName & UserName it directs to Home Page
	
	
	// OAP Landing Page
	public static final String OAPuserNameTxtField = "username";
	public static final String OAPpasswordTxtField = "password";

	public static final String OAPForgotUsernameLink = "";
	public static final String OAPForgotPasswordLink = "";
	
	public static final String OAPloginBtn = "login-button-submit";
	public static final String OAPUserSummary = "";
	public static final String OAPMyProfileLink = "";
	public static final String OAPMyBankerLink = "";
	public static final String OAPMyUsersLink = "";
	
	
	//OAP Home Page 
	
	public static final String OAPLogout = ".//*[@id='main']/div/div[1]/div[2]/div[2]/div/div/div/div/div[1]/div[2]/div/div[2]/ul/li/div/div[1]/span";
	
	// Inactivity Logout with a Warning Message
	
	public static final String CSRTimeoutContineBtn = "";
	public static final String CSRTimeoutLogoutBtn = "";
	
	public static final String OAPTimeoutContineBtn = "";
	public static final String OAPTimeoutLogoutBtn = "";
	
	// CSR User Emulating OAP User
	public static final String CSRDropDown = "dropdown";
	public static final String EmulateEndSessionBtn = "";
	public static final String CSREmulateLink = "";
	
	
	
	

	// end region;

}
