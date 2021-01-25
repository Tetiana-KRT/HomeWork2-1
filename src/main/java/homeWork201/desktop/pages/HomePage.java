package homeWork201.desktop.pages;

import homeWork201.abstractClasses.BasePage;
import homeWork201.constants.TextConstants;

import static homeWork201.driver.WebDriverFactory.getDriver;

public class HomePage extends BasePage {
    public void navigateToHomePage() {
        getDriver().get(TextConstants.HOME_URL);
    }
}
