package AMI_CONTROL_MANAGEMENT;

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

public class AMI_TIMING_FUNCTION_001 {
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
		
		webDriver.findElement(By.id("confirmModal_ok")).click();


		webDriver.quit();
	}
	
	@Test
	public void main() throws InterruptedException 
	{
		String scheme_name = "test";
		WebElement webElement = null;
		webDriver.findElement(By.linkText("Control Management")).click();
		webDriver.findElement(By.linkText("Celibration")).click();
		webDriver.findElement(By.linkText("Solution Program")).click();
		
		webDriver.switchTo().frame("fun_0030201");
		webDriver.findElement(By.xpath("//*[text() = 'Add Scheme']")).click();
		
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame("modalBody");
		webElement = webDriver.findElement(By.id("edtDESCRIPTION"));
		webElement.clear();
		webElement.sendKeys(scheme_name);
		webElement = webDriver.findElement(By.id("edtTOLERANCE"));
		webElement.clear();
		webElement.sendKeys("10");
		webElement = webDriver.findElement(By.id("edtCYCLE"));
		webElement.clear();
		webElement.sendKeys("20");
		new Select(webDriver.findElement(By.id("edtCYCLE_TYPE"))).selectByValue("3");
		webElement = webDriver.findElement(By.id("edtSTART_TIME"));
		webElement.clear();
		String time = Gloabl.system_time1;
		webElement.sendKeys(time);
		webElement = webDriver.findElement(By.id("edtTRY_TIMES"));
		webElement.clear();
		webElement.sendKeys("3");
		webElement = webDriver.findElement(By.id("edtTRY_CYCLE"));
		webElement.clear();
		webElement.sendKeys("30");
		
		webDriver.switchTo().defaultContent();
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		try {
			webDriver.findElement(By.id("mainModal_ok")).click();
		} catch (TimeoutException e) {
			;
		}
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		try {
			webDriver.findElement(By.id("mainModal_ok")).click();
		} catch (TimeoutException e) {
			;
		}
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		try {
			webDriver.findElement(By.xpath("//*[@data-dismiss = 'modal']")).click();
		} catch (TimeoutException e) {
			;
		}		
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame("fun_0030201");
		List<WebElement> lists = webDriver.findElements(By.className("body"));
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i).getText().contains("test") && lists.get(i).getText().contains(time)) {
				lists.get(i).findElement(By.xpath(".[text() = 'Delete']")).click();
				webDriver.switchTo().defaultContent();
				webDriver.findElement(By.id("confirmModal_ok")).click();
			}
		}
	}
}
