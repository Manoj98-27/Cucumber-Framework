package amazon.com.stepdefs;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {
	
	

	    WebDriver driver;
	    String base_url = "https://amazon.in";
	    String Productlist = "mobile";
	    int implicit_wait_timeout_in_sec = 20;

	    
	    @Before
	    public void setUp(){
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
	    }

	   
	    @After
	    public void cleanUp(){
	        driver.quit();
	    }

//	    //Do not need to use this method
//	    @Given("User opened browser")
//	    @Deprecated
//	    public void user_opened_browser() {
//	       
//	    }

	    @Given("User navigated to the home application url")
	    public void user_navigated_to_the_home_application_url() {
	        driver.get(base_url);
	        String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	        String actual =driver.getTitle();
	        Assert.assertEquals("Page Title validation",expected,actual);
	    }

	    @When("User Search for product {string}")
	    public void user_search_for_product(String productName) {
	       
	        WebDriverWait webDriverWait = new WebDriverWait(driver,20);
	        WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));

	        elementSearchBox.sendKeys(productName);
	        driver.findElement(By.xpath("//input[@value='Go']")).click();
	    }

	    @Then("Search Result page is displayed")
	    public void search_result_page_is_displayed() {
	       
	        WebDriverWait webDriverWait1 = new WebDriverWait(driver,20);
	        webDriverWait1.until(ExpectedConditions.titleIs("Amazon.in : Laptop"));

	       
	        Assert.assertEquals("Page Title validation","Amazon.in : Laptop", driver.getTitle());
	    }
	    
	    
	    //New TestCase  
	   
	    
	    @When("User Click On Any Product")
	    public void User_Click_On_Any_Product() {
	    	
	    	 WebElement clickonProduct = driver.findElement(By.xpath("//span[text()='OnePlus Nord 5G (Blue Marble, 12GB RAM, 256GB Storage)']"));
	    	 clickonProduct.click(); 
	    	 
	    	 Set<String> handles = driver.getWindowHandles();
	 		Iterator<String> it = handles.iterator();

	 		String parentWindowId = it.next();
	 		String childWindowID1 = it.next();
	 	
	 		System.out.println("Parent window id is - " + parentWindowId);
	 		
	 		driver.switchTo().window(childWindowID1);
	 		
	 		WebElement clickonAddtoCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
	    	 clickonAddtoCart.click(); 
	 		
	 		
	    }
	    
	    
	    @Then("Add to Cart Result Page is Displayed")
	    public void Add_to_Cart_Result_Page_is_Displayed() {
	    	
	    
	    	WebElement AddtoCart = driver.findElement(By.xpath("//div[@class='a-text-center a-fixed-left-grid-col a-col-left']//h4"));
	 		
	    	Assert.assertEquals("Page Text not Match","Added to Cart",AddtoCart.getText());	
	    	System.out.println("Page Text is Match");
	    	
	    	
	    }
	  
	    
	  
	    
	  
	    
	 

	}



