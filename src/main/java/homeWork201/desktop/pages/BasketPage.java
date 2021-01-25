package homeWork201.desktop.pages;

import homeWork201.abstractClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static homeWork201.desktop.CommonAssertions.verifyFieldEquals;
import static homeWork201.driver.WebDriverFactory.getDriver;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class BasketPage extends BasePage {
    private static final String basketPageUrl = "https://www.bookdepository.com/search?searchTerm=Thinking+in+Java&search=Find+book";
    private static final String basketPageUrlPattern = basketPageUrl;
    public static final By checkoutButton = By.xpath("//div[@class='checkout-btns-wrap']//a[.='Checkout']");
    @FindBy(xpath="//dt[.='Delivery cost']/..//dd")
    static
    WebElement deliveryCost;
    @FindBy(xpath="//dt[.='Total']/..//dd")
    static
    WebElement total;

    public BasketPage() {
        setPageUrl(basketPageUrl);
    }
    public boolean checkBasketPageUrl() {
        boolean result = basketPageUrl.equals(getDriver().getCurrentUrl());
        if (!result && isNotEmpty(basketPageUrlPattern)) {
            return getDriver().getCurrentUrl().matches(basketPageUrlPattern);
        }
        return result;
    }

    public static void verifyEqualsValue(Map<String,String> map)
    {
        map.forEach((k,v) -> verifyFieldEquals(getTotalByType(k),v));
    }

    private static WebElement getTotalByType(String totalType){
        switch (totalType) {
            case "Total":
                return total;
            default:
                return deliveryCost;
        }
    }
    public void clickCheckoutButton() {
        clickButton(checkoutButton);
    }
}
