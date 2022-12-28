package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
//    WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperCar car;

    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public HelperUser getUser() {
        return user;
    }

    public HelperCar getCar() {
        return car;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Start for FireFox ");
        }else {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Start for Chrome ");
        }
        wd.register(new MyListener());
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        user = new HelperUser(wd);
        car = new HelperCar(wd);
    }

    public void refresh(){
        wd.navigate().refresh();
    }

    public void ternDown() {
        wd.quit();
    }
}
