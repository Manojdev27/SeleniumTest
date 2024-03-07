import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class GooglePageTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manoj Targaryen\\Downloads\\New folder\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        List<WebElement> elements = driver.findElements(By.xpath("//a"));
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getText();
           if(!text.equals("")){
               System.out.println(text);
           }
        }
    driver.close();
    }


}
