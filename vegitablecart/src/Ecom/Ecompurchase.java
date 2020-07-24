package Ecom;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ecompurchase {
	public WebDriver driver;
	
	
	@BeforeTest
	public void start()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://myveggiekart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	@Test(priority =1)
	public void register()
	{
		driver.findElement(By.id("customer_register_link")).click();
		driver.findElement(By.id("first_name")).sendKeys("Jithin");
		driver.findElement(By.id("last_name")).sendKeys("T");
		driver.findElement(By.id("email")).sendKeys("jithin@mailinator.com");
		driver.findElement(By.id("create_password")).sendKeys("12345678");
		driver.findElement(By.xpath("//*[@id=\'create_customer\']/p[2]/input")).click();
		String a= driver.findElement(By.xpath("//*[@id=\'create_customer\']/div")).getText();
		System.out.println(a);
		String expect ="This email address is already associated with an account. If this account is yours, you can reset your password";
		Assert.assertEquals(a, expect);
	}
		@Test(priority =2)
		public void login()
		{
		driver.findElement(By.id("customer_login_link")).click();
		driver.findElement(By.id("customer_email")).sendKeys("jithin@mailinator.com");
		driver.findElement(By.id("customer_password")).sendKeys("12345678");
		driver.findElement(By.xpath("//*[@id=\'customer_login\']/p[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	@Test(priority =3)
	public void shopping() throws InterruptedException 
	{
		driver.findElement(By.partialLinkText("Category")).click();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\'accessibleNav\']/li[1]/ul/li[1]/a")).click();
		List<WebElement>products =driver.findElements(By.cssSelector("p"));
		String[] itemsNeeded= {"Chausa Mango","Dasheri Mango"};
			int j=0;

			for(int i=0;i<products.size();i++)
			{
				String name =products.get(i).getText();
				List itemsNeededList = Arrays.asList(itemsNeeded);
				
				if(itemsNeededList.contains(name))
				{
					j++;
					driver.findElements(By.xpath("//div[@class='addtc-button addtc-noselect']")).get(i-1).click();
					driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
					if(j==itemsNeeded.length)

					{

					break;

					}
				}	
				
			}
	}
	@AfterTest
	public void cart()
	{
		driver.findElement(By.xpath("//a[@class='header-cart-btn cart-toggle']")).click();
		driver.findElement(By.xpath("//input[@id='checkPin']")).sendKeys("751007");
		driver.findElement(By.xpath("//button[@id='ckeck_pin']")).click();
		driver.findElement(By.xpath("//button[@id='cart_checkout']")).click();
	}
	
	
}

