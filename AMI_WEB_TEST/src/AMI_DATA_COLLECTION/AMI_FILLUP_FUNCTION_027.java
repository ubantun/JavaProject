package AMI_DATA_COLLECTION;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Main.Gloabl;

public class AMI_FILLUP_FUNCTION_027 {
	
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
		WebElement webElement = null;
		String name = "杨家峪";
		webDriver.findElement(By.linkText("Data Collect")).click();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.findElement(By.linkText("Data Re-Collect")).click();		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		webDriver.findElement(By.linkText("Recollection Statistic")).click();
		webDriver.switchTo().frame("fun_0010302");
		
		webElement = webDriver.findElement(By.id("tree-search-input"));
		webElement.clear();
		webElement.sendKeys(name);
		webDriver.findElement(By.xpath("//*[@onclick = 'searchTree()']")).click();
		webDriver.findElement(By.linkText("杨家峪供电局")).click();
		
		webDriver.findElement(By.xpath("//div[@onclick = 'refreshTable();']")).click();
		webDriver.findElement(By.xpath("//div[@onclick = 'refreshTable();']")).click();
		
		List <WebElement> links = webDriver.findElements(By.className("body"));
		if (links.get(0).getText().length() > 0) {				
			System.out.println("the test for the AMI_FILLUP_FUNCTION_027 is failed");
		}
	}
}
