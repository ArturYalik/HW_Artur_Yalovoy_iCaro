import manager.NGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class FindCarTest extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getUser().isLogGet() == false) {
            app.getUser().login(new User()
                    .withEmail("asd@gmail.com")
                    .withPassword("Qwerty1699!"));
        }

    }
    @Test(groups = "findCar")
    public void findCarByEnteringTheDate(){
        String location = "Tell Aviv";
        String date = "1/15/2023-1/25/2023";
        app.getUser().pause(3000);
        app.getUser().typeLocationFindCar(location);
        app.getUser().typeDate(date);
        app.getUser().submitCarForm();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class='search-results']")));
    }
    @Test(groups = "findCar")
    public void findCarByClick(){
        String location = "Tell Aviv";
        String startDate = "15";
        String finalDate = "18";
        app.getUser().pause(3000);
        app.getUser().typeLocationFindCar(location);
        app.getUser().typeDateCalendar(startDate,finalDate);
        app.getUser().submitCarForm();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class='search-results']")));
    }
    @Test(groups = "findCar")
    public void findCarByClickToMounth(){
        String location = "Tell Aviv";
        String startDate = "15";
        String finalDate = "18";
        int numderClikToMounth = 2;
        app.getUser().pause(3000);
        app.getUser().typeLocationFindCar(location);
        app.getUser().typeDateAndMounth(startDate,finalDate,numderClikToMounth);
        app.getUser().submitCarForm();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[@class='search-results']")));
    }

}
