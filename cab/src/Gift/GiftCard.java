package Gift;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class GiftCard {
	
	WebDriver driver;
	String url = "https://www.makemytrip.com/";
	
	
	@BeforeSuite
	public void openBrowser(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\TEJAS K\\workspace\\FirstSeleniumProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
    }
	
	@Test
	public void nextStep() throws IOException{
		WebElement more = driver.findElement(By.xpath("//*[@id='SW']/div[1]/div[2]/div/div/nav/ul/li[10]/a/span[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(more).build().perform();
		driver.findElement(By.xpath("//*[@id='SW']/div[1]/div[2]/div/div/nav/ul/li[10]/div/a[3]")).click();
		
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/div/div[2]/div[2]/ul/li[1]/div/img")).click();
	
		//Gift card details
		
		driver.findElement(By.name("senderName")).sendKeys("Tejas");
		driver.findElement(By.name("senderMobileNo")).sendKeys("9206821110");
		driver.findElement(By.name("senderEmailId")).sendKeys("9206821110@gmail.com");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/button")).click();
		
		//login using otp
		driver.findElement(By.xpath("//*[@id='root']/div/div/main/div[1]/div[1]/button")).click();
		driver.findElement(By.id("otp")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div[2]/section/form/div[2]/button")).click();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	@Test(priority=1)
	public void screenShot(){

		TakesScreenshot shot = (TakesScreenshot) driver;
		File source = shot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/screenshots/"+".jpg");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterSuite
	public void closeBrowser(){
		

		
		driver.quit();
		
		
		
	}
	
	


}
