package homePage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

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
	Random Rand =new Random();

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
	@Test(priority = 4)
	public void checkQitafLogo() {
		boolean theExcptedResultforLogo = true;
		WebElement thefooter = driver.findElement(By.tagName("footer"));
		// the first way
		// boolean actual =
		// thefooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed();

		// the second way
		WebElement theLogo = thefooter.findElement(By.cssSelector(".sc-fihHvN.eYrDjb"))
				.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF"));

		System.out.println(theLogo.isDisplayed());
		boolean actualResultForLogo = theLogo.isDisplayed();
		Assert.assertEquals(actualResultForLogo, theExcptedResultforLogo);

	}

	@Test(priority = 5)
	public void TestHotelTabIsNotSelected() {
		String excptedValue = "false";
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String actualValue = HotelTab.getAttribute("aria-selected");
		Assert.assertEquals(actualValue, excptedValue);
	}

	@Test(priority = 6)
	public void checkDepatuerDate() {
		LocalDate todayDate = LocalDate.now();
		// System.out.println(todayDate.getDayOfYear());
		int today = todayDate.getDayOfMonth();
		//we can't add in this method:	System.out.println(today+22);

		int tomorrow = todayDate.plusDays(1).getDayOfMonth();
		int theAfterTomorow = todayDate.plusDays(2).getDayOfMonth();

		List<WebElement> departureAndArravialDate = driver.findElements(By.className("LiroG"));

		String ActualDepatureDate = departureAndArravialDate.get(0).getText();
		String ActualArrivalDate = departureAndArravialDate.get(1).getText();

		System.out.println(ActualDepatureDate);
		//we need convert ActualDepatureDate to integer because diffrent type until to compare between ActualDepatureDate and tomorrow
		int ActualDepatureDateAsInt = Integer.parseInt(ActualDepatureDate);
		int ActualArrivalDateAsInt = Integer.parseInt(ActualArrivalDate);
         //tomorrow is excpted value
		Assert.assertEquals(ActualDepatureDateAsInt, tomorrow);
		Assert.assertEquals(ActualArrivalDateAsInt, tomorrow);
		}
      @Test(priority = 7)
      public void randomlyChangeTheLanguge() {
    	  String [] URLs = {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
    	  int  randomIndex = Rand.nextInt(URLs.length);
    	      driver.get(URLs[randomIndex]);
    	  
    	  
    	  
      }
}
