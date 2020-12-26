package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewtoursSteps {

	WebDriver driver= null;
	
	@BeforeStep
	public void Be_Patient_Browser_will_open()
	{
		System.out.println("Browser is opening baba");
	}

	@Given("User is on browser and is on Register page")
	public void user_is_on_browser_and_is_on_Register_page() throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Param\\Desktop\\chromedriver_win32 (4)atest\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(100);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile , new File("C:\\Users\\Param\\Desktop\\Screenshots\\screenshot1.png"));
	}

	@When("^User enters (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*) , (.*)$")
	public void user_enters_FirstName_LastName_Phone_UserName_Address1_City_State_Postalcode(String FirstName,String LastName,String Phone,String UserName,String Address1,String City ,String State ,String Postalcode ) throws IOException {

		driver.findElement(By.name("firstName")).sendKeys(FirstName);
		driver.findElement(By.name("lastName")).sendKeys(LastName);
		driver.findElement(By.name("phone")).sendKeys(Phone);
		driver.findElement(By.id("userName")).sendKeys(UserName);
		driver.findElement(By.name("address1")).sendKeys(Address1);
		driver.findElement(By.name("city")).sendKeys(City);
		driver.findElement(By.name("state")).sendKeys(State);
		driver.findElement(By.name("postalCode")).sendKeys(Postalcode);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile , new File("C:\\Users\\Param\\Desktop\\Screenshots\\screenshot2.png"));

	}

	@And("Selects Country")
	public void selects_Country() throws IOException {

		new Select(driver.findElement(By.name("country"))).selectByVisibleText("INDIA"); 
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile , new File("C:\\Users\\Param\\Desktop\\Screenshots\\screenshot3.png"));

	}

	@And("Enters Email , Password , ConfirmPassword")
	public void enters_Email_Password_ConfirmPassword() throws IOException {

		driver.findElement(By.id("email")).sendKeys("Param1");
		driver.findElement(By.name("password")).sendKeys("Param@567");
		driver.findElement(By.name("confirmPassword")).sendKeys("Param@567");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile , new File("C:\\Users\\Param\\Desktop\\Screenshots\\screenshot4.png"));

	}

	@And("Clicks on Submit")
	public void clicks_on_Submit() throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.name("submit")).click();


	}

	@Then("USer is created succesfully")
	public void user_is_created_succesfully() throws InterruptedException {

		Thread.sleep(900);
		//driver.close();

	}
	@AfterStep
	public void Take_Screenshot() throws IOException
	{
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile , new File("C:\\Users\\Param\\Desktop\\Screenshots\\screenshot5.png"));
	}


}
