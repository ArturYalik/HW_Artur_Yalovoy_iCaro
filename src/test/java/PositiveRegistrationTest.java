import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveRegistrationTest extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogGet()){
            app.getUser().logout();
        }
    }
    @Test
    public void regTest(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User().withName("Name"+i)
                .withLastname("LastMane"+i)
                .withEmail("name" + i + "@gmail.com")
                .withPassword("Qwert1699!");


        app.getUser().openRegForm();
        app.getUser().fillRegForm(data);
        app.getUser().pause(3);
        app.getUser().clickCheckboxButton();
        app.getUser().pause(30);
        app.getUser().submitReg();
        app.getUser().pause(3);
        app.getUser().clickOkButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[contains(.,'Delete account')]")));

    }
}
