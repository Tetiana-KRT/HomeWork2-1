package homeWork201.desktop.pages;

import homeWork201.abstractClasses.BasePage;

import static homeWork201.driver.WebDriverFactory.getDriver;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class SearchPage extends BasePage {
    private static final String searchPageUrl = "https://www.bookdepository.com/search?searchTerm=Thinking+in+Java&search=Find+book";
    private static final String pageUrlPattern = searchPageUrl;

    public SearchPage() {
        setPageUrl(searchPageUrl);
    }
    public boolean checkUrl() {
        boolean result = searchPageUrl.equals(getDriver().getCurrentUrl());
        if (!result && isNotEmpty(pageUrlPattern)) {
            return getDriver().getCurrentUrl().matches(pageUrlPattern);
        }
        return result;
    };
}
