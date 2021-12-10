//package parking.cost.calculator;

import java.util.regex.Pattern;
import java.awt.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase {
  private static WebDriver driver;
  private static String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  public static void main(String [] args) {
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Yigit Cevik\\OneDrive\\Masaüstü\\CS\\Selenium\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    baseUrl = "https://www.shino.de/";
	    
	    driver.get(baseUrl + "/parkcalc/");
	     
	    
	      //Select Valet Parking
	    Select select = new Select(driver.findElement(By.name("ParkingLot")));
	    select.selectByVisibleText("Valet Parking");
	     
	      //Enter 01/01/2021
	    driver.findElement(By.id("StartingDate")).clear();
	    driver.findElement(By.id("StartingDate")).sendKeys("01/01/2021");
	   
	      //Enter 11:00
	    driver.findElement(By.id("StartingTime")).clear();
	    driver.findElement(By.id("StartingTime")).sendKeys("11:00");
	    
	      //Enter 01/02/2021
	    driver.findElement(By.id("LeavingDate")).clear();
	    driver.findElement(By.id("LeavingDate")).sendKeys("01/02/2021");
	      
	      //Enter 11:00
	    driver.findElement(By.id("LeavingTime")).clear();
	    driver.findElement(By.id("LeavingTime")).sendKeys("11:00");
	      
	      //Click Submit
	    driver.findElement(By.name("Submit")).click();
	    
	    //Test will be end successfully in this case
	    String actualCost = driver.findElement(By.cssSelector("b")).getText();
	    String expectedCost = "$ 18.00";
	    
	    String actualTime = driver.findElement(By.cssSelector("span.BodyCopy > b")).getText();
	    String expectedTime = "        (1 Days, 0 Hours, 0 Minutes)";
	    
	    Assert.assertEquals(expectedCost, actualCost);
	    Assert.assertEquals(expectedTime, actualTime);
	    driver.close();

  } 

}