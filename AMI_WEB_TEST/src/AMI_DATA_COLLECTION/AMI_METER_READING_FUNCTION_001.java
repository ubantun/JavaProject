package AMI_DATA_COLLECTION;

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

public class AMI_METER_READING_FUNCTION_001 {
	
	private static WebDriver webDriver;
	private static String handle1;
	
	@BeforeClass
	static public void beforeclass()
	{
		System.setProperty("webdriver.ie.driver",Gloabl.IEpathString);
		
		webDriver  = new InternetExplorerDriver();
		webDriver.get(Gloabl.Mainpage);
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		webDriver.findElement(By.id("USERNAME")).sendKeys(Gloabl.Username1);
		
		webDriver.findElement(By.id("PASSWORD")).sendKeys(Gloabl.Passwd1);
		
		//button1 = webDriver.findElement(By.className("submit")).click();
		webDriver.findElement(By.cssSelector("input.submit")).click();
		
		
		webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//webDriver.findElement(By.xpath("//*[@class='BigButton First' or @value = 'Enter System']")).click();
		webDriver.findElement(By.cssSelector("input.BigButton.First")).click();
		
		handle1 = webDriver.getWindowHandle();	
		
	}
	@AfterClass
	public static void afterclass() {
			
		List <WebElement> links = webDriver.findElements(By.className("dropdown-toggle"));
		for(int i=0; i<links.size(); i++){  
            links.get(i).click();  
            System.out.println("-----click------");
        }
		
		Set<String> handles = webDriver.getWindowHandles();
		for (String handle : handles) {
			if (handle.equals(handle1) == false) {
				webDriver.switchTo().window(handle);
			}
		}
		
		webDriver.findElement(By.id("confirmModal_ok")).click();
		
		webDriver.quit();		
	}
	
	@Test
	public void main() throws InterruptedException 
	{
		
		//webDriver.findElement(By.xpath("//*[@flag='001']")).click();  
		webDriver.findElement(By.linkText("Data Collect")).click();
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
        //webDriver.findElement(By.xpath("//*[@flag='00101' and (@name = '实时抄读' or @name = 'Real-time Read')]")).click(); 
		webDriver.findElement(By.linkText("Real-time Read")).click();  
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		                       
		String current_url = webDriver.getCurrentUrl();
		if (current_url.equals("http://192.168.1.6:8400/general/#")) {
			
			webDriver.switchTo().frame("fun_00101").findElement(
					By.xpath("//*[@class='btn left-button group-btn-left red_btn']")).click();
		}
		else {
			System.out.println("current_url = :"+current_url);
		} 
		
		webDriver.switchTo().frame(webDriver.findElement(By.xpath("//*[contains(@id,'mainModalIframe')]")));      
	}
	
}
