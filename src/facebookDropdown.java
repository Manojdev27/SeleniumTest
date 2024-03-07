import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class facebookDropdown {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        String currentWorkingDestination = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", currentWorkingDestination + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        // Register link
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a")).click();
        Thread.sleep(6000);
//        driver.findElement(By.id("u_18_b_Qr")).sendKeys("Manoj");
//        Thread.sleep(4000);
//        driver.findElement(By.id("u_18_d_Pk")).sendKeys("Kumar");
//        Thread.sleep(4000);
//        driver.findElement(By.id("u_18_g_Y+")).sendKeys("manojkumardev27@gmail.com");
//        Thread.sleep(4000);
//        driver.findElement(By.id("password_step_input")).sendKeys("Godhand");
//        Thread.sleep(6000);

        // Handling Dropdowns using WebElement interface and Select class
      WebElement dayElement =  driver.findElement(By.id("day"));
        Select daySelect = new Select(dayElement);
        daySelect.selectByValue("27");
        Thread.sleep(3000);
        WebElement monthElement =  driver.findElement(By.id("month"));
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByVisibleText("May");
        Thread.sleep(3000);
        WebElement yearElement =  driver.findElement(By.id("year"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByIndex(31);
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//*[@id=\"u_c_9_Z8\"]")).click();

        List<WebElement> yearOptions = yearSelect.getOptions();
        for (int i = 0; i < yearOptions.size(); i++) {
            System.out.println(yearOptions.get(i).getText());
        }
        System.out.println();
        List<WebElement> monthOptions = monthSelect.getOptions();
        for (int i = 0; i < monthOptions.size(); i++) {
            System.out.println(monthOptions.get(i).getText());
        }

        // Gettings all values and store in a list of strings in dayString
        List<WebElement> dayOptions = daySelect.getOptions();
        List<String> dayStrings = new ArrayList<>();
        for (int i = 0; i < dayOptions.size(); i++) {
            dayStrings.add(dayOptions.get(i).getText());
        }
        System.out.println(dayStrings);
        driver.close();


    }
}
