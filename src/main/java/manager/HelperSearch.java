package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class HelperSearch extends HelperBase {


    public HelperSearch(WebDriver wd) {
        super(wd);
    }


    private void selectFormAny(String startDate, String finalDate) {
        String[] startD = startDate.split("/");
        String[] finalD = finalDate.split("/");

        if(startD[2]==finalD[2]&&startD[0]==finalD[0]){
            selectPeriod(startDate,finalDate);
        }else if (startD[2] == finalD[2]) {
            selectPeriodMonuth(startDate, finalDate);
        }else {
            selectPeriodYears(startDate,finalDate);
        }
    }

    private void selectPeriod(String startDate, String finalDate) {
        String[] startD = startDate.split("/");
        String[] finalD = finalDate.split("/");
        String locatorStart = String.format("//div[.=' %s ']", startD[1]);
        String locatorEnd = String.format("//div[.=' %s ']", finalD[1]);
        click(By.xpath(locatorStart));
        click(By.xpath(locatorEnd));
    }

    private void selectPeriodYears(String startDate, String finalDate) {
        String[] startD = startDate.split("/");
        String[] finalD = finalDate.split("/");

        String yearStart = String.format("//div[.=' %s ']", startD[2]);
        String yearEnd = String.format("//div[.=' %s ']", finalD[2]);

        String monuthStart = String.format("//div[.=' %s ']", sendMount(startD[0]));
        String monuthEnd = String.format("//div[.=' %s ']", sendMount(finalD[0]));

        String dayStart = String.format("//div[.=' %s ']", startD[1]);
        String dayEnd = String.format("//div[.=' %s ']", finalD[1]);

        click(By.xpath("//button[@aria-label='Choose month and year']"));
        click(By.xpath(yearStart));
        click(By.xpath(monuthStart));
        click(By.xpath(dayStart));

        click(By.xpath("//button[@aria-label='Choose month and year']"));
        click(By.xpath(yearEnd));
        click(By.xpath(monuthEnd));
        click(By.xpath(dayEnd));


    }
    private void selectPeriodMonuth(String startDate, String finalDate) {
        int nowToStartMounth = 0, nowToEndMounth = 0;
        String[] startD = startDate.split("/");
        String[] finalD = finalDate.split("/");
        nowToEndMounth = Integer.parseInt(finalD[0]) - Integer.parseInt(startD[0]);
        if (LocalDate.now().getMonthValue() != Integer.parseInt(startD[0])) {
            nowToStartMounth = Integer.parseInt(startD[0]) - LocalDate.now().getMonthValue();
        }
        for (int i = 0; i < nowToStartMounth; i++) {
            click((By.xpath("//button[@aria-label='Next month']")));
        }

        String locatorStart = String.format("//div[.=' %s ']", startD[1]);
        String locatorEnd = String.format("//div[.=' %s ']", finalD[1]);
        click(By.xpath(locatorStart));

        for (int i = 0; i < nowToEndMounth; i++) {
            click((By.xpath("//button[@aria-label='Next month']")));
        }
        click(By.xpath(locatorEnd));


    }
    private Object sendMount(String n) {
        String dateOutput = "";
        switch (n) {
            case "1":
                dateOutput = "JAN";
                break;
            case "2":
                dateOutput = "FEB";
                break;
            case "3":
                dateOutput = "MAR";
                break;
            case "4":
                dateOutput = "APR";
                break;
            case "5":
                dateOutput = "MAY";
                break;
            case "6":
                dateOutput = "JUN";
                break;
            case "7":
                dateOutput = "JUL";
                break;
            case "8":
                dateOutput = "AUG";
                break;
            case "9":
                dateOutput = "SEP";
                break;
            case "10":
                dateOutput = "OCT";
                break;
            case "11":
                dateOutput = "NOV";
                break;
            case "12":
                dateOutput = "DEC";
                break;
        }
        return dateOutput;
    }


    public boolean isListPresent() {
        pause(2000);
        return isElementPresent(By.xpath("//div[@class='search-results']"));
    }

    public void typeLocationFindCar(String address) {
        type(By.id("city"), address);
        pause(3000);
        click(By.cssSelector("div.pac-item"));

    }

    public void fillSearchForm(String startDate, String finalDate) {
        click(By.id("dates"));
        selectPeriod(startDate, finalDate);
        pause(3000);

    }

    public void fillSearchFormMonuth(String startDate, String finalDate) {
        click(By.id("dates"));
        selectPeriodMonuth(startDate, finalDate);
        pause(3000);
    }

    public void fillSearchFormYears(String startDate, String finalDate) {
        click(By.id("dates"));
        selectPeriodYears(startDate, finalDate);
        pause(3000);
    }

    public void typeDate(String date) {
        type(By.id("dates"), date);
        pause(3000);
        click(By.xpath("//body"));
    }

   public void fillSearchFormAny(String startDate, String finalDate) {
       click(By.id("dates"));
       selectFormAny(startDate, finalDate);
       pause(3000);
    }

    public void openSearchForm(){
        click(By.id("0"));
    }

}
