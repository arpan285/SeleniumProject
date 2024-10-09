package Testpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import Project1.Project1.Formfillup;

public class Demo2024 {
	
	WebDriver driver;
	
	@BeforeSuite
	public void setup() throws InterruptedException {

			
	        driver = new ChromeDriver();
	        driver.get("https://sale.topflexvision.com/beta0a/");   
	        driver.manage().window().maximize();
	}
	
	@Test()
	public void gettitle() throws InterruptedException {
		
		String title = driver.getTitle();
        System.out.println(title);
        
          JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,400);");
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        List<WebElement> radioButtons = driver.findElements(By.xpath("//div[@id='Choose-your-package-section']//li//input"));
        
        if (radioButtons.size() == 3) {
            WebElement secondRadioButton = radioButtons.get(1); //index start with 0

//            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", secondRadioButton);

//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(secondRadioButton));

            js.executeScript("arguments[0].click();", secondRadioButton);

            Thread.sleep(3000); 
        }      
                    
        Formfillup form = new Formfillup(driver);     
        form.getform("test5@codeclouds.com"); 
        
        Thread.sleep(6000);  
          
        js.executeScript("window.scrollBy(0,600);");
        Thread.sleep(5000);
        WebElement upsellbtn = driver.findElement(By.xpath("//input[@value='COMPLETE CHECKOUT']"));
        wait.until(ExpectedConditions.elementToBeClickable(upsellbtn));
        upsellbtn.click();   
        Thread.sleep(5000);
             
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
		
			//driver.close();
		    driver.quit();
	}       
	        

}
