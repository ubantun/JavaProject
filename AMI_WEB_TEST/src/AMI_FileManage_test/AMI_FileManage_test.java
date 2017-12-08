package AMI_FileManage_test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import Main.Gloabl;

public class AMI_FileManage_test {
	
	private static WebDriver webDriver;
	static int substation_init_flag = 0;
	static int linestation_init_flag = 0;
	
	@BeforeClass
	static public void beforeclass()
	{
		int ret = 0;
		System.setProperty("webdriver.ie.driver",Gloabl.IEpathString);
		
		webDriver  = new InternetExplorerDriver();
		webDriver.get(Gloabl.Mainpage);
		
		webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		ret = Gloabl.element_send_id(webDriver, Gloabl.element_id_username, Gloabl.Username1);
		Gloabl.debug_print(ret,0,"AMI_FileManage_subs_test_001", Gloabl.element_id_username);
		
				
		ret = Gloabl.element_send_id(webDriver, Gloabl.element_id_passwd, Gloabl.Passwd1);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_001", Gloabl.element_id_passwd);
		
		ret = Gloabl.element_click_class(webDriver, Gloabl.element_id_submit);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_001", Gloabl.element_id_submit); 
	
		webDriver.findElement(By.xpath("//input[@class='BigButton First']")).click();
		
	}
	@AfterClass
	public static void afterclass() {
		
		int ret;
			
		webDriver.switchTo().defaultContent();
		webDriver.findElement(By.xpath("//*[@title = 'Logout']")).click();	
		
		ret = Gloabl.element_click_id(webDriver, Gloabl.element_id_exit_OK); 
		Gloabl.debug_print(ret ,0,"AMI_FileManage_test", Gloabl.element_id_exit_OK); 
		
		webDriver.quit();
		
	}
	
	void Substation_init(){
		int ret = 0;		
		
		if (substation_init_flag == 0) {
			
			webDriver.switchTo().defaultContent();
			
			ret = Gloabl.element_click_link(webDriver, Gloabl.element_linktext_DossierManagement);
			Gloabl.debug_print(ret ,0,"Substation_init", Gloabl.element_linktext_DossierManagement); 
			
			ret = Gloabl.element_click_link(webDriver, Gloabl.element_linktext_Substation);
			Gloabl.debug_print(ret ,0,"Substation_init", Gloabl.element_linktext_Substation); 	
			
			webDriver.switchTo().frame(Gloabl.frame_Substation_seek);
			
			substation_init_flag = 1;
		}
		else {
			return ;
		}
	}
	
	void linestation_init(){
		int ret = 0;		
		
		if (linestation_init_flag == 0) {
			
			webDriver.switchTo().defaultContent();
			
			ret = Gloabl.element_click_link(webDriver, Gloabl.element_linktext_DossierManagement);
			Gloabl.debug_print(ret ,0,"linestation_init", Gloabl.element_linktext_DossierManagement); 
			
			ret = Gloabl.element_click_link(webDriver, Gloabl.element_linktext_linestation);
			Gloabl.debug_print(ret ,0,"linestation_init", Gloabl.element_linktext_linestation); 	
			
			webDriver.switchTo().frame(Gloabl.frame_Linestation_seek);
			
			linestation_init_flag = 1;
		}
		else {
			return ;
		}
	}
		
	@Test
	public void AMI_FileManage_subs_test_001()
	{
		int ret = 0;
		Substation_init();
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_001", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_001", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_001", gloabl.element_id_Search);
		
	}
	
	@Test
	public void AMI_FileManage_subs_test_002()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, "变电站编号");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_002", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_002", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_002", gloabl.element_id_Search);
		
	}
	
	@Test
	public void AMI_FileManage_subs_test_003()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, "!@＃＂'");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_003", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_003", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_003", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_004()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, "abcdefg");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_004", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_004", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_004", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_005()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, "0123");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_005", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_005", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_005", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_006()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, " ");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_006", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_006", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_006", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_007()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, "");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_007", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_007", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_007", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_008()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_008", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, "变电站名称");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_008", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_008", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_009()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_009", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, "!@＃＂'");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_009", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_009", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_010()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_010", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, "abcdefg");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_010", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_010", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_011()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_011", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, "0123");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_011", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_011", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_012()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_012", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, " ");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_012", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_012", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_013()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_013", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, "");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_013", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_013", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_014()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_014", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_014", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(1);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_014", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_015()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_015", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_015", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(2);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_015", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_016()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_016", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_016", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(3);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_016", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_017()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_017", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_017", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(4);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_017", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_018()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_018", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_018", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(1);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_018", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_019()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_019", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_019", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(2);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_019", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_subs_test_020()
	{
		int ret = 0;
		Substation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationCode, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_020", gloabl.element_id_SubstationCode); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_SubstationName, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_020", gloabl.element_id_SubstationName);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_VoltageLevel)).selectByIndex(3);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_subs_test_020", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_001()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_002()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, "线路编号");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_003()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, "!@＃＂'");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_004()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, "abcdefg");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_005()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, "0123");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	
	@Test
	public void AMI_FileManage_line_test_006()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, " ");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_007()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, "");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_008()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, "线路名字");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_009()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, "!@＃＂'");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_010()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, "abcdefg");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_011()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, "0123");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_012()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, " ");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_013()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, "");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_014()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(1);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_015()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(2);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(0);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_016()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(1);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_017()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(2);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
	
	@Test
	public void AMI_FileManage_line_test_018()
	{
		int ret = 0;
		linestation_init();

		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_LineNumber, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_LineNumber); 
		
		ret = Gloabl.element_send_id(webDriver, gloabl.element_id_NameOfLine, null);
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_NameOfLine);
				
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineType)).selectByIndex(0);
		
		new Select(Gloabl.element_find(webDriver, gloabl.element_id_LineStatu)).selectByIndex(3);
		
		ret = Gloabl.element_click_xpath(webDriver, "//*[@onclick = '"+gloabl.element_id_Search+"']");
		Gloabl.debug_print(ret ,0,"AMI_FileManage_line_test_001", gloabl.element_id_Search);
	}
}

