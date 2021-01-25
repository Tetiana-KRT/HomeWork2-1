package homeWork201.abstractClasses;

import homeWork201.driver.WebDriverFactory;
import homeWork201.utils.WebDriverWaiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static homeWork201.driver.WebDriverFactory.getDriver;

public class AbstractFragment extends WebDriverWaiter {
    private WebElement rootElement;

    public AbstractFragment() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    public void setRootElement(WebElement element) {
        this.rootElement = element;
    }

    public WebElement getRootElement() {
        return rootElement;
    }

    public AbstractFragment selectDropdownOptionGeneric (By locator, String value){
        Select select = new Select (getDriver().findElement(locator));
        select.selectByValue(value);
        return this;
    }

    public AbstractFragment selectDropdownByTextOptionGeneric (By locator, String text){
        Select select = new Select (getDriver().findElement(locator));
        select.selectByVisibleText(text);
        return this;
    }

    public AbstractFragment selectDropdownByIndexGeneric (By locator, int index){
        Select select = new Select (getDriver().findElement(locator));
        select.selectByIndex(index);
        return this;
    }
}
