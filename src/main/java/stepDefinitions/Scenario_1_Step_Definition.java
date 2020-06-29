package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class Scenario1StepDefinition {

	
	WebDriver driver;
	
	//User is on Saucedemo Demo Website UI
	@Given("^that the user is already on the saucedemo Login Page$")
	public void user_already_on_login_page() {
	
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver_win.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");		
	}
	
	//Verifying the title of Saucedemo Login Page
	@And("^the title of saucedemo Login page is SWAGLABS$")
	public void title_of_Saucedemo_Login_page(){
		
		String title = driver.getTitle();
		System.out.println("Title of Saucedemo Login Page is: " + title);
		Assert.assertEquals("Swag Labs", title);
	}
	
	//User enters the User name
	//Using \"(.*)\" REGEX (Regular Expression) to capture the string 
	@When ("^the user enters the User name \"(.*)\"$")
	public void users_enters_username(String username) {
		
		driver.findElement(By.
		//name("j_username")).sendKeys(username);
	}
	
	//User enters the Password
	//Using \"(.*)\" REGEX (Regular Expression) to capture the string 
	@And ("^the user enters the Password \"(.*)\"$")
	public void users_enters_password(String password) {
		
		driver.findElement(By.name("j_password")).sendKeys(password);
	}
	
	//User clicks on Login button
	@And ("^the user clicks on Login button$")
	public void users_clicks_on_login_button() {
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}
	
	//User is brought to BPM My Work page - verifying the page title
	@Then("^the user is brought to My Work page$")
	public void user_on_my_work_page(){
		
		String myWork = driver.getTitle();
		System.out.println("BPM My Work page is: " + myWork);
		Assert.assertEquals("Process Portal - Work", myWork);
		
	}
	
	
	
	// Verifying that the user is logged in BPM Work page
	@And("^the user is logged in$")
	public void user_is_logged_in() {

//			String loggedIn = driver.findElement(By.id("processPortalUserDropdownId")).getText();
//			System.out.println("The following user is logged in: " + loggedIn);

		boolean user_on_my_work_page = true;

		if (user_on_my_work_page) {

			String loggedIn = driver.findElement(By.id("processPortalUserDropdownId")).getText();
			System.out.println("The following user is logged in: " + loggedIn);

		} else {
			System.out.println("Error: User is not logged in");
		}
	}
	
	//Clicking on Start UK Credit Workflow link
	@Then("^the user clicks on Start UK Credit Workflow$")
	public void the_user_clicks_on_Start_UK_Credit_Workflow() {

		Actions action = new Actions(driver);
		action.moveToElement(driver
				.findElement(By.xpath("//*[@id=\"com_ibm_bpm_social_widgets_LaunchableProcessList_0\"]/ul/li[8]")))
				.build().perform();
		driver.findElement(By.xpath("//*[@id=\"com_ibm_bpm_social_widgets_LaunchableProcessList_0\"]/ul/li[8]"))
				.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	// selecting option from "Region Radio Button" according to the options in the
	// Feature files Examples
	@Then("^the user chooses a region \"([^\"]*)\"$")
	public void the_user_chooses_a_region(String NI_GB) {

		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//
//		//Find frame or iframe and switch
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Pane16"));
//		
//		//Now find the element 
//		WebElement Category_Body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("radio-input-Radio_Button5")));
//		 Category_Body.click();
//
//		//Once all your stuff done with this frame need to switch back to default
//		driver.switchTo().defaultContent();
		
		
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		WebElement NI_RadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='panel-body']//input[@name='RegionName' and @id='radio-input-Radio_Button5']")));
//		NI_RadioButton.click();
		
		
		
		
//		WebElement radioNI = driver.findElement(By.xpath("//input[@name='RegionName' and @id='radio-input-Radio_Button5']")); // finding the Region NI radio button element
//		radioNI.click(); // Region NI radio button is selected
//		System.out.println("The NI Region has been chosen from the Radio buttons");
		
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement ele = driver.findElement(By.xpath("//iframe[@dojoattachpoint='frame']"));
		
		
		driver.switchTo().frame(ele);
		
		WebElement el1e = driver.findElement(By.xpath("//iframe[contains(@id,'coach_frame')]"));
		
		
		driver.switchTo().frame(el1e);
		
		
		
		if (NI_GB == "NI") {
			WebElement radioNI = driver.findElement(By.xpath("//input[@name='RegionName' and @id='radio-input-Radio_Button5']")); // finding the Region NI radio
																							// button element
			radioNI.click(); // Region NI radio button is selected
			System.out.println("The NI Region has been chosen from the Radio buttons");
			
		} else {
			WebElement radioGB = driver.findElement(By.xpath("//input[@name='RegionName' and @id='radio-input-Radio_Button6']")); // finding the Region GB radio
																							// button element
			radioGB.click(); // Region GB radio button is selected
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Inserting a customer name, from the feature files Examples, into its field
	@Then("^the user enters the Customer Name \"([^\"]*)\"$")
	public void the_user_enters_the_Customer_Name(String customer_name) {

		driver.findElement(By.name("text-input-Text24")).sendKeys(customer_name);

	}

	///clicking on Search Customer Button
	@Then("^the user clicks on Search Customer button$")
	public void the_user_clicks_on_Search_Customer_button() {

		WebElement searchCustomerBtn = driver.findElement(By.xpath("//*[@id=\"button-button-Button2\"]/span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", searchCustomerBtn);

	}

	//selecting NSC Account Number value from the dropdown
	@Then("^the user selects a NSC Account Number \"([^\"]*)\"$")
	public void the_user_selects_a_NSC_Account_Number(String NSC_Account_Number) {
		
		Select dropDownNSCAccountNumber = new Select(driver.findElement(By.id("singleselect-CustomerDetailsCV1:nscAccountCombo")));
		dropDownNSCAccountNumber.selectByValue(NSC_Account_Number);
	}

	//Clicking on Submit Start UKCWF
	@Then("^the user clicks on Submit_Start_UKCWF button$")
	public void the_user_clicks_on_Submit_Start_UKCWF_button() {
		
		WebElement submitStartUKCWFBtn = driver.findElement(By.xpath("//*[@id=\"button-button-okbutton\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submitStartUKCWFBtn);

	}

}
