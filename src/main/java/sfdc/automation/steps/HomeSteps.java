package sfdc.automation.steps;

import java.util.List;

import cucumber.api.java.en.And;
import sfdc.automation.impl.Home;
import sfdc.automation.impl.HomeImpl;

public class HomeSteps {
	
	
	Home home = new HomeImpl();
	@And("^user sees the below objects$")
	public void validateTab(List<String> tabList) throws Throwable {
	   home.validateTabs(tabList);
	}
	
	

}
