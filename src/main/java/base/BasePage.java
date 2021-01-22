package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String email;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void getWait(String path) {
		 wait = new WebDriverWait(driver, 20);
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
	}
	
	public void waitFor(long seconds) {
		 try {
				TimeUnit.SECONDS.sleep(seconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public void waitForClassName(String className) {
		 wait = new WebDriverWait(driver, 20);
	     wait.until(ExpectedConditions.elementToBeClickable(By.className(className)));
	}
	
	public void waitForLink(String link) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(link)));
	}
	
	public void waitForPartialLink(String link) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(link)));
	}
	
	public void waitForId(String id) {
		 wait = new WebDriverWait(driver, 20);
	     wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
	}
	
	public void waitForTitle(String title) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public void waitForXpath(String xpath) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public void quitDriver() {
		driver.quit();
	}
	
	
	public void navegateTo(String url) {
		driver.get(url);
	}
	
	private void sendKeys(By by, String text) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(text);
	}

	public void sendKeysByName(String name, String text) {
		sendKeys(By.name(name), text);
	}

	public void sendKeysById(String id, String texto) {
		sendKeys(By.id(id), texto);
	}
	
	public void submit(String id) {
		driver.findElement(By.id(id)).submit();
	}
	
	public void submitByName(String name) {
		driver.findElement(By.id(name)).submit();
	}
	
	public void selectOption(String id, String opcao) {

		WebElement DropDown = driver.findElement(By.id(id));  
		Select dropdown = new Select(DropDown); 
		dropdown.selectByVisibleText(opcao);
	}
	
	public void selectOptionByValue(String value, String opcao) {
		WebElement DropDown = driver.findElement(By.id(value));  
		Select dropdown = new Select(DropDown); 
		dropdown.selectByValue(opcao);
	}
	
	public void clickLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
	public void clickByPartialLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
	public void clickByClass(String classname) {
		driver.findElement(By.className(classname)).click();
	}
	
	public void clickByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	
	public void clickRadio(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clickCheckbox(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void clickButton(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clickButtonByName(String name) {
		driver.findElement(By.name(name)).click();
	}
	
	public String getElementValueByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public String getElementValueByClass(String className) {
		return driver.findElement(By.className(className)).getText();
	}
	
	public String getElementValueByLink(String link) {
		return driver.findElement(By.linkText(link)).getText();
	}
	
	public WebElement getElementByLink(String link) {
		return driver.findElement(By.linkText(link));
	}
	public WebElement getElementByClass(String className) {
		return driver.findElement(By.className(className));
	}
	public WebElement getElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
