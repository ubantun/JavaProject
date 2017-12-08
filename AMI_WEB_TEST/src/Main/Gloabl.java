package Main;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Gloabl {
	static Calendar cale = Calendar.getInstance();  
	static int year = cale.get(Calendar.YEAR);  
	static int month = cale.get(Calendar.MONTH) + 1;  
	static int day = cale.get(Calendar.DATE);  
	static int is = cale .get(Calendar.HOUR_OF_DAY);
	static int isf = cale .get(Calendar.MINUTE);
	static int iss = cale .get(Calendar.SECOND);
	public static String system_time1 = year+"-"+month+"-"+day+" "+is+":"+isf+":"+iss;
	
	public static String Mainpage = "http://192.168.1.6:8400/";
	public static String IEpathString = "E:\\eclipse-jee-kepler-SR2-win32-x86_64\\IEDriverServer.exe";
	public static String Username1 = "inhemeter";
	public static String Passwd1 = "inhe2017";
	
	public static String Username2 = "";
	public static String Passwd2 = "inhe2017";
	
	public static String Username3 = "test_test";
	public static String Passwd3 = "inhe2017";
	
	public static String Username4 = "inhemeter\n";
	public static String Passwd4 = "inhe2017";
	
	public static String Username5 = "inhemeter ";
	public static String Passwd5 = "inhe2017";
	
	public static String Username6 = "inhe meter";
	public static String Passwd6 = "inhe2017";
	
	public static String Username7 = " inhemeter";
	public static String Passwd7 = "inhe2017";
	
	public static String Username8 = "1==1";
	public static String Passwd8 = "inhe2017";
	
	public static String Username9 = "inhemeter123";
	public static String Passwd9 = "inhe2017";
	
	public static String Username10 = "inhemeter";
	public static String Passwd10 = "inhe";
	
	public static String Username11 = "inhemeter";
	public static String Passwd11 = "inhe2017 ";
	
	public static String Username12 = "inhemeter";
	public static String Passwd12 = " inhe2017";
	
	public static String Username13 = "inhemeter";
	public static String Passwd13 = " inhe 2017";
	
//	public void ASSERT_EQUAL_VOID(int original,int target) {
//		
//	}
	
	public static String element_id_username = "USERNAME";
	public static String element_id_passwd = "PASSWORD";
	public static String element_id_submit = "submit";
	
	public static String element_id_exit_OK = "confirmModal_ok";
	
	public static String element_linktext_DossierManagement = "Dossier Management";
	public static String element_linktext_Substation = "Substation";
	public static String element_linktext_linestation = "Line";
	
	public static String frame_Substation_seek = "fun_00601";
	public static String frame_Linestation_seek = "fun_00602";
	
	public static void debug_print(int num1,int num2,String caseneme,String id) {
		if (num1 != num2) {
			System.out.println("The action for id: "+id+" is error in the testcase :"+ caseneme +
					" in the function :"+ Thread.currentThread().getStackTrace()[2].getMethodName()+
					" the line: "+Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}
	
	public static WebElement element_find(WebDriver webDriver,String id) {
		
		WebElement webElement = null;
		try {
			webElement = webDriver.findElement(By.id(id));
		} catch (NoSuchElementException e) {
			return null;
		}		
		return webElement;
	}
	
	public static int element_click_id(WebDriver webDriver,String id) {
		
		WebElement webElement = null;
		try {
			webElement = webDriver.findElement(By.id(id));
		} catch (NoSuchElementException e) {
			return -1;
		}
		webElement.click();
		
		return 0;
	}
	
	public static int element_click_class(WebDriver webDriver,String classname) {
		
		WebElement webElement = null;
		try {
			webElement = webDriver.findElement(By.className(classname));
		} catch (NoSuchElementException e) {
			return -1;
		}
		webElement.click();
		
		return 0;
	}
	
	public static int element_click_link(WebDriver webDriver,String link) {
		
		WebElement webElement = null;
		try {
			webElement = webDriver.findElement(By.linkText(link));
		} catch (NoSuchElementException e) {
			return -1;
		}
		webElement.click();
		
		return 0;
	}
	
	public static int element_click_xpath(WebDriver webDriver,String xpath) {
		
		WebElement webElement = null;
		try {
			webElement = webDriver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			return -1;
		}
		webElement.click();
		
		return 0;
	}
		
	public static int element_send_id(WebDriver webDriver,String id,String text) {
		
		WebElement webElement = null;
		try {
			webElement = webDriver.findElement(By.id(id));
		} catch (NoSuchElementException e) {
			return -1;
		}
		webElement.clear();
		if (text != null) {
			webElement.sendKeys(text);
		}
		return 0;
	}
	
	public static int frame_switch_name(WebDriver webDriver,String default_frame,String franeme1,String franeme2) {
		
		
		if (default_frame != null) {
			try {
				webDriver.switchTo().defaultContent();
			} catch (Exception e) {
				return -1;
			}

		}
		if (default_frame != null) {
			try {
				webDriver.switchTo().frame(franeme1);
			} catch (Exception e) {
				return -1;
			}

		}
		if (default_frame != null) {
			try {
				webDriver.switchTo().frame(franeme2);
			} catch (Exception e) {
				return -1;
			}

		}
		return 0;
	}
}



