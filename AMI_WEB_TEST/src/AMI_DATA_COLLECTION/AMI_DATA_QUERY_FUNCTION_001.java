package AMI_DATA_COLLECTION;

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

public class AMI_DATA_QUERY_FUNCTION_001 {
	
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
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		
		webDriver.findElement(By.id("confirmModal_ok")).click();

		webDriver.quit();
	}
	
	@Test
	public void main() throws InterruptedException 
	{
		WebElement webElement = null;
		
		webDriver.findElement(By.linkText("Data Collect")).click();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.findElement(By.linkText("Data Search")).click();
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		
		webDriver.findElement(By.linkText("User Search")).click();
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
		webDriver.switchTo().frame("fun_0010502");
		
		webDriver.findElement(By.xpath("//*[@class = 'create']")).click();
		
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame("modalBody");
		
		webElement = webDriver.findElement(By.xpath("//input[@id = 'refCode']"));
		webElement.clear();
		webElement.sendKeys("379900215962017");
		
		webDriver.findElement(By.xpath("//*[@onclick = 'table.ajax.reload(null, false);']")).click();
		
		List <WebElement> links = webDriver.findElements(By.xpath("//*[@class  = 'body']"));
		for(int i=0; i<links.size(); i++){  
			if (links.get(i).getText().contains("3799002159620171101")) {
				links.get(i).click();
			}
		}
		
		webDriver.switchTo().defaultContent();
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		try {
			webDriver.findElement(By.xpath("//*[@id = 'mainModal_ok']")).click();		
		} catch (TimeoutException e) {
			System.out.println("1111111111");
		}
					
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame("fun_0010502");
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	
		
		List <WebElement> links1 = webDriver.findElements(By.xpath("//*[@class  = 'row title-row']"));
		for(int i=0; i<links1.size(); i++){  
			System.out.println(""+links1.get(i).getText());
			System.out.println("00000");
			if (links1.get(i).getText().contains("Meter Code Data")) {
				
				try {
					links1.get(i).findElement(By.xpath(".//div[@id = '2-tag']")).click();		
				} catch (TimeoutException e) {
					System.out.println("2222222");
				}
				System.out.println("33333");
			}
		}
		webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		webDriver.switchTo().frame(webDriver.findElement(By.xpath("//*[@class = 'new-page iframe-page']")));
		System.out.println("444444444444");
		List <WebElement> links2 = webDriver.findElements(By.xpath("//div/div[@iframe  = '2-page']"));
		System.out.println("55555555");
		for(int i=0; i<links2.size(); i++){  
			System.out.println(""+links2.get(i).getText());
		}
		
		new Select(webDriver.findElement(By.id("dataType"))).selectByValue("1");
		Calendar cale = Calendar.getInstance();  
		int year = cale.get(Calendar.YEAR);  
		int month = cale.get(Calendar.MONTH) + 1;  
		int day = cale.get(Calendar.DATE);  
		String time = year+"-"+month+"-"+day;
		webElement = webDriver.findElement(By.xpath("//input[@id = 'startTime']"));
		webElement.clear();
		webElement.sendKeys(time);
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		try {
			webDriver.findElement(By.xpath("//*[@id = 'search-btn']")).click();		
		} catch (TimeoutException e) {
			System.out.println("6666");
		}
		
	}
	
}
