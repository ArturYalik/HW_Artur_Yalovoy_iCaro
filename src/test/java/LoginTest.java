import manager.NGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)

public class LoginTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogGet()) {
            app.getUser().logout();
        }
    }

    @Test
    public void loginTest() {
        User data = new User()
                .withEmail("asdgmail.com")
                .withPassword("Qwerty1699!");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();
//        Assert.assertTrue(app.getUser().isLoggedSuccess());



    }

    @AfterMethod
    public void postCondition() {
        app.getUser().pause(2000);
        app.getUser().clickOkButton();
    }

}
