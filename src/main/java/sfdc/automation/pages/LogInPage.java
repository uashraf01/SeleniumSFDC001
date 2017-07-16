package sfdc.automation.pages;

import sfdc.automation.utils.SeleniumUtil;

/**
 * @author Ulfat LogIn Class will work as an Interface for log In Page of the
 *         AUT (SFDC) in Page Object Model Pattern
 *
 */
public class LogInPage {
	// Instead of calling constructor, we are calling getSeleniumUtil method,
	// because SeleniumUtil constructor is private aka Java Singleton Pattern

	SeleniumUtil seleniumUtil = SeleniumUtil.getSeleniumUtil();
	String xPath_UserName = ".//input[contains(@name,'username')]";
	String xPath_Password = ".//input[contains(@name,'pw')]";
	String xPath_LogInButton = ".//input[@id='Login']";
	String xPath_UserNavButton = ".//span[@id='userNavLabel']";
	String xPath_LogOutButton = ".//a[@title='Logout']";

	/**
	 * @param url
	 *            This method will use Selenium to open the URL in configured
	 *            browser.
	 */
	public void navigateToUrl(String url) {
		seleniumUtil.navigateTo(url);
	}

	public void logInSalesForce(String userName, String passWord) {
		// seleniumUtil.logInSalesForce( userName, passWord);
		// Enter the user name using xPath
		seleniumUtil.sendKeysByXPath(xPath_UserName, userName);
		seleniumUtil.sendKeysByXPath(xPath_Password, passWord);

	}

	public void clickLogInButton() {
		seleniumUtil.clickElementByXpath(xPath_LogInButton);
	}

	public void logOut() {

		// First we will click on User Button to populate the dropdown
		seleniumUtil.clickElementByXpath(xPath_UserNavButton);
		// Then user will click on the logout option from the populated
		// dropdown.
		seleniumUtil.clickElementByXpath(xPath_LogOutButton);
	}

}
