package AMI_LOGIN_SIGN_OUT;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Main.Gloabl;

public class AMI_LOGIN_FUNCTION_014 {
	
	private static WebDriver webDriver1;
	private static WebDriver webDriver2;
	private static WebElement button1;
	private static WebElement text;
	private static String main_handle;
	
	@BeforeClass
	static public void beforeclass()
	{
		System.setProperty("webdriver.ie.driver",Gloabl.IEpathString);
		webDriver1  = new InternetExplorerDriver();
		webDriver1.get(Gloabl.Mainpage);
		
		webDriver2  = new InternetExplorerDriver();
		webDriver2.get(Gloabl.Mainpage);
		
		webDriver1.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		webDriver2.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void afterclass() {
		
		List <WebElement> links = webDriver1.findElements(By.className("dropdown-toggle"));
		for(int i=0; i<links.size(); i++){  
            links.get(i).click();  
        }
		
		Set<String> handles = webDriver1.getWindowHandles();
		for (String handle : handles) {
			if (handle.equals(main_handle) == false) {
				webDriver1.switchTo().window(handle);
			}
		}
		webDriver1.findElement(By.id("confirmModal_ok")).click();;
		webDriver1.quit();
			
		webDriver2.findElement(By.xpath("//*[text()='该用户已登录 Unknow 在其他客户端(Unknow)!' or contains(.,'The user name or password entered is incorrect!')]"));
		webDriver2.findElement(By.xpath("//input[@value='重新登录' or @value='Relogin']")).click();
		
		webDriver2.quit();
		
	}
	
	@Test
	public void main1() throws InterruptedException 
	{
	
		text = webDriver1.findElement(By.id("USERNAME"));
		text.sendKeys(Gloabl.Username1);
		
		text = webDriver1.findElement(By.id("PASSWORD"));
		text.sendKeys(Gloabl.Passwd1);
		
		button1 = webDriver1.findElement(By.className("submit"));
		button1.click();
		
		webDriver1.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		button1 = webDriver1.findElement(By.className("BigButton"));
		button1.click();
		
		main_handle = webDriver1.getWindowHandle();			
		
	}
	
	@Test
	public void main2() throws InterruptedException 
	{
	
		text = webDriver2.findElement(By.id("USERNAME"));
		text.sendKeys(Gloabl.Username1);
		
		text = webDriver2.findElement(By.id("PASSWORD"));
		text.sendKeys(Gloabl.Passwd1);
		
		button1 = webDriver2.findElement(By.className("submit"));
		button1.click();		
		
	}
	
}