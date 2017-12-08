package AMI_LOGIN_SIGN_OUT;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Main.Gloabl;

public class AMI_LOGIN_FUNCTION_001 {
	
	private static WebDriver webDriver;
	private static WebElement button1;
	private static WebElement text;
	private static String main_handle;
	
	@BeforeClass
	static public void beforeclass()
	{
		System.setProperty("webdriver.ie.driver",Gloabl.IEpathString);
		
		webDriver  = new InternetExplorerDriver();
		webDriver.get(Gloabl.Mainpage);
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
	}
	@AfterClass
	public static void afterclass() {
			
		webDriver.switchTo().defaultContent();
		
		webDriver.findElement(By.xpath("//*[@title = 'Logout']")).click();
		webDriver.findElement(By.id("confirmModal_ok")).click();
		
		webDriver.quit();
		
	}
	
	@Test
	public void main() throws InterruptedException 
	{
		text = webDriver.findElement(By.id("USERNAME"));
		text.sendKeys(Gloabl.Username1);
		
		text = webDriver.findElement(By.id("PASSWORD"));
		text.sendKeys(Gloabl.Passwd1);
		
		button1 = webDriver.findElement(By.className("submit"));
		button1.click();
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		webDriver.findElement(By.xpath("//input[@class='BigButton First']")).click();
		
		main_handle = webDriver.getWindowHandle();		
		
	}
	
}