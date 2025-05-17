package ecommerceframeworkbuilding.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerceframeworkbuilding.abstractclass.Abstractclass;

public class CheckOut extends Abstractclass {
	WebDriver driver;

	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".action__submit")
	WebElement submit;
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[1]")
	WebElement selectCountry;
	By result = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitElementToAppear(result);
		selectCountry.click();
	}
	
	public void submitOrder() {
		submit.click();
		
	}

}
