package homeWork201.desktop.fragments;

import homeWork201.abstractClasses.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static homeWork201.abstractClasses.BasePage.clickButton;
import static homeWork201.desktop.CommonAssertions.selectDropdownValue;
import static homeWork201.desktop.CommonAssertions.verifyFieldEquals;
import static homeWork201.driver.WebDriverFactory.getDriver;


public class FiltersFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class='sidebar-section search-filter']")
    private WebElement FiltersRootElement;
    @FindBy(xpath = "//button[contains(text(),'Refine results')]")
    private WebElement RefineButton;

    public FiltersFragment selectOptionFromDropdown(By locator, String value){
        selectDropdownOptionGeneric(locator, value);
        return this;
    }

    public static final By priceRangeDropdown = By.xpath("//select[@id='filterPrice']");
    public static final By availabilityDropdown = By.xpath("//select[@id='filterAvailability']");
    public static final By languageDropdown = By.xpath("//select[@id='filterLang']");
    public static final By formatDropdown = By.xpath("//select[@id='filterFormat']");

//    public static Select selectPriceRange = new Select(getDriver().findElement(By.xpath("//select[@id='filterPrice']")));
//    public static Select selectAvailability = new Select(getDriver().findElement(By.xpath("//select[@id='filterAvailability']")));
//    public static Select selectLanguage = new Select(getDriver().findElement(By.xpath("//select[@id='filterLang']")));
//    public static Select selectFormat = new Select(getDriver().findElement(By.xpath("//select[@id='filterFormat']")));

    public void selectOptionInDropdown(Map<String, String> map)
    {
        map.forEach((k,v) -> selectOptionFromDropdown(getDropdown(k),getValue(v)));
    }

    private static By getDropdown(String dropdownName){
        switch (dropdownName) {
            case "Availability":
                return availabilityDropdown;
            case "Language":
                return languageDropdown;
            case "Format":
                return formatDropdown;
            default:
                return priceRangeDropdown;
        }
    }

    private static String getValue(String text){
        switch (text) {
            case "Under 15 €":
                return "low";
            case "15 € to 30 €":
                return "med";
            case "30 € +":
                return "high";
            case "In Stock":
                return "1";
            case "English":
                return "123";
            case "Italian":
                return "202";
            case "Chinese":
                return "79";
            case "Polish":
                return "347";
            case "Paperback":
                return "1";
            case "Hardback":
                return "2";
            case "Digital":
                return "5";
            default:
                return "All";
        }
    }

    public void clickRefineButton() {
        clickButton(RefineButton);
    }
}
