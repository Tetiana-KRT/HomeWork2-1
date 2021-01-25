package homeWork201.abstractClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static homeWork201.constants.TextConstants.*;
import static homeWork201.driver.WebDriverFactory.getDriver;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class BasePage
{
    private String pageUrl;
    private String pageUrlPattern;

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public String setPageUrlPattern(String pageUrlPattern) {
        return this.pageUrlPattern = pageUrlPattern;
    }

    public String getPageUrlPattern() {
        return pageUrlPattern;
    }

    public boolean checkUrl() {
        boolean result = pageUrl.equals(getDriver().getCurrentUrl());
        if (!result && isNotEmpty(pageUrlPattern)) {
            return getDriver().getCurrentUrl().matches(pageUrlPattern);
        }
        return result;
    }

    public BasePage()
    {
        PageFactory.initElements(getDriver(), this);
    }

    public Boolean isElementPresent(By locator)
    {
        return getDriver().findElements(locator).size() > 0;
    }

    public BasePage setField(By field, String value)
    {
        getDriver().findElement(field).sendKeys(value);
        return this;
    }
    public static void setField(WebElement field, String value)
    {
        field.sendKeys(value);
    }

    public static void clickButton(By locator)
    {
        getDriver().findElement(locator).click();
    }

    public static void clickButton(WebElement locator)
    {
        locator.click();
    }


    public static String getPageTitle(String pageName){
        switch (pageName) {
            case "Cart":
                return CART_TITLE;
            case "Product details":
                return PRODUCT_DETAILS_TITLE;
            case "Order summary":
                return ORDER_SUMMARY_TITLE;
            case "Register":
                return REGISTER_TITLE;
            case "Search result":
                return SEARCH_RESULT_TITLE;
            default:
                return "No such page";
        }
    }





}
