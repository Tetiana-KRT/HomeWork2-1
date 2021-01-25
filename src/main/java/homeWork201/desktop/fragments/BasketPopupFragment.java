package homeWork201.desktop.fragments;

import homeWork201.abstractClasses.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static homeWork201.abstractClasses.BasePage.clickButton;

public class BasketPopupFragment extends AbstractFragment {
    @FindBy(xpath = "//div[@class='modal-dialog modal-md']")
    private WebElement basketPopupRootElement;

    public static final By basketCheckoutButton = By.xpath("//a[.='Basket / Checkout']");

    public void clickBasketCheckoutButton() {
        clickButton(basketCheckoutButton);
    }
}
