package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Iterator;
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
        type(By.xpath("//input[@id='email']"), data.getEmail());
        type(By.xpath("//input[@id='password']"), data.getPassword());
    }

    public void fillRegForm(User data) {
        type(By.xpath("//input[@id='name']"), data.getName());
        type(By.xpath("//input[@id='lastName']"), data.getLastname());
        type(By.xpath("//input[@id='email']"), data.getEmail());
        type(By.xpath("//input[@id='password']"), data.getPassword());
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

//    public boolean isLoggedSuccess(){
//        WebDriverWait wait = new WebDriverWait(wd,10);
//        WebElement element = wd.findElement(By.xpath("///h1[normalize-space()='Logged in']"));
//        wait.until(ExpectedConditions.visibilityOf(element));
//        return element.getText().contains("Logged in");
//    }

    public boolean isLogSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 20);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(
                By.cssSelector(".dialog-container"))));
        return wd.findElement(
                By.cssSelector(".dialog-container")).getText().contains("success");
    }

    public boolean isRegSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 20);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(
                By.cssSelector(".dialog-container"))));
        return wd.findElement(
                By.cssSelector(".dialog-container")).getText().contains("success");
    }

    public boolean isRegNnegativeSuccessPassword() {
        WebDriverWait wait = new WebDriverWait(wd, 20);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(
                By.xpath("//div[@class='error']"))));
        return wd.findElement(
                By.xpath("//div[@class='error']")).getText().contains("Password");
    }

    public boolean isRegNnegativeEmptyEmail() {
        WebDriverWait wait = new WebDriverWait(wd, 20);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(
                By.xpath("//div[contains(text(),'Email is required')]"))));
        return wd.findElement(
                By.xpath("//div[contains(text(),'Email is required')]")).getText().contains("Email is required");
    }

    public boolean isRegNnegativeEmptyName() {
        WebDriverWait wait = new WebDriverWait(wd, 20);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(
                By.xpath("//div[normalize-space()='Name is required']"))));
        return wd.findElement(
                By.xpath("//div[normalize-space()='Name is required']")).getText().contains("Name is required");
    }

    public boolean isRegNnegativeEmptyLasName() {
        WebDriverWait wait = new WebDriverWait(wd, 20);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(
                By.xpath("//div[normalize-space()='Last name is required']"))));
        return wd.findElement(
                By.xpath("//div[normalize-space()='Last name is required']")).getText().contains("Last name is required");
    }

    public boolean isRegNnegativeSuccessEmail() {
        WebDriverWait wait = new WebDriverWait(wd, 20);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(
                By.xpath("//div[@class='error']"))));
        return wd.findElement(
                By.xpath("//div[@class='error']")).getText().contains("Wrong email format");
    }

    public void clickOkButton() {
        click(By.xpath("//button[@type='button']"));
    }

    public void clickCheckboxButton() {
//        click(By.xpath("//label[contains(text(),'I agree to the')]"));---option 1
//-----------------------------------------------------------------------------------------------
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");

//-----------------------------------------------------------------------------------------------
//        Rectangle rect = wd.findElement(By.xpath("//div[@class='checkbox-container']")).getRect();
//        int x = rect.getX() + 5;
//        int y = rect.getY() + 0;
//        Actions action = new Actions(wd);
//        action.moveByOffset(x,y).click().perform();
    }

    public void login(User data) {
        openLoginForm();
        fillLoginForm(data);
        submitLogin();
        pause(2000);
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
        click(By.id("1"));
    }

    public void typeLocationFindCar(String address) {
        type(By.id("city"), address);
        pause(3000);
        click(By.cssSelector("div.pac-item"));

    }

    public void typeDate(String date) {
        type(By.id("dates"), date);
        pause(3000);
        click(By.xpath("//body"));
    }

    public void typeDateCalendar(String startDate, String finalDate) {
        click(By.xpath("//input[@id='dates']"));
        pause(3000);
        for(WebElement i:wd.findElements(By.xpath("//div[contains(@class,'mat-calendar-body-cell-content')]"))){
            if (i.getText().equals(startDate))
                i.click();
            if (i.getText().equals(finalDate))
                i.click();
        }
        click(By.xpath("//body"));
    }

    public void typeDateAndMounth(String startDate, String finalDate, int numderClikToMounth) {
        click(By.xpath("//input[@id='dates']"));
        pause(3000);
        for(int i = 0;i<numderClikToMounth;i++){
            pause(3000);
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        pause(3000);
        typeDateCalendar(startDate,finalDate);
        click(By.xpath("//body"));
    }
}

