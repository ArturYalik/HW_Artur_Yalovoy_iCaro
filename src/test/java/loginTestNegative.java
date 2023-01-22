import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginTestNegative extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogGet()) {
            app.getUser().logout();
        }
    }

    @Test
    public void loginTestNegative() {
        User data = new User()
                .withEmail("asd@gmail.com")
                .withPassword("Qwert1699!");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();
        app.getUser().pause(30);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[.='Login failed']")));
    }

    @AfterMethod
    public void postCondition() {
        app.getUser().pause(30);
        app.getUser().clickOkButton();
    }
}
