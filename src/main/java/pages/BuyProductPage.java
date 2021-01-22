package pages;

import org.openqa.selenium.WebDriver;

public class BuyProductPage extends LoginPage {
	public BuyProductPage(WebDriver driver) {
		super(driver);
	}
	
	public void addToCart() {
		waitForClassName("availability");
        clickByClass("availability");
		waitForLink("Add to cart");
        clickLink("Add to cart");
	}
	
	public void proceedToCheckout() {
		
		waitForLink("Proceed to checkout");
	    clickLink("Proceed to checkout");
	    waitForXpath("//*[text()=' Summary']");
	    clickLink("Proceed to checkout");
	    waitForXpath("//*[text()=' Address']");
	    clickButtonByName("processAddress");
	    waitForXpath("//*[text()=' Shipping']");
	    clickCheckbox("cgv");
	    clickButtonByName("processCarrier"); 
	}
}
