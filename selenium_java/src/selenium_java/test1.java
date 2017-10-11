package selenium_java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

class count
{
	public int add(int x ,int y){
		return x+y;
		}
}

public class test1 {

	@BeforeClass
	static public void BeforeClass() {
		System.out.println("BeforeClass......");
	}
	@AfterClass
	static public void AfterClass() {
		System.out.println("Afterclass......");
	}
	@Before
	public void Before() {
		System.out.println("before......");
	}
	@After
	public void After() {
		System.out.println("After......");
	}
	@Test
	public void test() {
		//fail("Not yet implemented");
		int z=new count().add(3,5);
		assertEquals(z,8);
	}
	@Test ()
	public void testdivision(){
		System.out.println("------test start------");
	}

}
