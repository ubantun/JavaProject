package AMI_DATA_COLLECTION;

import java.text.NumberFormat;
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

public class AMI_FILLUP_FUNCTION_016 {
	
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
		int num1 = 0;
		webDriver.findElement(By.linkText("Data Collect")).click();
		webDriver.findElement(By.linkText("Data Re-Collect")).click();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		webDriver.findElement(By.linkText("Recollection Statistic")).click();
		webDriver.switchTo().frame("fun_0010302");
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);	

		List <WebElement> links = webDriver.findElements(By.className("body"));
		for(int i=0; i<links.size(); i++){  
			if (!links.get(i).getText().equals(null)) {				
				num1++;
			}
		}
		if (num1 >0) {
			String string[] = links.get(0).getText().split("\n");

			NumberFormat numberFormat = NumberFormat.getInstance();  		  
	        numberFormat.setMaximumFractionDigits(2);  
	        String result = numberFormat.format(Float.parseFloat(string[6])/ Float.parseFloat(string[5]) * 100);  
	        if (!result.equals(string[10])) {
	        	System.out.println("the test for AMI_FILLUP_FUNCTION_016 is failed ");  
			}
		}		
	}
}
