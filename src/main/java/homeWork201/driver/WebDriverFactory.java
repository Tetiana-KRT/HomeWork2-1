package homeWork201.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver()
    {
        if(driver==null){
            initializeDriver();
        }
        return driver;
    }

    public static void initializeDriver(){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-certificate-errors");
            System.setProperty("webdriver.chrome.driver", "D:\\homeWorkMaven\\\\New Version\\\\src\\resources\\\\chromedriver.exe");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
