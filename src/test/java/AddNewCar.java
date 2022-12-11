import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddNewCar extends TestBase {

//    @BeforeMethod
//    public void preCondition() {
//        if (app.getUser().isLogGet() == false) {
//            app.getUser().login(new User()
//                    .withEmail("asd@gmail.com")
//                    .withPassword("Qwerty1699!"));
//        }
//
//    }

    @Test
    public void addNewCarPositive() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        Car car = Car.builder()
                .location("Hifa")
                .make("KIA")
                .model("Picanto")
                .year("2020")
                .fuel("Petrol")
                .seats("5")
                .carClass("SUV")
                .regNumber("14459" + i)
                .price("120")
                .build();
        app.getUser().openCarForm();
        Assert.assertTrue(app.getCar().isCarFormPresent());
        app.getCar().fillCarForm(car);
        app.getUser().submitCarForm();
        app.getUser().pause(10);
        app.getUser().submitAddCar();
        Assert.assertTrue(app.getCar().isCarFormPresent());
    }

}
