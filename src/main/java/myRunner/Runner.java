package myRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Destino Dublin\\eclipse-workspace\\Automation_Training_Web_UI_1\\src\\main\\java\\features\\login.feature" //the path of feature files
		,glue= {"stepDefinitions"}, //the path of step definitions files
		plugin = {
				"html:target/cucumber-reports", "pretty",
				"json:target/cucumber-reports/CucumberTestReport.json" }, //to generate different types of reports
		monochrome = true, //displays the console output in a proper readable format
		//strict = true, //it will check if any step is not defined in step definition file
		dryRun = false //will check if the steps in the feature file matches the steps in the step definition file
		) 


public class Runner {

}
