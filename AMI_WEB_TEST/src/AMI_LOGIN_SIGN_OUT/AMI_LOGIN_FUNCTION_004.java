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

public class AMI_LOGIN_FUNCTION_004 {
	
	private static WebDriver webDriver;
	private static WebElement button1;
	private static WebElement text;
	
	@BeforeClass
	static public void beforeclass()
	{		
		System.setProperty("webdriver.ie.driver",Gloabl.IEpathString);
		webDriver  = new InternetExplorerDriver();
		webDriver.get(Gloabl.Mainpage);
		
		webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);		
	}
	
	@AfterClass
	public static void afterclass() {
			
		webDriver.findElement(By.xpath("//*[text()='输入的用户名或密码错误' or contains(.,'The user name or password entered is incorrect!')]"));
		webDriver.findElement(By.xpath("//input[@value='重新登录' or @value='Relogin']")).click();
		
		webDriver.quit();
		
	}
	
	@Test
	public void main() throws InterruptedException 
	{
	
		text = webDriver.findElement(By.id("USERNAME"));
		text.sendKeys(Gloabl.Username7);
		
		text = webDriver.findElement(By.id("PASSWORD"));
		text.sendKeys(Gloabl.Passwd7);
		
		button1 = webDriver.findElement(By.className("submit"));
		button1.click();		
		
	}
	
}