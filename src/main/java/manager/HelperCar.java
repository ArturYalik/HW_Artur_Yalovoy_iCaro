package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar extends HelperBase {

    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public boolean isCarFormPresent(){
       return new WebDriverWait(wd,10).until(ExpectedConditions.textToBePresentInElement(
                wd.findElement(By.xpath("//div[@class='car-card']//h1[.=' Let the car work ']")), " Let the car work "));
    }


    public void fillCarForm(Car data) {
        type(By.xpath("//input[@id='pickUpPlace']"),data.getLocation());
        type(By.xpath("//label[@for='make']"),data.getMake());
        type(By.xpath("//label[@for='model']"),data.getModel());
        type(By.xpath("//input[@id='year']"),data.getYear());
        type(By.xpath("//select[@id='fuel']"),data.getFuel());
        type(By.xpath("//input[@id='seats']"),data.getSeats());
        type(By.xpath("//input[@id='class']"),data.getCarClass());
        type(By.xpath("//input[@id='serialNumber']"),data.getRegNumber());
        type(By.xpath("//input[@id='price']"),data.getPrice());
    }


}
