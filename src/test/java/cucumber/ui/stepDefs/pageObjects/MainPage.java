package cucumber.ui.stepDefs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage {
    final WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//ul[@class='menu-categories menu-categories_type_main']")
    public WebElement mainMenu;
    private static final Logger logger
            = LoggerFactory.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public MainPage waitForPageLoading() {
        wait.until(ExpectedConditions.visibilityOf(mainMenu));
        return this;
    }

    public MainPage selectInMainMenu(String s) {
        logger.info("move cursor to "+s);


        WebElement menuField = driver.findElement(By.xpath("//a[@class='menu-categories__link' and contains(text(),'" + s + "')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuField).build().perform();

        return this;


    }

    public CatalogPage selectInHiddenMenu(String s) {
        logger.info("click "+s);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='menu__hidden-title' and contains(text(),'" + s + "')]")));
        WebElement element = driver.findElement(By.xpath("//a[@class='menu__hidden-title' and contains(text(),'" + s + "')]"));
        element.click();
        return new CatalogPage(driver);
    }

}
