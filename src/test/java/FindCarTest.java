import manager.NGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class FindCarTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getUser().isLogGet() == false) {
            app.getUser().login(new User()
                    .withEmail("asd@gmail.com")
                    .withPassword("Qwerty1699!"));
        }

    }

    @Test(groups = "findCar")
    public void findCarByEnteringTheDate() {
        app.getUser().pause(3000);
        app.getSh().typeLocationFindCar("Tel Aviv");
        app.getSh().typeDate("1/15/2023-1/25/2023");
        app.getUser().submitCarForm();
        Assert.assertTrue(app.getSh().isListPresent());
    }

    @Test(groups = "findCar")
    public void findCarByClick() {
        app.getUser().pause(3000);
        app.getSh().typeLocationFindCar("Tel Aviv");
        app.getSh().fillSearchForm("1/15/2023","1/25/2023");
        app.getUser().submitCarForm();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getSh().isListPresent());
    }

    @Test(groups = "findCar")
    public void findCarByClickToMounth() {
        app.getUser().pause(3000);
        app.getSh().typeLocationFindCar("Tel Aviv");
        app.getSh().fillSearchFormMonuth("2/15/2023","4/25/2023");
        app.getUser().submitCarForm();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getSh().isListPresent());
    }
 @Test(groups = "findCar")
    public void findCarByClickToYears() {
        app.getUser().pause(3000);
        app.getSh().typeLocationFindCar("Tel Aviv");
        app.getSh().fillSearchFormYears("1/15/2023","1/2/2024");
        app.getUser().submitCarForm();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getSh().isListPresent());
    }

}
