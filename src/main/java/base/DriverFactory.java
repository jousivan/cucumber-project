package base;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	protected static WebDriver driver;
	private static String browser = null;
	
	
	public static WebDriver getDriver() {
		browser = System.getProperty("browser");
		
		if (driver == null) {
			
				if(StringUtils.isEmpty(browser) || browser.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} 
				else if (browser.equalsIgnoreCase("Firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				
				else if (browser.equalsIgnoreCase("EDGE")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}
				
				else if (browser.equalsIgnoreCase("Opera")) {
					WebDriverManager.operadriver().setup();
					driver = new OperaDriver();
				}

				else {
					System.out.println("Browser: " + browser + "is not available. Inform a valid browser: chrome, firefox or edge");
					System.exit(1);
				}
			}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	 }
    
    public static void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
