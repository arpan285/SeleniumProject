package Project1.Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Formfillup {
	WebDriver driver;
	
	
	@FindBy(xpath ="//input[@id='inputEmail']")
	WebElement emailid;
	
	
	public Formfillup(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void getform(String email) throws InterruptedException {
		   Thread.sleep(5000);      
//	        WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail']")) ;
	        emailid.sendKeys(email);
	        WebElement firstname = driver.findElement(By.xpath("//div[@class='first-last-name first2']//input[@id='inputFirstName']"));
	        firstname.sendKeys("Test");
	        WebElement lastname = driver.findElement(By.xpath("//input[@id='inputLastName']"));
	        lastname.sendKeys("Test");
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        js.executeScript("window.scrollBy(0,400);");
	       
	        WebElement address = driver.findElement(By.xpath("//input[@id='inputAddress']"));  
	        address.sendKeys("test");
	        Thread.sleep(5000);
	        Actions actions = new Actions(driver);
	        actions.sendKeys(address, Keys.ARROW_DOWN).sendKeys(Keys.TAB).build().perform();
	       
	        Thread.sleep(4000);
	        
	        WebElement phno = driver.findElement(By.xpath("//input[@id='inputPhone']"));
	        phno.sendKeys("3489459023");
	  
	        WebElement ccno = driver.findElement(By.xpath("//input[@id='ccNumber']"));
	        ccno.sendKeys("1444444444444440");
	        
	        WebElement ddmonth = driver.findElement(By.xpath("//select[@name='expmonth']"));
	        Select selectmonth = new Select(ddmonth);
	        selectmonth.selectByValue("02");
	        
	        WebElement ddyear = driver.findElement(By.xpath("//select[@name='expyear']"));
	        Select selectyear= new Select(ddyear);
	        selectyear.selectByValue("27");
	        
	        WebElement cvv = driver.findElement(By.xpath("//input[@id='cvv']"));
	        cvv.sendKeys("123");
	        
	        Thread.sleep(6000);      
	        driver.findElement(By.xpath("//input[@id='sameShippingBilling']")).click();
	        Thread.sleep(5000);      
	        
	        driver.findElement(By.xpath("(//input[@id='inputFirstName'])[2]")).sendKeys("Test");
	        driver.findElement(By.xpath("//input[@id='billingLastName']")).sendKeys("Test");
	        
	        js.executeScript("window.scrollBy(400,800);");
	        WebElement billingaddress = driver.findElement(By.xpath("//input[@id='inputBillingAddress']"));  
	        billingaddress.sendKeys("test");
	        Thread.sleep(5000);
	        //Actions actions = new Actions(driver);
	        actions.sendKeys(billingaddress, Keys.ARROW_DOWN).sendKeys(Keys.TAB).build().perform();
	        
	        Thread.sleep(6000);           
	        js.executeScript("window.scrollBy(800,1500);");
	        Thread.sleep(6000);  
	        WebElement button = driver.findElement(By.xpath("//button[text()='COMPLETE YOUR SECURE PURCHASE']"));
	        wait.until(ExpectedConditions.elementToBeClickable(button));
	        button.click(); 
	        Thread.sleep(6000);
	                 
	}

}
