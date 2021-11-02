package miscellaneous;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browserstack_selenium_interview_test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// To hit the First URL as Step1
		driver.get("https://www.flipkart.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement cross = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_2QfC02']/button")));
		cross.click();

		// Tell browser to explicitly wait for searchbox to be visible
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@title='Search for products, brands and more']")));

		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"))
				.sendKeys("Samsung Galaxy S10");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Again wait page to be loaded explicitly
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".W_R1IA")));

		// Clicking on Mobiles
		driver.findElement(By.xpath("//a[@title='Mobiles']")).click();

		// Again wait page to be loaded explicitly
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='SAMSUNG Galaxy S10 (Prism White, 512 GB)']")));

		// scrolling the driver
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

		// clicking on Brand Samsung
		driver.findElement(By.xpath("//div[text()='SAMSUNG']")).click();
		Thread.sleep(2000L);

		// scrolling the driver
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/section[3]/label[1]/div[1]")).click();
	    //sorting high to low
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//div[contains(text(),'Price -- High to Low')]")).click();
		Thread.sleep(2000L);
		
		//to print linktests in console
		System.out.println(driver.findElement(By.tagName("a")).getText());
		
		//To print the link counts and then storing them in List
		WebElement contextdriver = driver.findElement(By.cssSelector("._36fx1h._6t1WkM._3HqJxg"));
		System.out.println(contextdriver.findElements(By.tagName("a")).size());
		
	
			
		//Getting the Texts from all of the Links present
		
		//getting Product Name
		
		//List<WebElement>=driver.findElements(By.cssSelector("._1YokD2 _2GoDe3"));
		
		

		//getting link for text
		
		for (int i=0 ; i<contextdriver.findElements(By.tagName("a")).size(); i++)
		{
			
			System.out.println(contextdriver.getText().split(null));
			
		}
		//driver.quit();
		

	}

}
