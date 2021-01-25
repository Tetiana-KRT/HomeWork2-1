package homeWork201.desktop.fragments;

import homeWork201.abstractClasses.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static homeWork201.abstractClasses.BasePage.clickButton;
import static homeWork201.abstractClasses.BasePage.setField;
import static homeWork201.desktop.CommonAssertions.verifyIsDisplayed;

public class CheckoutFragment extends AbstractFragment {
    @FindBy(xpath = "//div[@class='main-content checkout-page payment-step checkout-homer address-validation iframe-enabled ']")
    private WebElement checkoutRootElement;

    @FindBy(xpath = "//iframe[@class='global-checkout-chase']")
    public WebElement paymentFrame;

    @FindBy(xpath = "//input[@name='emailAddress']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//input[@name='delivery-fullName']")
    private WebElement nameField;

    @FindBy(xpath = "//button[@id='manualEntryDeliveryAddress']")
    private WebElement addressButton;

    @FindBy(xpath = "//button[@id='hasSubmittedSameAddresses']")
    private WebElement continueToPaymentButton;

    @FindBy(xpath = "//input[@name='delivery-addressLine1']")
    private static WebElement addressLine1;

    @FindBy(xpath = "//input[@name='delivery-addressLine2']")
    private static WebElement addressLine2;

    @FindBy(xpath = "//input[@name='delivery-city']")
    private static WebElement cityField;

    @FindBy(xpath = "//input[@name='delivery-county']")
    private static WebElement stateField;

    @FindBy(xpath = "//input[@name='delivery-postCode']")
    private static WebElement postCodeField;

    public static final By disabledPaymentSection = By.xpath("//div[@class='disabled-container']//h2[.=' 3. Payment ']");
    public static final By disabledDeliveryAddressSection = By.xpath("//h2[contains(text(),'1. Delivery Address')]/../div[@class='block-overlay ']");
    public static final By disabledBillingAddressSection = By.xpath("//h2[contains(text(),'2. Billing Address')]/../div[@class='no-delivery-country block-overlay']");

    public static final By countryDropdown = By.xpath("//select[@id='deliveryCountryDropdown']");
    public static final By cardTypeDropdown = By.xpath("//select[@id='brandSelected']");
    public static final By cardExpirationMonth = By.xpath("//select[@id='visacardValidToMonth']");
    public static final By cardExpirationYear = By.xpath("//select[@id='visacardValidToYear']");

    @FindBy(xpath = "//input[@id='visacardNumber']")
    private static WebElement cardNumber;

    @FindBy(xpath = "//input[@id='visacardName']")
    private static WebElement cardName;

    @FindBy(xpath = "//input[@id='visacardCvv']")
    private static WebElement cardCvv;

    public void enterValueToEmailField(String emailAddress) {
        setField(emailAddressField, emailAddress);
    }

    public void enterValueToNameField(String name) {
        setField(nameField, name);
    }

    public CheckoutFragment selectOptionFromCountryDropdown(String country){
        selectDropdownByTextOptionGeneric(countryDropdown, country);
        return this;
    }

    public CheckoutFragment selectOptionFromCardTypeDropdown(String cardType){
        selectDropdownByTextOptionGeneric(cardTypeDropdown, cardType);
        return this;
    }

    public void clickManualAddressButton() {
        clickButton(addressButton);
    }

    public void clickContinueToPaymentButton() {
        clickButton(continueToPaymentButton);
    }

    public void setFields(Map<String, String> map)
    {
        map.forEach((k,v) -> setField(getField(k),v));
    }

    private static WebElement getField(String fieldName){
        switch (fieldName) {
            case "Address line 1":
                return addressLine1;
            case "Address line 2":
                return addressLine2;
            case "Town/City":
                return cityField;
            case "County/State":
                return stateField;
            default:
                return postCodeField;
        }
    }

    public static void verifyDisabledPaymentSectionDisplayed()
    {
        verifyIsDisplayed(disabledPaymentSection);
    }

    public static void verifyDisabledDeliveryAddressSectionDisplayed()
    {
        verifyIsDisplayed(disabledDeliveryAddressSection);
    }

    public static void verifyDisabledBillingAddressSectionDisplayed()
    {
        verifyIsDisplayed(disabledBillingAddressSection);
    }

    public void setCardDropdowns(Map<String, String> map)
    {
        map.forEach((k,v) -> selectDropdownByIndexGeneric(getCardDropdown(k),getIndex(v)));
    }

    private static By getCardDropdown(String dropdownName){
        switch (dropdownName) {
            case "Expiry Year":
                return cardExpirationYear;
            case "Expiry Month":
                return cardExpirationMonth;
            default:
                return cardTypeDropdown;
        }
    }

    private static int getIndex(String valueName){
        switch (valueName) {
            case "2021":
                return 0;
            case "2022":
                return 1;
            case "2023":
                return 2;
            case "2024":
                return 3;
            case "2025":
                return 4;
            case "01":
                return 0;
            case "02":
                return 1;
            case "03":
                return 2;
            case "04":
                return 3;
            case "05":
                return 4;
            case "06":
                return 5;
            case "07":
                return 6;
            case "08":
                return 7;
            case "09":
                return 8;
            case "10":
                return 9;
            case "11":
                return 10;
            case "12":
                return 11;
            case "Visa":
                return 0;
            case "MasterCard":
                return 1;
            default:
                return 0;
        }
    }

    public void setCardFields(Map<String, String> map)
    {
        map.forEach((k,v) -> setField(getCardField(k),v));
    }

    private static WebElement getCardField(String fieldName){
        switch (fieldName) {
            case "Name On Card":
                return cardName;
            case "CardNumber":
                return cardNumber;
            default:
                return cardCvv;
        }
    }
}
