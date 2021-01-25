package homeWork201.desktop.fragments;

import homeWork201.abstractClasses.AbstractFragment;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static homeWork201.abstractClasses.BasePage.clickButton;
import static homeWork201.desktop.CommonAssertions.verifyFieldEquals;
import static homeWork201.desktop.CommonAssertions.verifyIsDisplayed;
import static homeWork201.driver.WebDriverFactory.getDriver;

public class SearchResultFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class='tab search']")
    private WebElement searchResultRootElement;

    public static final By bookItem = By.xpath("//div[@class='book-item']");

    private static By bookInSearchResult (String bookName){
        return By.xpath(String.format("//h3[@class='title']//a[contains(text(),'%s')]", bookName));
    }

    private static By addToBasketButtonForBook (String bookName){
        return By.xpath(String.format("//a[contains(text(),'%s')]/../../..//a[contains(text(),'Add to basket')]", bookName));
    }

    public static void verifyBookInSearchResult(String bookName)
    {
        verifyIsDisplayed(bookInSearchResult(bookName));
    }

    public SearchResultFragment() {
        setRootElement(searchResultRootElement);
    }

    public static void verifyNumberOfBooksIsCorrect(String number) {
        int intNumber = Integer.parseInt(number);
        int bookItemsCount = getDriver().findElements(bookItem).size();
        Assert.assertEquals(intNumber, bookItemsCount);
    }

    public void clickAddToBasketButton(String bookName) {
        clickButton(addToBasketButtonForBook(bookName));
    }

}
