package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar extends HelperBase {

    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public boolean isCarFormPresent() {
        return new WebDriverWait(wd, 20)
                .until(ExpectedConditions.textToBePresentInElement(
                        wd.findElement(By.xpath("//h1"))
                        , "Let the car work"));
    }


    public void fillCarForm(Car data) {
        typeLocation(data.getLocation());
        type(By.xpath("//input[@id='make']"), data.getMake());
        type(By.xpath("//input[@id='model']"), data.getModel());
        type(By.xpath("//input[@id='year']"), data.getYear());
        select(By.xpath("//select[@id='fuel']"), data.getFuel());
        type(By.xpath("//input[@id='seats']"), data.getSeats());
        type(By.xpath("//input[@id='class']"), data.getCarClass());
        type(By.xpath("//input[@id='serialNumber']"), data.getRegNumber());
        type(By.xpath("//input[@id='price']"), data.getPrice());
    }

    public void typeLocation(String address) {
        type(By.id("pickUpPlace"), address);
        pause(3000);
        click(By.cssSelector("div.pac-item"));

    }

    public void select(By locator, String option) {
        new Select(wd.findElement(locator)).selectByValue(option);
    }

}
