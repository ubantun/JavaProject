package selenium_java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	test1.class,
	Webtest.class
})
public class TestAll {
	
}
