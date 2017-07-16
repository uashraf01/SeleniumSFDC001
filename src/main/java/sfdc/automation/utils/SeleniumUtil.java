package sfdc.automation.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumUtil {

	/*
	 * We will create a null object of WebDriver Interface since WebDriver is an
	 * Interface And we can't instantiate an object of an Interface. So, we will
	 * instantiate it whenever required by implementation of WebDriver Interface
	 * that is ChromeDriver/whichever as we see on around line #52 & 53
	 * webDriver = new ChromeDriver(); webDriver = new FirefoxDriver();
	 */

	public WebDriver webDriver = null;
	/*
	 * We don't need more than one object of WebDriver. Because, if we have more
	 * than one Driver They will keep opening new browser/windows. And
	 * SeleniumUtil Class is responsible for creating the object of WebDriver,
	 * so we do not need more than one object of SeleniumUtil at Application
	 * Level. To achieve this we will be using Singleton Java Pattern. In this
	 * pattern we will make SeleniumUtil Constructor as private so that no one
	 * can create its object and we will create a static method in SeleniumUtil
	 * to get the object of SeleniumUtil Class. And in this method, we will
	 * check whether we already have object of SeleniumUtil class or not. If it
	 * already exists, then we will return the object else if we are
	 * initializing fit for the first time we will create a new object and
	 * return it. So,if anyone wants to create the object of the class
	 * SeleniumUtil, they can use the static method we created
	 * 
	 */
	private static SeleniumUtil seleniumUtil;

	public static SeleniumUtil getSeleniumUtil() {
		if (seleniumUtil == null) {
			seleniumUtil = new SeleniumUtil("chrome");
			return seleniumUtil;
		} else {
			return seleniumUtil;
		}

	}

	private SeleniumUtil(String browser) {
		// This is to check whether wedDriver is initiated or Not.
		// So, it it is first time means WebDriver is null, then only, we will
		// go inside
		// and initialize the driver
		if (webDriver == null) {

			System.setProperty("webdriver.gecko.driver", "C:/WS/geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", "C:/WS/chromedriver.exe");
			if (browser.equalsIgnoreCase("firefox")) {
				webDriver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				webDriver = new ChromeDriver();

				webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			} else if (browser.equalsIgnoreCase("IE")) {

			} else {
				webDriver = new FirefoxDriver();
			}

			// driver = new FirefoxDriver();
			webDriver.manage().window().maximize();

		}
	}

	public void navigateTo(String url) {
		webDriver.get(url);
	}

	public void logInSalesForce(String userName, String passWord) {

		webDriver.findElement(By.id("username")).sendKeys("ulfat.a.ashraf1@gmail.com");
		webDriver.findElement(By.id("password")).sendKeys("ws85926056");
		webDriver.findElement(By.name("Login")).click();

		System.out.println("Entering User salesForce LogIn" + userName + passWord);

	}
	// sending to github

	// Highlight the name of the method (sendKeysByXPat) then press Alt + Shift
	// + J ; this will add a Java doc comment

	/**
	 * This method will use two parameters xPath of a web element and the value
	 * entered by the user
	 * 
	 * @param xPath
	 * @param value
	 */
	public void sendKeysByXPath(String xPath, String value) {

		// Get web element of input field from given xpath
		// To enter a value in a input field on a web page, first by the use of
		// findelementmethod in WebDriver Class, we will get the element of the
		// the input field
		WebElement elementToEnterValue = webDriver.findElement(By.xpath(xPath));

		// Now we will enter a given value into the selected web element by
		// using sendKeys Method of WebElement Class
		elementToEnterValue.sendKeys(value);

		// WebElement is an Interface; sendKeys method returns Void, we don't
		// need to assign any object to it.

	}

	public void clickElementByXpath(String xPath) {
		WebElement elementToBeClicked = webDriver.findElement(By.xpath(xPath));
		elementToBeClicked.click();

	}

	/**
	 * This method will take Input Parameter as a tab name. And will create an
	 * xPath from the given input parameter And it will try to find the element
	 * for this xpath and will return true if the element does exist or will
	 * return false if tag is not on the screen
	 * 
	 * @param tabName
	 * @return
	 */
	public boolean isTabDisplayed(String tabName) {
		String tabXpath = ".//ul/li/a[contains(@title,'" + tabName + " Tab')]";

		WebElement tabElement = webDriver.findElement(By.xpath(tabXpath));

		if (tabElement == null) {
			return false;
		} else {
			return true;
		}

	}

	public void takeScreenShot() throws IOException {
		File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("c:\\screenshot.png"));
	}

	public void clickOnUserNavButton(String xPath_UserNavButton) {
		// TODO Auto-generated method stub

	}

	public void clickOnLogOutButton(String xPath_LogOutButton) {
		// TODO Auto-generated method stub

	}

}
