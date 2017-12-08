package AMI_DATA_COLLECTION;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import Main.Gloabl;

public class AMI_STATISTICS_FUNCTION_003 {
	
	private static WebDriver webDriver;

	@BeforeClass
	static public void before()
	{
		System.setProperty("webdriver.ie.driver",Gloabl.IEpathString);
		
		webDriver  = new InternetExplorerDriver();
		webDriver.get(Gloabl.Mainpage);
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.findElement(By.id("USERNAME")).sendKeys(Gloabl.Username1);
		webDriver.findElement(By.id("PASSWORD")).sendKeys(Gloabl.Passwd1);
		webDriver.findElement(By.cssSelector("input.submit")).click();
		webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		webDriver.findElement(By.cssSelector("input.BigButton.First")).click();
	}
	@AfterClass
	static public void after() {	
		
		webDriver.switchTo().defaultContent();
		
		webDriver.findElement(By.xpath("//*[@title = 'Logout']")).click();
		webDriver.findElement(By.id("confirmModal_ok")).click();
		
		webDriver.quit();
	}
	
	@Test
	public void main() throws InterruptedException 
	{
		
		webDriver.findElement(By.linkText("Data Collect")).click();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.findElement(By.linkText("Data Re-Collect")).click();
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		webDriver.findElement(By.linkText("Recollection Statistic")).click();
		
		webDriver.switchTo().frame("fun_0010302");
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		
		new Select(webDriver.findElement(By.id("dataItem"))).selectByIndex(1);
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		
		Calendar cale = Calendar.getInstance();  
		int year = cale.get(Calendar.YEAR);  
		int month = cale.get(Calendar.MONTH) + 1;  
		int day = cale.get(Calendar.DATE);  
		
		String time = year+"-"+month+"-"+day;
		
		webDriver.findElement(By.xpath("//input[@id = 'endTime']")).sendKeys(time);
		
		webDriver.findElement(By.xpath("//*[@class = 'btn-blue middle-btn']")).click();
		webDriver.findElement(By.xpath("//*[@class = 'btn-blue middle-btn']")).click();
		
	}
	
}
