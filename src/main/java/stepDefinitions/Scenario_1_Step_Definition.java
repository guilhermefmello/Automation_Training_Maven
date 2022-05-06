package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Scenario_1_Step_Definition {

	 WebDriver driver;

	// User is on Saucedemo Demo Website UI
	@Given("^that the user is already on the saucedemo Login Page$")
	public void user_already_on_login_page() {

		//handling certificate errors (Untrusted Certificate)
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
				
				
		//Setting the Driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Automation_Software\\chromedriver_win32\\chromedriver.exe");
		
		//Open Browser with capability
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
	}

	// Verifying the title of Saucedemo Login Page
	@And("^the title of saucedemo Login page is SWAGLABS$")
	public void title_of_Saucedemo_Login_page() {

		String title = driver.getTitle();
		System.out.println("Title of Saucedemo Login Page is: " + title);
		Assert.assertEquals("Swag Labs", title);
	}

	// User enters the User name
	// Using \"(.*)\" REGEX (Regular Expression) to capture the string
	@When("^the user enters the User name \"(.*)\"$")
	public void users_enters_username(String username) {

		driver.findElement(By.id("user-name")).sendKeys(username);

	}

	// User enters the Password
	// Using \"(.*)\" REGEX (Regular Expression) to capture the string
	@And("^the user enters the Password \"(.*)\"$")
	public void users_enters_password(String password) {

		driver.findElement(By.id("password")).sendKeys(password);

	}

	// User clicks on Login button
	@And("^the user clicks on Login button$")
	public void users_clicks_on_login_button() {

		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);

	}

	// User is brought to Products page - verifying the page title
	@Then("^the user is brought to Products page$")
	public void user_on_products_page() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (driver.findElement(By.className("product_label")).getText().equalsIgnoreCase("Products")) {
			System.out.println("User has arrived at page: Products");
		}

		else {
			System.out.println("Error: This is not the Products page!");
		}

	}

	// Verifying that the user is logged in Saucedemo.com website - Products Page
	@And("^the user is logged in$")
	public void user_is_logged_in() {

		//verifying the url (actual x expected) after user has logged in 
		String actualurl="https://www.saucedemo.com/inventory.html";
	    String expectedurl= driver.getCurrentUrl();
	    Assert.assertEquals(expectedurl,actualurl);
	    System.out.println("The user is logged in: " + actualurl);


	}
}
