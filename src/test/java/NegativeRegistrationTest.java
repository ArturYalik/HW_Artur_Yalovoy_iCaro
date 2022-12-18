import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeRegistrationTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogGet()) {
            app.getUser().logout();
        }
    }

    @Test
    public void regTestNegativePassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User().withName("Name" + i)
                .withLastname("LastMane" + i)
                .withEmail("name" + i + "@gmail.com")
                .withPassword("Qwerty1699");


        app.getUser().openRegForm();
        app.getUser().fillRegForm(data);
        app.getUser().click(By.xpath("//h1"));
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isRegNnegativeSuccessPassword());

    }
@Test
    public void regTestEmptyPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User().withName("Name" + i)
                .withLastname("LastMane" + i)
                .withEmail("name" + i + "@gmail.com")
                .withPassword("");


        app.getUser().openRegForm();
        app.getUser().fillRegForm(data);
        app.getUser().click(By.xpath("//h1"));
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isRegNnegativeSuccessPassword());

    }

    @Test
    public void regTestWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User().withName("Name" + i)
                .withLastname("LastMane" + i)
                .withEmail("name" + i + "@gmail,com")
                .withPassword("Qwerty1699!");


        app.getUser().openRegForm();
        app.getUser().fillRegForm(data);
        app.getUser().click(By.xpath("//h1"));
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isRegNnegativeSuccessEmail());
    }
    @Test
    public void regTestEmptygEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User().withName("Name" + i)
                .withLastname("LastMane" + i)
                .withEmail("")
                .withPassword("Qwerty1699!");


        app.getUser().openRegForm();
        app.getUser().fillRegForm(data);
        app.getUser().click(By.xpath("//h1"));
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isRegNnegativeEmptyEmail());
    }
    @Test
    public void regTestEmptygLastName() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User().withName("Name" + i)
                .withLastname("")
                .withEmail("name" + i + "@gmail.com")
                .withPassword("Qwerty1699!");


        app.getUser().openRegForm();
        app.getUser().fillRegForm(data);
        app.getUser().click(By.xpath("//h1"));
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isRegNnegativeEmptyLasName());
    }
    @Test
    public void regTestEmptygName() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User().withName("")
                .withLastname("LastMane" + i)
                .withEmail("name" + i + "@gmail.com")
                .withPassword("Qwerty1699!");


        app.getUser().openRegForm();
        app.getUser().fillRegForm(data);
        app.getUser().click(By.xpath("//h1"));
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isRegNnegativeEmptyName());
    }
    @AfterMethod
    public void quit(){
        app.refresh();
    }
}

