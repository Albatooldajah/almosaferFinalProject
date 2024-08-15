package homePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {
	WebDriver driver = new ChromeDriver();
	String AlMosaferURL = "https://global.almosafer.com/en";
	String theExpectedDefualtLanguge = "en";

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(AlMosaferURL);
		driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")).click();
	}

	@Test(priority = 1)
	public void checkTheDefualtLangugeIsEnglish() {

		// System.out.println(driver.findElement(By.tagName("html")).getAttribute("lang"));

		String actualLanguge = driver.findElement(By.tagName("html")).getAttribute("lang");
		Assert.assertEquals(actualLanguge, theExpectedDefualtLanguge);

	}

	@Test(priority = 2)
	public void checkTheCurrencyIsSAR() {
		String excptedCurrency = "SAR";
		WebElement Currency = driver.findElement(By.xpath("//button [@data-testid='Header__CurrencySelector']"));
		String actualCurrency = Currency.getText();
		Assert.assertEquals(actualCurrency, excptedCurrency);

	}

	@Test(priority = 3)
	public void checkContactNumber() {
		String excptedContact = "+966554400000";
		String actualConactNumber = driver.findElement(By.tagName("strong")).getText();
		Assert.assertEquals(actualConactNumber, excptedContact);
	}

	// svg[@data-testid='Footer__QitafLogo']
	@Test(priority = 3)
	public void checkQitafLogo() {
		boolean theExcptedResultforLogo = true;
		WebElement thefooter = driver.findElement(By.tagName("footer"));
		//the first way 
		//boolean actual = thefooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed();
	   
		//the second way
		WebElement theLogo = thefooter.findElement(By.cssSelector(".sc-fihHvN.eYrDjb")).findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF"));
		
		System.out.println(theLogo.isDisplayed());
		boolean actualResultForLogo = theLogo.isDisplayed();
		Assert.assertEquals(actualResultForLogo, theExcptedResultforLogo);
		
	
	}
}
