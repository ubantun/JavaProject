package selenium_java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	RemoteWebDriverTest.class,
	Webtest.class
})
public class TestAll {
	
}
