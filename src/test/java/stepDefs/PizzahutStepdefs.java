package stepDefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PizzahutStepdefs {

	WebDriver driver = BaseClass.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.pizzahut.co.in/");

	}

	@When("I enter the location as {string}")
	public void i_enter_the_location_as(String location) {
		// Write code here that turns the phrase above into concrete actions
		WebElement Location = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		Location.sendKeys(location);
	}

	@When("I select the very first suggestion from the list")
	public void i_select_the_very_first_suggestion_from_the_list() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		WebElement Place = driver.findElement(By.xpath("//*[contains(text(),'Pune Railway Station')]"));
		Place.click();
		Thread.sleep(3000);
	}

	@Then("I should land on the Deals page")
	public void i_should_land_on_the_Deals_page() {
		// Write code here that turns the phrase above into concrete actions
		WebElement Deals = driver.findElement(By.xpath("//a[@data-synth='link--deals--side']//span[text()='Deals']"));
		Assert.assertTrue(Deals.isDisplayed());
		// Thread.sleep(5000);
	}

	@Then("I select the tab as {string}")
	public void i_select_the_tab_as(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		WebElement Pizzas = driver
				.findElement(By.xpath(" //a[@data-synth='link--pizzas--side']//span[text()='Pizzas']"));
		Pizzas.click();
		Thread.sleep(3000);

	}

	@Then("I select the pizza as {string}")
	public void i_select_the_pizza_as(String pizza) {
		// Write code here that turns the phrase above into concrete actions
		WebElement Pizzaitem = driver.findElement(By.xpath("//div[text()='" + pizza + "']"));
		Pizzaitem.isDisplayed();
		// click to add the same pizza
		WebElement MyPizza = driver
				.findElement(By.xpath("//div[text()='" + pizza + "']//following::span[text()='Add'][1]"));
		MyPizza.click();

	}

	@Then("I should see the pizza is added to the cart")
	public void i_should_see_the_pizza_is_added_to_the_cart() {
		// Write code here that turns the phrase above into concrete actions
		WebElement BasketItem = driver.findElement(By.xpath(
				"//div[@data-testid='basket-item-product']//div[contains(text(),'Personal Schezwan Margherita')]"));
		Assert.assertTrue(BasketItem.isDisplayed());

	}

	@Then("I click on the Checkout button")
	public void i_click_on_the_Checkout_button() {
		// Write code here that turns the phrase above into concrete actions
		WebElement Checkout = driver.findElement(By.xpath("//div[@class=\"basket-checkout\"]//a"));
		Checkout.click();

	}

	@Then("I should be landed on the secured checkout page")
	public void i_should_be_landed_on_the_secured_checkout_page() {
		// Write code here that turns the phrase above into concrete actions
		WebElement CheckoutForm = driver.findElement(By.xpath("//form[@id=\"checkout-form\"]"));
		Assert.assertTrue(CheckoutForm.isDisplayed());

	}

	@Then("I enter the personal details")
	public void i_enter_the_personal_details(DataTable persDetails) {
		for (int i = 0; i < persDetails.height(); i++) {
			WebElement PersDetail2 = driver.findElement(By.name(persDetails.cell(i, 0)));
			PersDetail2.sendKeys(persDetails.cell(i, 1));

		}
	}

	@Then("I enter the address details")
	public void i_enter_the_address_details(List<String> address) {
		// Write code here that turns the phrase above into concrete actions
		WebElement Address1 = driver.findElement(By.id("checkout__deliveryAddress.interior"));
		Address1.sendKeys(address.get(0));
		WebElement Landmark = driver.findElement(By.id("checkout__deliveryAddress.notes"));
		Landmark.sendKeys(address.get(1));

	}

	@Then("I should see three payment options")
	public void i_should_see_three_payment_options(List<String> Options) {
		// Write code here that turns the phrase above into concrete actions

		for (String options : Options) {
			WebElement Optfor = driver.findElement(
					By.xpath("//span[@class=\"mr-auto flex items-center\"]//span[contains(text(),'" + options + "')]"));
			Assert.assertTrue(Optfor.isDisplayed());
		}
	}

	@Then("I select the payment option as {string}")
	public void i_select_the_payment_option_as(String paymentCash) {
		// Write code here that turns the phrase above into concrete actions
		WebElement SelectCash = driver
				.findElement(By.xpath("//label[@data-synth=\"payment-method--cash-label\"]//span[text()=\"Cash\"]"));
		SelectCash.click();
	}

}
