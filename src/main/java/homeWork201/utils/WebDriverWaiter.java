package homeWork201.utils;

import org.openqa.selenium.support.ui.WebDriverWait;

import static homeWork201.driver.WebDriverFactory.getDriver;

public class WebDriverWaiter {

    protected WebDriverWait wait;

    public WebDriverWaiter() {
        wait = new WebDriverWait(getDriver(), 5);
    }
}
