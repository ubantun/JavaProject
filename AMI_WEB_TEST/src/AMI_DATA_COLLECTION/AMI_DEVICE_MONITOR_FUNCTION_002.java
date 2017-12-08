package AMI_DATA_COLLECTION;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import Main.Gloabl;

public class AMI_DEVICE_MONITOR_FUNCTION_002 {
	
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
		
		try {
			webDriver.findElement(By.xpath("//*[@title = 'Logout']")).click();
		} catch (TimeoutException e) {
			;
		}
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		
		try {
			webDriver.findElement(By.id("confirmModal_ok")).click();
		} catch (TimeoutException e) {
			;
		}

		webDriver.quit();
	}
	
	@Test
	public void main() throws InterruptedException 
	{
		WebElement webElement = null;
		
		webDriver.findElement(By.linkText("Data Collect")).click();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.findElement(By.linkText("Important Device Board")).click();
		
		webDriver.switchTo().frame("fun_00108");
		
		webDriver.findElement(By.xpath("//*[@class = 'create']")).click();
		
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame("modalBody");
		webElement = webDriver.findElement(By.xpath("//input[@id = 'deviceNum']"));
		webElement.clear();
		webElement.sendKeys("37990021596");
		
		webDriver.findElement(By.xpath("//*[@class = 'btn btn-primary']")).click();
		
		List <WebElement> links = webDriver.findElements(By.xpath("//*[@class  = 'body']"));
		for(int i=0; i<links.size(); i++){  
			if (links.get(i).getText().contains("37990021596")) {
				links.get(i).click();
			}
		}
		
		webDriver.switchTo().defaultContent();
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		try {
			webDriver.findElement(By.id("mainModal_ok")).click();
		} catch (TimeoutException e) {
			;
		}
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);		
		webDriver.switchTo().frame("fun_00108");			
		new Select(webDriver.findElement(By.xpath("//*[@id = 'refreshFrequency']"))).selectByValue("10");
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		try {
			webDriver.findElement(By.id("start-btn")).click();
		} catch (TimeoutException e) {
			;
		}
		
		new Select(webDriver.findElement(By.xpath("//*[@id = 'refreshFrequency']"))).selectByValue("15");
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		try {
			webDriver.findElement(By.id("stop-btn")).click();
		} catch (TimeoutException e) {
			;
		}
		
		new Select(webDriver.findElement(By.xpath("//*[@id = 'refreshFrequency']"))).selectByValue("30");
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		try {
			webDriver.findElement(By.id("start-btn")).click();
		} catch (TimeoutException e) {
			;
		}
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		try {
			webDriver.findElement(By.id("stop-btn")).click();
		} catch (TimeoutException e) {
			;
		}
	}
	
}
