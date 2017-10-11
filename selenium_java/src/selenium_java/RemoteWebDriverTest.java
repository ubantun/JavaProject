package selenium_java;

import java.net.URL;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverTest {
	
	private WebDriver webDriver = null;

	@BeforeClass
	static public void BeforeClass() {
		System.out.println("BeforeClass......");
	}
	@AfterClass
	//@Parameter()//向处理函数注入参数？
	static public void AfterClass() {
		System.out.println("Afterclass......");
		
	}
	@Before
	public void Before() {
		System.out.println("Before......");
	}
	@After
	public void After() {
		System.out.println("After......");
		if (webDriver != null) {
			webDriver.get("https://www.baidu.com");
			webDriver.findElement(By.id("kw")).sendKeys("selenium");
			webDriver.findElement(By.id("su")).click();
			
			webDriver.quit();
		}
		else {
			JOptionPane.showConfirmDialog(null, "浏览器未被打开", "提示", 
    				JOptionPane.CLOSED_OPTION);
			return ;
		}	
	}
	@Ignore
	@Test
	public void test_ie() throws Exception {
		webDriver = new RemoteWebDriver( new URL("http://127.0.0.1:4444/wd/hub"),
				DesiredCapabilities.internetExplorer());

	}
	
	@Ignore
	@Test
	public void test_chrome() throws Exception {
		webDriver = new RemoteWebDriver( new URL("http://127.0.0.1:4444/wd/hub"),
				DesiredCapabilities.chrome());		
	}
	@Ignore
	@Test
	public void test_htmlUnit() throws Exception {
		System.out.println("------the htmlunit test------");
		webDriver = new RemoteWebDriver( new URL("http://127.0.0.1:4444/wd/hub"),
				DesiredCapabilities.htmlUnit());
	}
	@Ignore
	@Test
	public void test_PhantomJS() throws Exception {
		System.out.println("------the PhantomJS test------");
		webDriver = new RemoteWebDriver( new URL("http://127.0.0.1:4444/wd/hub"),
				DesiredCapabilities.phantomjs());
	}
	@Test
	public void test_Opera() {
		webDriver = new OperaDriver();
		}
	

}
