import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static WebDriver driver;
    //Dynamic Xpath
    static String oldXpath = "//a[text()='Forgot password?']";
    public static void main(String[] args) throws InterruptedException {

        // current project location in java
        String currentWorkingDirectory = System.getProperty("user.dir");
//      System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manoj Targaryen\\Downloads\\New folder\\chromedriver-win64\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/chromedriver.exe");
        driver = new ChromeDriver();

       driver.get("https://www.facebook.com/");
       driver.manage().window().maximize();
       //Absolute Xpath
        //driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[1]/input")).sendKeys("manojkumardev27@gmail.com");
        // Relative Xpath
        //tagname[@attributename = 'value']
        //tagname[text() = 'value']
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("manojkumardev27@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("Godhand");
       driver.findElement(By.xpath("//button[text()='Log in']")).click();


       String errMessage = driver.findElement(By.id("error_box")).getText();
       System.out.println(errMessage);
//     driver.findElement(By.linkText("Forgotten password?")).click();
//      driver.findElement(By.partialLinkText("Forgot")).click();
        // Find the button using Xpath text attribute.
//        driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
        String newXpath = oldXpath.replace("Forgot", "Forgotten");
        click("xpath",newXpath);

        /*
        if(errMessage.contains("Wrong")){
            System.out.println("Test is passed");
        }else{
            System.out.println("Test is failed");
        }*/
        Thread.sleep(5000);
        driver.close();

    }

    static void click(By by) throws InterruptedException {
        Thread.sleep(6000);
        driver.findElement(by).click();
    }

    static void click(WebElement element) throws InterruptedException {
        Thread.sleep(6000);
        element.click();
    }
    static void click(String locatorType, String locatorValue) throws InterruptedException {
        Thread.sleep(3000);
        if (locatorType.equalsIgnoreCase("xpath")){
            driver.findElement(By.xpath(locatorValue)).click();
        }
        else if(locatorType.equalsIgnoreCase("id")){
            driver.findElement(By.id(locatorValue)).click();
        }
        else if(locatorType.equalsIgnoreCase("linkText")){
            driver.findElement(By.linkText(locatorValue)).click();
        }
    }
}