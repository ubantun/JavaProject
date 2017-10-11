
package selenium_java;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Webtest {
	
	private static WebDriver webDriver;
	@BeforeClass
	static public void beforeclass()
	{
		System.out.println("------beforeclass------");
		webDriver  = new InternetExplorerDriver();
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		webDriver.get("www.hao123.com");
	}
	@AfterClass
	public static void afterclass() {
		webDriver.quit();
	}
	
	@Test
	public void main() throws InterruptedException 
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");			
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		//定位输入框元素
        WebElement webElement = webDriver.findElement(By.id("search-input"));
        //在输入框输入文本
        webElement.sendKeys("HelloWorld");
        //定位按钮元素
        //WebElement btn = webDriver.findElement(By.id("su"));
        //btn.click();
	}
	
	
}
