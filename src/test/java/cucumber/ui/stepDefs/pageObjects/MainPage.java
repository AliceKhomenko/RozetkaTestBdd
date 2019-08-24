package cucumber.ui.stepDefs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    final WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//ul[@class='menu-categories menu-categories_type_main']")
    public WebElement mainMenu;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(mainMenu));

    }

    public MainPage selectInMainMenu(String s) {

        WebElement menuField = driver.findElement(By.xpath("//a[@class='menu-categories__link' and contains(text(),'" + s + "')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuField).build().perform();

        return this;


    }

    public CatalogPage selectInHiddenMenu(String s) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='menu__hidden-title' and contains(text(),'" + s + "')]")));
        WebElement element = driver.findElement(By.xpath("//a[@class='menu__hidden-title' and contains(text(),'" + s + "')]"));
        element.click();
        return new CatalogPage(driver);
    }

//public MainPage waitForLoadPage(){return this;}
}
