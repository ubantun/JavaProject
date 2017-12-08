package AMI_CONTROL_MANAGEMENT;

import java.util.Calendar;
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

public class AMI_STOP_ELECTRICITY_FUNCITON_022 {
	
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
		String scheme_name = "test";
		WebElement webElement = null;
		webDriver.findElement(By.linkText("Control Management")).click();
		webDriver.findElement(By.linkText("Power Off/On Management")).click();
		webDriver.findElement(By.linkText("Solution Program")).click();
		
		webDriver.switchTo().frame("fun_0030101");
		webDriver.findElement(By.id("addBtn")).click();
		webDriver.switchTo().frame("new-page");
		
		webElement = webDriver.findElement(By.xpath("//input[@id = 'DESCRIPTION']"));
		webElement.clear();
		webElement.sendKeys(scheme_name);
		new Select(webDriver.findElement(By.id("SCHEME_TYPE"))).selectByValue("0");
		new Select(webDriver.findElement(By.id("EXEC_WAY"))).selectByValue("0");
		webDriver.findElement(By.xpath("//input[@id = 'BRANCH_DESC']")).click();
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame("modalBody");
		List<WebElement> lists = webDriver.findElements(By.className("body"));
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i).getText().contains("00003")) {
				lists.get(i).click();
			}
		}
		
		webDriver.switchTo().defaultContent();
		webDriver.findElement(By.id("mainModal_ok")).click();

		webDriver.switchTo().frame("fun_0030101");
		webDriver.switchTo().frame("new-page");
		webElement = webDriver.findElement(By.id("START_DATETIME"));
		Calendar cale = Calendar.getInstance();  
		int year = cale.get(Calendar.YEAR);  
		int month = cale.get(Calendar.MONTH) + 1;  
		int day = cale.get(Calendar.DATE);  
		int is = cale .get(Calendar.HOUR_OF_DAY);
		int isf = cale .get(Calendar.MINUTE);
		int iss = cale .get(Calendar.SECOND);
		String time1 = year+"-"+month+"-"+day+" "+is+":"+isf+":"+iss;
		webElement.clear();
		webElement.sendKeys(time1);
		
		webElement = webDriver.findElement(By.id("END_DATETIME"));
		String time2 = year+"-"+(month-1)+"-"+day+" "+is+":"+isf+":"+iss;
		webElement.clear();
		webElement.sendKeys(time2);
		webDriver.findElement(By.xpath("//div[text() = 'Save']")).click();

		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame("fun_0030101");
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		List <WebElement> links = webDriver.findElements(By.xpath("//*[@class = 'body']"));
		for(int i=0; i<links.size(); i++){  
			if (links.get(i).getText().contains(scheme_name) && links.get(i).getText().contains("To Be Approved")) {
				try {
					webDriver.findElement(By.xpath("//*[text() = 'Delete']")).click();
				} catch (TimeoutException e) {
					;
				}
				break;
			}
		}
		webDriver.switchTo().defaultContent();
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		try {
			webDriver.findElement(By.id("confirmModal_ok")).click();
		} catch (TimeoutException e) {
			;
		}
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		try {
			webDriver.findElement(By.xpath("//*[text() = 'OK']")).click();
		} catch (TimeoutException e) {
			;
		}
		
	}
	
}
