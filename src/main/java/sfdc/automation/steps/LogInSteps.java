package sfdc.automation.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sfdc.automation.impl.LogInImpl;

public class LogInSteps {

	LogInImpl logInImpl = new LogInImpl();

	@Given("^user opens a browser$")
	public void user_opens_a_browser() throws Throwable {
		logInImpl.userOpensBrowser();
	}

	@Given("^User navigates to \"([^\"]*)\"$")
	public void user_navigates_to(String url) throws Throwable {
		// System.out.println("user navigates to sfdc");
		// throw new PendingException();
		logInImpl.navigateToUrl(url);
	}

	@When("^user enters user name as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_user_name_as_and_password_as(String userName, String passWord) throws Throwable {
		// System.out.println("user enters name and password for sfdc");
		// throw new PendingException();
		logInImpl.logInSalesForce(userName, passWord);
	}

	@Then("^user lands on Sales Force Homepage$")
	public void user_lands_on_Sales_Force_Homepage() throws Throwable {
		System.out.println("user lands on sfdc");
		// throw new PendingException();
	}

	@Then("^user logs out of the current application$")
	public void user_logs_out_of_the_current_application() throws Throwable {
		//System.out.println("user logs out of sfdc");
		// throw new PendingException();
	/*logInImpl.clickOnUserNavButton();
	logInImpl.clickOnLogOutButton();*/
	
		logInImpl.logOut();
	
	}

	@And("^user click on LogIn$")
	public void clickOnLogInButton() throws Throwable {
		System.out.println("user log into sfdc");
		logInImpl.clickOnLogInButton();
	}

}

// @Autowired