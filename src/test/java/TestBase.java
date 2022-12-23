import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class TestBase {
    public static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @BeforeMethod
    public void startTest(Method m){
        logger.info("Start Test: "+ m.getName());
    }
    @AfterMethod
    public void stopTest(Method m){
        logger.info("Stop Test: "+ m.getName());
    }
    @AfterSuite
    public void stop() {
//        app.ternDown();
    }

}
