package steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;

import base.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAnAccountPage;

public class CreateAnAccountStep{
	CreateAnAccountPage driver = new CreateAnAccountPage(DriverFactory.getDriver());
	Faker faker = new Faker(new Locale("en-US"));
	private String email;
	
	
	/** Create User **/
	@Given("I want to access the application")
	public void i_want_to_acess_the_application() {
		
		driver.navegateTo("http://automationpractice.com/index.php");
	}

	@When("I click in Sign In option")
	public void i_click_in_sign_in_option() {
		
			driver.doLogout();
		
		driver.waitForLink("Sign in");
		driver.clickLink("Sign in");
	}

	@When("I type a valid email address that not yet was registered and click in Create an account")
	public void i_type_a_valid_email_address_that_hasn_t_already_been_registered_and_click_in_create_an_account() {
		
		driver.waitForId("email_create");
		driver.sendKeysById("email_create", email = faker.internet().safeEmailAddress());
		driver.setEmail(email);
		driver.submit("email_create");
	}

	@When("I type all personal information and click in Register button")
	public void i_type_all_personal_information_and_click_in_register_button() {
	    
		driver.personalInformation();
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		
		driver.waitForClassName("page-heading");
		assertThat(driver.getElementValueByClass("page-heading").equals("MY ACCOUNT"));
		assertThat(driver.getElementValueByClass("info-account").equals("Welcome to your account. Here you can manage all of your personal information and orders."));
	}


	/** Logoff **/
	@Given("I want do Sign Out")
	public void i_want_do_logoff() {
		
	}
	
	@When("I click in Sign out option")
	public void i_click_in_sign_out_option() {
		
		driver.doLogout();
	}
	@Then("I validate Sign Out")
	public void i_validate_logoff() {
		
		driver.waitForClassName("navigation_page");
		assertThat(driver.getElementValueByClass("navigation_page").equals("Authentication"));
	}
	
	/** Login **/
	@When("I type email and password and click in Log In")
	public void i_click_ingn_out_option(DataTable dataTable) {
		
		List<String> credentials = dataTable.asList();
		driver.doLogin(credentials.get(0), credentials.get(1));
	}
	
	/**  Login With Password Wrong **/
	/**  Login With Email Not Registered  **/
	
	@Then("I check the exception")
	public void i_check_the_exception_password() {
		
		assertThat(driver.getElementValueByXpath("//*[text()='There is 1 error']").equals("There is 1 error"));
		assertThat(driver.getElementValueByXpath("//*[text()='Authentication failed.']").equals("Authentication failed."));
	}
}
