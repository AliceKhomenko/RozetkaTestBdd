package cucumber.ui.stepDefs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatalogPage {
    final WebDriver driver;
    WebDriverWait wait;

    private static final Logger logger
            = LoggerFactory.getLogger(CatalogPage.class);

    @FindBy(id = "big-promo")
    public WebElement promoBlock;

    @FindBy(css = "img[title='Ноутбуки с SSD']")
    public WebElement notebooksWithSSD;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);

    }

    public CatalogPage waitForPageLoading(){
        wait.until(ExpectedConditions.visibilityOf(promoBlock));
        return this;
    }

    public ProductListPage selectInCatalog(String s) {
        logger.info("select "+s);
        WebElement element = driver.findElement(By.cssSelector("img[title='" + s + "']"));
        element.click();
        return new ProductListPage(driver);
    }


}
