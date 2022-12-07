import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogGet()){
            app.getUser().logout();
        }
    }

    @Test
    public void loginTest(){
       User data = new User()
               .withEmail("asd@gmail.com")
               .withPassword("Qwerty1699!");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();
        app.getUser().pause(30);
        app.getUser().clickOkButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[contains(.,'Delete account')]")));

    }
    @Test
    public void loginTestNegative(){
       User data = new User()
               .withEmail("asd@gmail.com")
               .withPassword("Qwert1699!");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[.='Login failed']")));
    }

}
