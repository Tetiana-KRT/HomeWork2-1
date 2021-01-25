package homeWork201.desktop.fragments;

import homeWork201.abstractClasses.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static homeWork201.desktop.CommonAssertions.verifyFieldEquals;

public class MiniBasketFragment extends AbstractFragment {
    @FindBy(xpath = "//div[@class='sidebar right']//div[@class='mini-basket']")
    private WebElement miniBasketRootElement;

    @FindBy(xpath="//div[@class='sidebar right']//*[contains(text(),'Sub-total')]/../..//dd")
    static
    WebElement subtotal;

    @FindBy(xpath="//div[@class='sidebar right']//*[contains(text(),'Delivery')]/../..//dd")
    static
    WebElement delivery;

    @FindBy(xpath="//div[@class='sidebar right']//*[contains(text(),'VAT')]/../..//dd")
    static
    WebElement vat;

    @FindBy(xpath="//div[@class='sidebar right']//*[contains(text(),'Total')]/../..//dd")
    static
    WebElement total;

    public static void verifyEqualsValue(Map<String,String> map)
    {
        map.forEach((k,v) -> verifyFieldEquals(getTotalByType(k),v));
    }

    private static WebElement getTotalByType(String totalType){
        switch (totalType) {
            case "Total":
                return total;
            case "Sub-total":
                return subtotal;
            case "VAT":
                return vat;
            default:
                return delivery;
        }
    }
}
