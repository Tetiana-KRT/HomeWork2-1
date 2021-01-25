package homeWork201.stepDefinitions;

import homeWork201.abstractClasses.BasePage;
import homeWork201.desktop.CommonAssertions;
import homeWork201.desktop.fragments.*;
import homeWork201.desktop.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.Map;

import static homeWork201.driver.WebDriverFactory.getDriver;

public class StepDefinitions extends BasePage {

    HomePage homePage = new HomePage();
    HeaderFragment headerFragment = new HeaderFragment();
    SearchPage searchPage = new SearchPage();
    SearchResultFragment searchResultFragment = new SearchResultFragment();
    FiltersFragment filtersFragment = new FiltersFragment();
    BasketPopupFragment basketPopupFragment = new BasketPopupFragment();
    BasketPage basketPage = new BasketPage();
    MiniBasketFragment miniBasketFragment = new MiniBasketFragment();
    CheckoutFragment checkoutFragment = new CheckoutFragment();


    @Given("^Anonymous user opens Home page$")
    public void anonymousUserOpensHomePage() {
        homePage.navigateToHomePage();
    }

    @And("^User searches for \"(.*?)\"$")
    public void theUserSearchesFor(String bookName) {
        headerFragment.enterValueToSearchField(bookName);
        headerFragment.clickSearchButton();
    }

    @And("^User is redirected to a Search page$")
    public void userRedirectedToSearchPage() {
        searchPage.checkUrl();
    }

    @And("^Search results contain the book \"(.*?)\"$")
    public void verifyBookIsPresentInSearchResult(String bookName) {
        searchResultFragment.verifyBookInSearchResult(bookName);
    }

    @And("^User applies the following search filters$")
    public void apply(DataTable table) {
            List<Map<String, String>> rows = table.asMaps(String.class, String.class);
            rows.forEach(row -> filtersFragment.selectOptionInDropdown(row));
            filtersFragment.clickRefineButton();
    }

    @And("^Search results contain only (\\d*?) books$")
    public void verifyCorrectBooksNumberInSearchResult(String number) {
        searchResultFragment.verifyNumberOfBooksIsCorrect(number);
    }

    @And("^User clicks 'Add to basket' button for product with name \"(.*?)\"$")
    public void clickAddToBasketButtonForBook(String bookName) {
        searchResultFragment.clickAddToBasketButton(bookName);
    }

    @And("^User selects 'Basket/Checkout' in basket pop-up$")
    public void clickBasketCheckoutButton() {
        basketPopupFragment.clickBasketCheckoutButton();
    }

    @And("^User is redirected to a Basket page$")
    public void userRedirectedToBasketPage() {
        basketPage.checkBasketPageUrl();
    }

    @And("^Basket order summary is as following:$")
    public void checkOrderSummary(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        rows.forEach(row -> basketPage.verifyEqualsValue(row));
    }

    @And("^User clicks 'Checkout' button on 'Basket' page$")
    public void clickCheckoutButton() {
        basketPage.clickCheckoutButton();
    }

    @And("^Checkout order summary is as following:$")
    public void checkOrderSummaryInMiniBasket(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        rows.forEach(row -> miniBasketFragment.verifyEqualsValue(row));
    }

    @And("^User populates e-mail address as a new customer: \"(.*?)\"$")
    public void populateEmailAddress(String emailAddress) {
        checkoutFragment.enterValueToEmailField(emailAddress);
    }

    @And("^User clicks 'Set address manually' button$")
    public void clickManualAddressButton() {
        checkoutFragment.clickManualAddressButton();
    }

    @And("^User populates full name: \"(.*?)\"$")
    public void populateFullName(String name) {
        checkoutFragment.enterValueToNameField(name);
    }

    @And("^User populates country: \"(.*?)\"$")
    public void populateCountry(String country) {
        checkoutFragment.selectOptionFromCountryDropdown(country);
    }

    @And("^User fills delivery address information manually:$")
    public void setDeliveryAddressManually(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        rows.forEach(row -> checkoutFragment.setFields(row));
    }

    @And("^'Payment' section is disabled for editing$")
    public void verifyPaymentSectionIsDisabled() {
        checkoutFragment.verifyDisabledPaymentSectionDisplayed();
    }

    @And("^User clicks 'Continue to payment' button on checkout$")
    public void clickContinueToPaymentButton() {
        checkoutFragment.clickContinueToPaymentButton();
    }

    @And("^'Delivery Address' and 'Billing Address' sections are disabled for editing$")
    public void verifyDeliveryBillingAddressSectionIsDisabled() {
        checkoutFragment.verifyDisabledDeliveryAddressSectionDisplayed();
        checkoutFragment.verifyDisabledBillingAddressSectionDisplayed();
    }

    @And("^User enters card expiration date$")
    public void setCardDropdowns(DataTable table) {
//        getDriver().switchTo().frame(checkoutFragment.paymentFrame);
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        rows.forEach(row -> checkoutFragment.setCardDropdowns(row));
    }

    @And("^User enters card details$")
    public void setCardFields(DataTable table) {
        getDriver().switchTo().frame(checkoutFragment.paymentFrame);
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        rows.forEach(row -> checkoutFragment.setCardFields(row));
    }



}
