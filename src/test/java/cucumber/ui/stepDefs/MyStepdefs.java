package cucumber.ui.stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.ui.instruments.Browser;
import cucumber.ui.stepDefs.pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


public class MyStepdefs {

    MainPage mainPage;
    ProductListPage productListPage;
    CompareListsPage compareListsPage;
    CompareDetailsPage compareDetailsPage;
    CatalogPage catalogPage;
    WebDriver driver;
    int count;
    String TEST_URL = "https://rozetka.com.ua/";


    private static final Logger logger = LoggerFactory.getLogger(MyStepdefs.class);


    @Given("^a ([^\"]*) browser is opened$")
    public void openBrowser(String s) {

        driver = Browser.getInstance().init(s);
    }

    @And("^Rozetka site is opened$")
    public void rozetkaSiteIsOpened() throws Throwable {
        Browser.open(TEST_URL);
    }


    @When("^user moves cursor to \"([^\"]*)\"$")
    public void userMovesCursorTo(String arg0) throws Throwable {
        mainPage = new MainPage(driver);
        mainPage.waitForPageLoading().selectInMainMenu(arg0);
    }

    @And("^user clicks \"([^\"]*)\" on hidden menu$")
    public void userClicksOnHiddenMenu(String s) throws Throwable {
        mainPage.selectInHiddenMenu(s);
    }

    @And("^user selects \"([^\"]*)\" on catalog page$")
    public void userSelectsOnCatalogPage(String arg0) throws Throwable {
        catalogPage = new CatalogPage(driver);
        catalogPage.waitForPageLoading().selectInCatalog(arg0);
    }

    @And("^user adds (\\d+).. product to compare list$")
    public void userAddsStProductToCompareList(int arg0) throws Throwable {
        productListPage = new ProductListPage(driver);
        productListPage.addToCompareList(arg0);
    }


    @Then("^count of different rows is correct$")
    public void userChecksDifferentRows() throws Throwable {
        Assert.assertEquals(count, compareDetailsPage.checkOnlyDifferenrRows());
    }


    @And("^user clicks only different tabs$")
    public void userClicksOnlyDifferentTabs() throws Throwable {

        compareDetailsPage.clickDifferentTab();
    }

    @And("^user clicks Compare icon on Header$")
    public void userClicksCompareIconOnHeader() throws Throwable {
        Header header = new Header(driver);
        header.clickCompareElement();

    }

    @And("^user clicks Compare button on Compare list$")
    public void userClicksCompareButtonOnCompareList() throws Throwable {
        compareListsPage = new CompareListsPage(driver);
        compareListsPage.clickCompareButton();
    }

    @And("^user gets different rows from all rows$")
    public void userGetsAllRows() throws Throwable {
        compareDetailsPage = new CompareDetailsPage(driver);
        count = compareDetailsPage.getDiffrentRows();
    }
}
