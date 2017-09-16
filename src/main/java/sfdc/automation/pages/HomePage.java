package sfdc.automation.pages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.automation.utils.SeleniumUtil;

public class HomePage {

	SeleniumUtil seleniumUtil = SeleniumUtil.getSeleniumUtil();
	// Home Chatter Leads Contacts accounts etc are coming up as tablist

	public void validateTabList(List<String> tabList) throws IOException {
		// seleniumUtil.takeScreenShot();
		WebElement myDynamicElement = (new WebDriverWait(seleniumUtil.webDriver, 40))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//ul/li/a[contains(@title,'Home Tab')]")));

		for (String tabName : tabList) {
			if (seleniumUtil.isTabDisplayed(tabName)) {
				System.out.println("Tab is displayed   " + tabName);
			} else {
				System.out.println("Tab is Not displayed   " + tabName);
				Assert.fail();
			}

		}

	}

}
