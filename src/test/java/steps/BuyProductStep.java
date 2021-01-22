package steps;

import static org.assertj.core.api.Assertions.assertThat;
import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BuyProductPage;

public class BuyProductStep {
	BuyProductPage driver = new BuyProductPage(DriverFactory.getDriver());
	
	@Given("I want buy a product")
	public void i_want_buy_a_product() {
		driver.doLogin("sonny.gaylord@example.com", "123456");		
		driver.waitForClassName("sf-with-ul");
	}

	@When("I access the menu DRESSES")
	public void i_access_the_menu_dresses() {
		
		driver.clickLink("DRESSES");
		driver.clickLink("Casual Dresses");
	}

	@When("I add to cart the first item")
	public void i_add_to_cart_the_first_item() {
		
		driver.addToCart();
	}

	@When("I Proceed to checkout \\(varias vezes)")
	public void i_proceed_to_checkout_varias_vezes() {
		
		driver.proceedToCheckout(); 
	}

	@When("I choose pay by bank wire")
	public void i_choose_pay_by_bank_wire() {
	   
		driver.waitForXpath("//*[text()=' Payment']");
	    driver.clickByClass("bankwire");
	}

	@When("I confirm my order")
	public void i_confirm_my_order() {
	   
		driver.waitForXpath("//*[ contains (text(), 'You have chosen to pay by bank wire. Here is a short summary of your order:' ) ]");
	    driver.clickByXpath("//*[text()='I confirm my order']");
	}

	@Then("I check that my order was completed")
	public void i_check_that_my_order_was_completed() {
		
		driver.waitForClassName("cheque-indent");
		assertThat(driver.getElementValueByClass("cheque-indent").equals("Your order on My Store is complete."));	
	}
}
