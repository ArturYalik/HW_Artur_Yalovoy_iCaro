package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }
    public void openRegForm() {
        click(By.xpath("//a[@href='/registration?url=%2Fsearch']"));
    }

    public void fillLoginForm(User data) {
        type(By.xpath("//input[@id='email']"),data.getEmail());
        type(By.xpath("//input[@id='password']"),data.getPassword());
    }
    public void fillRegForm(User data) {
        type(By.xpath("//input[@id='email']"),data.getEmail());
        type(By.xpath("//input[@id='password']"),data.getPassword());
        type(By.xpath("//input[@id='name']"),data.getName());
        type(By.xpath("//input[@id='lastName']"),data.getLastname());
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void submitReg() {
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isLogGet() {
        return isElementPresent(By.xpath("//a[contains(.,'Delete account')]"));
    }

    public void logout() {
        click(By.xpath("//a[@href='/logout?url=%2Fsearch']"));
    }

    public boolean isLoggedSuccess(){
        WebDriverWait wait = new WebDriverWait(wd,10);
        WebElement element = wd.findElement(By.xpath("//h1[normalize-space()='Logged in']"));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText().contains("Logged in");
    }

    public void clickOkButton() {
        click(By.xpath("//button[@type='button']"));
    }

    public void clickCheckboxButton() {
        click(By.xpath("//label[position()=5]"));

    }

    public void login(User data) {
        openLoginForm();
        fillLoginForm(data);
        submitLogin();
        pause(10);
        clickOkButton();


    }

    public void submitCarForm() {
        click(By.xpath("//button[@type='submit']"));
    }
    public void submitShowCar() {
        click(By.xpath("//button[@class='positive-button ng-star-inserted']"));
    }
    public void submitAddCar() {
        click(By.xpath("//button[@class='negative-button ng-star-inserted']"));
    }
    public void submitSearcCar() {
        click(By.xpath("//button[@class='neutral-button ng-star-inserted']"));
    }

    public void openCarForm() {
        WebDriverWait wait = new WebDriverWait(wd,10);
        click(By.xpath("//a[@id='1']"));
//        click(By.id("1"));
    }
}

