package homeWork201;

import homeWork201.desktop.EpamContactPage;
import homeWork201.desktop.RegExMethods;
import org.junit.jupiter.api.*;

import static homeWork201.desktop.EpamContactPage.getEpamAddress;
import static homeWork201.desktop.RegExMethods.getValueByRegEx;

public class EpamAddressElementsTest {
    private EpamContactPage epamContactPage;
    private RegExMethods regExMethods;



    @BeforeEach
    public void setUp() {
        regExMethods = new RegExMethods();
        epamContactPage = new EpamContactPage();

    }

    @DisplayName("Add To Cart Test")
    @Tag("testTag")
    @Test
    public void addToCartTest() {
        epamContactPage.navigateToEpamContactPage();
        String completeAddress = getEpamAddress();
        String pattern = "^(.+) • (.+),\\n(.+), (.+) • (.+)$";
        String postIndexPattern = "[A-Z]{2} [0-9]{5}";
        String country = getValueByRegEx(completeAddress, pattern, 5);
        String city = getValueByRegEx(completeAddress, pattern, 3);
        String postIndexByGroup = getValueByRegEx(completeAddress, pattern, 4);
        String postIndex = getValueByRegEx(completeAddress, postIndexPattern);
        String street = getValueByRegEx(completeAddress, pattern, 1);
        String building = getValueByRegEx(completeAddress, pattern, 2);

        System.out.println("Country is " + country + "\n" + "City is " + city + "\n" + "Post index is " + postIndex + "\n" + "Post index by group is " + postIndexByGroup + "\n" +
                "Street is " + street + "\n" + "Building is " + building);

    }

}
