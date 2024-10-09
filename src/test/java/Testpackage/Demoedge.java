package Testpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Demoedge {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setup() throws InterruptedException {

			
	        driver = new EdgeDriver();
	        driver.get("https://sale.topflexvision.com/beta0a/");   
	        driver.manage().window().maximize();
	}
	
	@Test
	public void gettitle() throws InterruptedException {
		
		String title = driver.getTitle();
        System.out.println(title);
        
          JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,400);");
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
          List<WebElement> radioButtons = driver.findElements(By.xpath("//div[@id='Choose-your-package-section']//li//input"));
          
          if (radioButtons.size() == 3) {
              WebElement secondRadioButton = radioButtons.get(1); //index start with 0

//              JavascriptExecutor js1 = (JavascriptExecutor) driver;
              js.executeScript("arguments[0].scrollIntoView(true);", secondRadioButton);

//              WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
              wait.until(ExpectedConditions.elementToBeClickable(secondRadioButton));

              js.executeScript("arguments[0].click();", secondRadioButton);

              Thread.sleep(3000); 
          }        
        
        
        WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail']")) ;
        email.sendKeys("test5@codeclouds.com");
        WebElement firstname = driver.findElement(By.xpath("//div[@class='first-last-name first2']//input[@id='inputFirstName']"));
        firstname.sendKeys("Test");
        WebElement lastname = driver.findElement(By.xpath("//input[@id='inputLastName']"));
        lastname.sendKeys("Test");
        
//        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400);");
       
        WebElement address = driver.findElement(By.xpath("//input[@id='inputAddress']"));  
        address.sendKeys("test");
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.sendKeys(address, Keys.ARROW_DOWN).sendKeys(Keys.TAB).build().perform();
       // address.click();
       
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
        
              
        driver.findElement(By.xpath("//input[@id='sameShippingBilling']")).click();
        Thread.sleep(4000);
        
        driver.findElement(By.xpath("(//input[@id='inputFirstName'])[2]")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id='billingLastName']")).sendKeys("Test");
        
        js.executeScript("window.scrollBy(400,800);");
        WebElement billingaddress = driver.findElement(By.xpath("//input[@id='inputBillingAddress']"));  
        billingaddress.sendKeys("test");
        Thread.sleep(5000);
//        Actions actions = new Actions(driver);
        actions.sendKeys(billingaddress, Keys.ARROW_DOWN).sendKeys(Keys.TAB).build().perform();
        
        Thread.sleep(4000);           
       
        WebElement button = driver.findElement(By.xpath("//button[text()='COMPLETE YOUR SECURE PURCHASE']"));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
        
        Thread.sleep(5000);
               
        
        js.executeScript("window.scrollBy(0,600);");
        Thread.sleep(8000);
        WebElement upsellbtn = driver.findElement(By.xpath("//input[@value='COMPLETE CHECKOUT']"));
        wait.until(ExpectedConditions.elementToBeClickable(upsellbtn));
        upsellbtn.click();
        Thread.sleep(7000);
        
     
        js.executeScript("window.scrollBy(0,600);");
        Thread.sleep(3000);

        for(int i=1; i<3; i++) {
        	
        	driver.findElement(By.xpath("//button[text()='+']")).click();
        }
        WebElement discount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Yes! Add To My Order.']")));
        discount.click();
        
        Thread.sleep(5000);
        
        
        WebElement orderid = driver.findElement(By.xpath("(//div[@id='ship2'])[2]"));
        String orderidtxt = orderid.getText();
        System.out.println(orderidtxt);
        
        
        String productname = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
        String productprice = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
        System.out.println(productname+"  "+productprice);
        
        String upsellVIP = driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText();
        String upsellVIPprice = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
        System.out.println(upsellVIP+"  "+upsellVIPprice);
        
        String discountproduct = driver.findElement(By.xpath("//tbody/tr[3]/td[1]")).getText();
        String discountprice = driver.findElement(By.xpath("//tbody/tr[3]/td[2]")).getText();
        System.out.println(discountproduct+"  "+discountprice);
        
       String subtotal =  driver.findElement(By.xpath("//div[text()='Subtotal']")).getText();
       String subtotalprice = driver.findElement(By.xpath("//div[@id='totalText2a']//div[@class='pullRight']")).getText();
       System.out.println(subtotal+"  "+subtotalprice);
       
       String shipping =  driver.findElement(By.xpath("//div[text()='Shipping']")).getText();
       String shippingprice = driver.findElement(By.xpath("//div[@id='shippingPrice']")).getText();
       System.out.println(shipping+"  "+shippingprice);
       
       String total =  driver.findElement(By.xpath("//div[text()='Total']")).getText();
       String totalprice = driver.findElement(By.xpath("//div[@id='totalText2']//div[@class='pullRight']")).getText();
       System.out.println(total+"  "+totalprice);
       
       
       
       String currenturl = driver.getCurrentUrl();
       System.out.println(currenturl);
       if(currenturl.contains("thank-you")) {
       	
           System.out.println("TEST-CASE : PASSED");
       }else {
           System.out.println("TEST-CASE : FAILED");

       }       
       
       Thread.sleep(2000);
      
        
	}
	
	@AfterSuite        
	public void teardown() {
		
		    driver.close();
	}       
	        

}
