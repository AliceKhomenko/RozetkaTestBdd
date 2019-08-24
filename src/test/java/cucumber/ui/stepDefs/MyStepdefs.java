package cucumber.ui.stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
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
    WebDriver driver;
    int count;
    String TEST_URL="https://rozetka.com.ua/";


    private static final Logger logger
            = LoggerFactory.getLogger(MyStepdefs.class);
    @Given("^a ([^\"]*) browser is opened$")
    public void openBrowser(String s) {
logger.info("open "+s+" browser");
        driver = Browser.getInstance().init(s);
    }

    @And("^Rozetka site is opened$")
    public void rozetkaSiteIsOpened() throws Throwable {
        logger.info("open site "+TEST_URL);
        driver.get(TEST_URL);
    }


    @When("^user moves cursor to \"([^\"]*)\"$")
    public void userMovesCursorTo(String arg0) throws Throwable {
        logger.info("move cursor to "+arg0);
        mainPage = new MainPage(driver).selectInMainMenu(arg0);
        //mainPage.waitForLoadPage()
        //.selectInMainMenu(arg0);
    }

    @And("^user clicks \"([^\"]*)\" on hidden menu$")
    public void userClicksOnHiddenMenu(String s) throws Throwable {
        logger.info("click "+s);
        mainPage.selectInHiddenMenu(s);
    }

    @And("^user selects \"([^\"]*)\" on catalog page$")
    public void userSelectsOnCatalogPage(String arg0) throws Throwable {
        logger.info("select "+arg0);
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.selectInCatalog(arg0);
    }

    @And("^user adds (\\d+).. product to compare list$")
    public void userAddsStProductToCompareList(int arg0) throws Throwable {
        logger.info("user add "+arg0+" product to compare list");
        productListPage = new ProductListPage(driver);
        productListPage.addToCompareList(arg0);
    }

    @And("^user clicks Compare icon$")
    public void userClicksCompareIcon() throws Throwable {
        logger.info("click compare icon in header");
        Header header = new Header(driver);
        header.clickCompareElement();

    }

    @And("^user checks different rows$")
    public void userChecksDifferentRows() throws Throwable {
        logger.info("check diffrent rows");
        Assert.assertEquals(count, compareDetailsPage.checkOnlyDifferenrRows());
    }

    @And("^user clicks Compare button$")
    public void userClicksCompareButton() throws Throwable {
        logger.info("click compare button for first products");
        compareListsPage = new CompareListsPage(driver);
        compareListsPage.clickCompareButton();
    }

    @And("^user clicks only different tabs$")
    public void userClicksOnlyDifferentTabs() throws Throwable {
        logger.info("click Tab \"Only different parameters\"");
        compareDetailsPage = new CompareDetailsPage(driver);
        count = compareDetailsPage.getDiffrentRows();
        logger.info("different rows are "+count);
        compareDetailsPage.clickDifferentTab();
    }
}
