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
import org.openqa.selenium.support.ui.Select;

import Main.Gloabl;

public class AMI_FIIIUP_FUNCTION_002 {
	
	private static WebDriver webDriver;

	@BeforeClass
	static public void before()
	{
		String string = "2017-11-14 08:08:08";
		System.setProperty("webdriver.ie.driver",Gloabl.IEpathString);
		
		webDriver  = new InternetExplorerDriver();
		webDriver.get(Gloabl.Mainpage);
		
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.findElement(By.id("USERNAME")).sendKeys(Gloabl.Username1);
		webDriver.findElement(By.id("PASSWORD")).sendKeys(Gloabl.Passwd1);
		webDriver.findElement(By.cssSelector("input.submit")).click();
		webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		webDriver.findElement(By.cssSelector("input.BigButton.First")).click();
		
		webDriver.findElement(By.linkText("Data Collect")).click();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		webDriver.findElement(By.linkText("Data Re-Collect")).click();  
		webDriver.findElement(By.xpath("//*[@flag = '0010301']")).click();
		
		webDriver.switchTo().frame("fun_0010301");
		
		webDriver.findElement(By.xpath("//*[@class = 'create' and @id = 'addBtn']")).click();
		
		webDriver.switchTo().frame("new-page");
		
		webDriver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("test");
		
		new Select(webDriver.findElement(By.id("dataItem"))).selectByIndex(0);
		
		webDriver.findElement(By.xpath("//input[@id = 'range']")).sendKeys("30");
		
		webDriver.findElement(By.xpath("//input[@id = 'cycle']")).sendKeys("30");
		
		webDriver.findElement(By.xpath("//input[@id='baseTime']")).sendKeys(string);
		
		new Select(webDriver.findElement(By.id("autoCalcKwh"))).selectByValue("Y");
		
		new Select(webDriver.findElement(By.id("autoCalcLineloss"))).selectByValue("Y");
		
		webDriver.findElement(By.xpath("//input[@id = 'times']")).sendKeys("10");
		
		new Select(webDriver.findElement(By.id("timeIntervalType"))).selectByIndex(0);
		
		webDriver.findElement(By.xpath("//input[@class = 'input-div']")).sendKeys("10");
		
		//webDriver.findElement(By.xpath("//input[@onclick = 'doSave()']")).click();
		webDriver.findElement(By.cssSelector("div.btn-blue.flex-btn")).click();
		
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
		String string = "2017-11-10 08:08:08";
		WebElement webElement;
		
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame("fun_0010301");   
		
        
        List <WebElement> links = webDriver.findElements(By.className("op-text"));
		//for(int i=0; i<links.size(); i++){  
			if (links.get(0).getText().equals("Edit")) {
				links.get(0).click();
			}
			
		webDriver.switchTo().frame("new-page");
		
		String string1 = webDriver.findElement(By.xpath("//input[@id='baseTime']")).getAttribute("value");
		
		webElement = webDriver.findElement(By.xpath("//input[@id='baseTime']"));
		webElement.clear();
		webElement.sendKeys(string);
		
		webDriver.findElement(By.xpath("//div[@onclick = 'doSave()']")).click();
		
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame("fun_0010301");
			
		List <WebElement> links1 = webDriver.findElements(By.className("op-text"));
		//for(int i=0; i<links.size(); i++){  
			if (links1.get(0).getText().equals("Edit")) {
				links1.get(0).click();
			}
			
		webDriver.switchTo().frame("new-page");
		
		String string2 = webDriver.findElement(By.xpath("//input[@id='baseTime']")).getAttribute("value");
		if (!string2.equals(string)) {
			System.out.println("the time setting is error");
		}
		
		webElement = webDriver.findElement(By.xpath("//input[@id='baseTime']"));
		webElement.clear();
		webElement.sendKeys(string1);
		
		webDriver.findElement(By.xpath("//div[@onclick = 'doSave()']")).click();
		
		webDriver.switchTo().defaultContent();
		webDriver.switchTo().frame("fun_0010301");   
		
		List <WebElement> links2 = webDriver.findElements(By.className("op-text"));
		//for(int i=0; i<links.size(); i++){  
			if (links2.get(1).getText().equals("Delete")) {
				links2.get(1).click();
			}

        webDriver.findElement(By.xpath("//button[text() = 'OK']")).click();
        webDriver.findElement(By.xpath("//button[@type=  'button']")).click();
					
	}
	
}
