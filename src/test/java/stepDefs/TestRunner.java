package stepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, plugin = {
		"pretty" }, features = "src/test/java/features", glue = "stepdefs", tags = { "@Regression" })
public class TestRunner {

}
