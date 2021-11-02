package miscellaneous;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browserstack_selenium_interview_cloud {
	  public static final String AUTOMATE_USERNAME = "suyogsalunkhe_42LmAI";
	  public static final String AUTOMATE_ACCESS_KEY = "LTJytboFgzqZSX9u3kHY";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  public static void main(String[] args) throws Exception {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1920x1080");
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "latest");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("name", "BStack-[Java] Sample Test1"); // test name
	    caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
	    //WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		
	    
	    WebDriver driver1 = new RemoteWebDriver(new URL(URL), caps);
		driver1.manage().window().maximize();
		driver1.manage().deleteAllCookies();

		// To hit the First URL as Step1
		driver1.get("https://www.flipkart.com/");

		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
		WebElement cross = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_2QfC02']/button")));
		cross.click();

		// Tell browser to explicitly wait for searchbox to be visible
		WebDriverWait w = new WebDriverWait(driver1, Duration.ofSeconds(5));
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@title='Search for products, brands and more']")));

		driver1.findElement(By.xpath("//input[@title='Search for products, brands and more']"))
				.sendKeys("Samsung Galaxy S10");
		driver1.findElement(By.xpath("//button[@type='submit']")).click();

		// Again wait page to be loaded explicitly
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".W_R1IA")));

		// Clicking on Mobiles
		driver1.findElement(By.xpath("//a[@title='Mobiles']")).click();

		// Again wait page to be loaded explicitly
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='SAMSUNG Galaxy S10 (Prism White, 512 GB)']")));

		// scrolling the driver
		JavascriptExecutor js = (JavascriptExecutor) driver1;
		js.executeScript("window.scrollBy(0,600)");

		// clicking on Brand Samsung
		driver1.findElement(By.xpath("//div[text()='SAMSUNG']")).click();
		Thread.sleep(2000L);

		// scrolling the driver
		JavascriptExecutor jss = (JavascriptExecutor) driver1;
		jss.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000L);
		driver1.findElement(By.xpath("//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/section[3]/label[1]/div[1]")).click();
	    //sorting high to low
		Thread.sleep(2000L);
		
		driver1.findElement(By.xpath("//div[contains(text(),'Price -- High to Low')]")).click();
		Thread.sleep(2000L);
		
		//to print linktests in console
		System.out.println(driver1.findElement(By.tagName("a")).getText());
		
		//To print the link counts and then storing them in List
		WebElement contextdriver = driver1.findElement(By.cssSelector("._36fx1h._6t1WkM._3HqJxg"));
		System.out.println(contextdriver.findElements(By.tagName("a")).size());

		
		//Getting the Texts from all of the Links present
		for (int i=0 ; i<contextdriver.findElements(By.tagName("a")).size(); i++)
		{
			
			System.out.println(contextdriver.getText().split(null));
			
		}
		// driver.close();
		

	}

}
