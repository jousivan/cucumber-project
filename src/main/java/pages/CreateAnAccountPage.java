package pages;

import java.util.Locale;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class CreateAnAccountPage extends LoginPage {
	Faker faker = new Faker(new Locale("en-US"));
	
	public CreateAnAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public void personalInformation() {
		
		waitForId("customer_firstname");
		clickRadio("id_gender1");
		sendKeysById("customer_firstname", faker.name().firstName());
		sendKeysById("customer_lastname",faker.name().lastName());
		sendKeysById("email",  getEmail());
		sendKeysById("passwd", "123456");
		selectOptionByValue("days", "14");
		selectOptionByValue("months", "11");
		selectOptionByValue("years", "1987");
		clickCheckbox("newsletter");
		clickCheckbox("optin");
		sendKeysById("firstname",  faker.name().firstName());
		sendKeysById("lastname",  faker.name().lastName());
		sendKeysById("company", faker.company().name());
		sendKeysById("address1", faker.address().fullAddress());
		sendKeysById("address2", faker.address().secondaryAddress());
		sendKeysById("city", faker.address().city());
		selectOption("id_state", "Alabama");
		sendKeysById("postcode", "55588");
		selectOption("id_country", "United States");
		sendKeysById("other", faker.lorem().paragraph());
		sendKeysById("phone", faker.phoneNumber().cellPhone());
		sendKeysById("phone_mobile", faker.phoneNumber().cellPhone());
		sendKeysById("alias", faker.address().streetName());
		clickButton("submitAccount");
	}
}
