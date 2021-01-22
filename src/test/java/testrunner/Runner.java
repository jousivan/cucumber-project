package testrunner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import base.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = "classpath:features", //run all futures
		//features = "classpath:features/BuyProduct.feature",  //run specific feature
		glue = "steps",
		plugin = { "pretty", "html:target/cucumber-reports" },
		monochrome = true,
		snippets = SnippetType.CAMELCASE)
public class Runner extends AbstractTestNGCucumberTests {
		
	 @BeforeClass(alwaysRun = true)
	    public void beforeClass() throws Exception {
		 
		 //Execute anything before the tests start
	    }
	 
	 @AfterSuite(alwaysRun = true)
	    public void afterClass() {
	        /** Kill driver after all tests run **/
		 DriverFactory.quitDriver();
	    }

}