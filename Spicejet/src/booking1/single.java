package booking1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class single {
	public WebDriver driver;
	
	@BeforeTest
	public void start()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	@Test
	public void flightbooking()
	{
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
	    driver.findElement(By.xpath("//*[@id=\'dropdownGroup1\']/div/ul[1]/li[1]/a")).click();
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id=\'ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value = 'JLR']")).click();
	    driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div[1]/table/tbody/tr[5]/td[5]/a")).click();
	    driver.findElement(By.id("divpaxinfo")).click();
	    Select c =new Select (driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
	    c.selectByValue("7");
	    Select s = new Select (driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_DropDownListCurrency\"]")));
		s.selectByValue("AED");
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
	@Test
	public void hotelbooking() throws InterruptedException
	{
		driver.findElement(By.id("highlight-book")).click();
		driver.findElement(By.partialLinkText("Hotels")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='MySpiceTripSearchView_TextBoxMarketOrigin1\']")).click();
		driver.findElement(By.xpath("//*[@id=\'MySpiceTripSearchView_TextBoxMarketOrigin1\']")).sendKeys("mumbai");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Mumbai")).click();
		driver.findElement(By.xpath("//*[@id=\'custom_mySpiceTripdate_picker_id_1\']")).click();
		driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div[1]/table/tbody/tr[4]/td[5]/a")).click();
		driver.findElement(By.xpath("//*[@id=\'custom_mySpiceTripdate_picker_id_2\']")).click();
		driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div[1]/table/tbody/tr[5]/td[5]/a")).click();
		Select a = new Select(driver.findElement(By.xpath("//*[@id=\'MySpiceTripSearchView_DropDownListPassengerType_ADT\']")));
		a.selectByValue("2");
		driver.findElement(By.xpath("//*[@id=\'MySpiceTripSearchView_ButtonSubmit\']")).click();
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	   // driver.close();
	    //driver.switchTo().window(tabs2.get(0));
	    System.out.println(driver.getTitle());
	    driver.findElement(By.xpath("//*[@id=\'main\']/div/div[2]/div[2]/article[1]/div/div[2]/div[2]/a")).click();
	    ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs3.get(2));
	    System.out.println(driver.getTitle());
	    driver.findElement(By.xpath("//*[@id=\'hotel-availability\']/div[2]/article[1]/div/div[2]/div/a[1]")).click();
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id=\'txtFname\']")).sendKeys("jithin");
	    driver.findElement(By.xpath("//*[@id=\'txtLname\']")).sendKeys("thelakkad");
	    driver.findElement(By.xpath("//*[@id=\'txtEmail\']")).sendKeys("abc@gmail.com");
	    driver.findElement(By.xpath("//*[@id=\'txtMobile\']")).sendKeys("9078583902");
	    driver.findElement(By.xpath("//*[@id=\'txtCity\']")).sendKeys("kochi");
	    Select state =new Select(driver.findElement(By.xpath("//*[@id=\'ddlState\']")));
	    state.selectByValue("KL");
	    //Select country =new Select(driver.findElement(By.xpath("//*[@id=\'ddlCountry\']")));
	  //  country.selectByValue("IN");
	    driver.findElement(By.xpath("//*[@id=\'btnPay\']")).click();
	    
	}
}
