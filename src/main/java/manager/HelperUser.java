package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        type(By.xpath("//input[@id='password']"),data.getName());
        type(By.xpath("//input[@id='password']"),data.getLastname());
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

    public void clickOkButton() {
        click(By.xpath("//button[@type='button']"));
    }

    public void clickCheckboxButton() {
        WebElement element = wd.findElement(By.xpath("//input[@class='ng-dirty ng-touched ng-invalid']"));
//        element.();

    }
}

