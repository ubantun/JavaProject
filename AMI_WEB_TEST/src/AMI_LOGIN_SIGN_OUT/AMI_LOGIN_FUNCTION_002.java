package AMI_LOGIN_SIGN_OUT;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Main.Gloabl;

public class AMI_LOGIN_FUNCTION_002 {
	
	private static WebDriver webDriver;
	private static WebElement button1;
	private static WebElement text;
	
	@BeforeClass
	static public void beforeclass()
	{
		System.setProperty("webdriver.ie.driver",Gloabl.IEpathString);
		webDriver  = new InternetExplorerDriver();
		//webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		webDriver.get(Gloabl.Mainpage);
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		try {
			button1 = webDriver.findElement(By.className("BigButton"));
			button1.click();
	        
		} catch (NoSuchElementException e) {
			return;
		}
		
	}
	
	@AfterClass
	public static void afterclass() {
		
		//String xpath="//div[@content='���û��ѵ�¼ Unknow �������ͻ���(Unknow)!']";
		
		webDriver.findElement(By.xpath("//*[text()='���û��ѵ�¼ Unknow �������ͻ���(Unknow)!' or text()='The user has login the system at Unknow by other clients(Unknow)!']"));
		webDriver.findElement(By.xpath("//input[@value='���µ�¼' or @value='Relogin']")).click();
		
		webDriver.quit();
		
	}
	
	@Test
	public void main() throws InterruptedException 
	{
	
		text = webDriver.findElement(By.id("USERNAME"));
		text.sendKeys(Gloabl.Username2);
		
		text = webDriver.findElement(By.id("PASSWORD"));
		text.sendKeys(Gloabl.Passwd2);
		
		button1 = webDriver.findElement(By.className("submit"));
		button1.click();		
		
	}
	
}