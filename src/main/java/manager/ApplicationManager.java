package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver wd;
    HelperUser user;

    HelperCar car;

    public HelperUser getUser() {
        return user;
    }

    public HelperCar getCar() {
        return car;
    }

    ;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        user = new HelperUser(wd);
        car = new HelperCar(wd);
    }

    public void ternDown() {
        wd.quit();
    }
}
