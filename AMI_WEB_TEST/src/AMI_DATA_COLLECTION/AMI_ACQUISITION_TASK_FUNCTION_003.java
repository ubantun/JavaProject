
package AMI_DATA_COLLECTION;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Main.Gloabl;

public class AMI_ACQUISITION_TASK_FUNCTION_003 {
	
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
		
//		webDriver.switchTo().defaultContent();
//		
//		webDriver.findElement(By.xpath("//*[@title = 'Logout']")).click();
//		webDriver.findElement(By.id("confirmModal_ok")).click();
//		
//		webDriver.quit();
	}
	
	@Test
	public void main() throws InterruptedException 
	{
		webDriver.findElement(By.linkText("Data Collect")).click();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.findElement(By.linkText("Scheduled Collect")).click();  
				
		webDriver.switchTo().frame("fun_00102");
		
		webDriver.findElement(By.xpath("//*[@class = 'item'][@code = '0000027d6f4fbc0f7a60']")).isEnabled();
			
//		element = webDriver.findElement(By.xpath("//input[@id='START_TIME']"));
//		element.clear();
//		element.sendKeys("2017-11-10 08:08:08");

	}
	
}
