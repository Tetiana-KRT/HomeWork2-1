package homeWork201.desktop;

import homeWork201.abstractClasses.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static homeWork201.driver.WebDriverFactory.getDriver;

public class CommonAssertions extends BasePage {
    public static void verifyFieldEquals(WebElement field, String value)
    {
        Assert.assertEquals(value, field.getText());
    }
    public static void selectDropdownValue(Select dropdownField, String value)
    {
        dropdownField.selectByValue(value);
    }

    public static void verifyFieldContains(WebElement field, String value)
    {
        Assert.assertTrue(field.getText().contains(value));
    }

    public static void verifyPageIsOpen(String pageName)
    {
        Assert.assertTrue(getDriver().getTitle().contains(BasePage.getPageTitle(pageName)));
    }

    public static void verifyIsDisplayed(By locator)
    {
        Assert.assertEquals(true, getDriver().findElement(locator).isDisplayed());
    }

}
