package homeWork201.desktop.fragments;

import homeWork201.abstractClasses.AbstractFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static homeWork201.abstractClasses.BasePage.clickButton;
import static homeWork201.abstractClasses.BasePage.setField;

public class HeaderFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class='header-wrap ']")
    private WebElement headerRootElement;

    @FindBy(xpath = "//input[@name='searchTerm']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@aria-label='Search']")
    private WebElement searchButton;

    public HeaderFragment() {
        setRootElement(headerRootElement);
    }

    public void enterValueToSearchField(String bookName) {
        setField(searchField, bookName);
    }

    public void clickSearchButton() {
        clickButton(searchButton);
    }
}
