package cucumber.ui.stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.ui.instruments.Browser;
import cucumber.ui.stepDefs.pageObjects.*;
import org.testng.Assert;

public class MyStepdefs extends Browser{

    MainPage mainPage;
    ProductListPage productListPage;
    CompareListsPage compareListsPage;
    CompareDetailsPage compareDetailsPage;
    int count;


    @Given("^a Chrome browser is opened$")
        public void openBrowser(){
           driver = init("chrome");
        }

    @And("^Rozetka site is opened$")
    public void rozetkaSiteIsOpened() throws Throwable {
            driver.get("https://rozetka.com.ua/");
    }


    @When("^user moves cursor to \"([^\"]*)\"$")
    public void userMovesCursorTo(String arg0) throws Throwable {
      mainPage = new MainPage(driver).selectInMainMenu(arg0);
      //mainPage.waitForLoadPage()
      //.selectInMainMenu(arg0);
    }

    @And("^user clicks \"([^\"]*)\" on hidden menu$")
    public void userClicksOnHiddenMenu(String s) throws Throwable {
      mainPage.selectInHiddenMenu(s);
    }

    @And("^user selects \"([^\"]*)\" on catalog page$")
    public void userSelectsOnCatalogPage(String arg0) throws Throwable {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.selectInCatalog(arg0);
    }

    @And("^user adds (\\d+).. product to compare list$")
    public void userAddsStProductToCompareList(int arg0) throws Throwable {
        productListPage = new ProductListPage(driver);
        productListPage.addToCompareList(arg0);
    }

    @And("^user clicks Compare icon$")
    public void userClicksCompareIcon() throws Throwable {
        Header header = new Header(driver);
        header.clickCompareElement();

    }

    @And("^user checks different rows$")
    public void userChecksDifferentRows() throws Throwable {
        Assert.assertEquals(count,compareDetailsPage.checkOnlyDifferenrRows());
    }

    @And("^user clicks Compare button$")
    public void userClicksCompareButton() throws Throwable {
        compareListsPage = new CompareListsPage(driver);
        compareListsPage.clickCompareButton();
    }

    @And("^user clicks only different tabs$")
    public void userClicksOnlyDifferentTabs() throws Throwable {
        compareDetailsPage =new CompareDetailsPage(driver);
        count = compareDetailsPage.getDiffrentRows();
        compareDetailsPage.clickDifferentTab();
    }
}
