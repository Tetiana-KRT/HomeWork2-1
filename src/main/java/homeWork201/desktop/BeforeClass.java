package homeWork201.desktop;

import io.cucumber.java.Before;

import static homeWork201.driver.WebDriverFactory.initializeDriver;

public class BeforeClass {
    @Before
    public void setUp() {
        initializeDriver();
    }
}
