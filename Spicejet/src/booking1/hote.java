package booking1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class hote {
	public WebDriver driver;
	@BeforeTest
	public void start1()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	@Test
	public void hotel() throws InterruptedException
	{
		driver.findElement(By.partialLinkText("Hotels")).click();
		Thread.sleep(1000);
		WebElement fromdropdown = driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_txtOriginStation1_MST\']"));
		fromdropdown.click();
		fromdropdown.sendKeys("mumbai");
		Thread.sleep(1000);
		//fromdropdown.sendKeys(Keys.ARROW_DOWN);
		//fromdropdown.sendKeys(Keys.ENTER);
		driver.findElement(By.partialLinkText("Mumbai")).click();
	}
	
}
