package cucumber.ui.stepDefs;

import cucumber.api.PendingException;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.ui.instruments.Browser;


import org.openqa.selenium.WebDriver;

public class MyStepdefs {
    Browser browser = new Browser();
    WebDriver driver;
        @Given("^a Chrome browser is opened$")
        public void openBrowser(){
           driver = browser.init("chrome");
        }

    @And("^Rozetka site is opened$")
    public void rozetkaSiteIsOpened() throws Throwable {
            driver.get("https://rozetka.com.ua/");
    }


}
