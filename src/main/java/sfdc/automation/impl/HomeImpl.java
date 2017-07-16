package sfdc.automation.impl;

import java.io.IOException;
import java.util.List;

import sfdc.automation.pages.HomePage;
import sfdc.automation.pages.LogInPage;

public class HomeImpl implements Home {

	
	HomePage homePage = new HomePage();
	@Override
	public void validateTabs(List<String> tabList) throws IOException {
		
	homePage.validateTabList(tabList);	
		
	}





}
