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

import java.util.List;

public class ProductListPage {
    final WebDriver driver;
    WebDriverWait wait;

    private static final Logger logger
            = LoggerFactory.getLogger(ProductListPage.class);

    @FindBy(css = ".g-i-tile.g-i-tile-catalog")
    public List<WebElement> products;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);

    }

    public void addToCompareList(int i) {
        logger.info("user add "+i+" product to compare list");

        Actions actions = new Actions(driver);
        WebElement element;
        List<WebElement> addedToCompare = driver.findElements(By.xpath("//img[contains(@alt,'Добавлено')]"));
        element = products.get(i - 1);
        actions.moveToElement(element).build().perform();
        wait.until(ExpectedConditions.visibilityOf(element.findElement(By.cssSelector("div.short-description"))));

        element.findElement(By.cssSelector("img.sprite.g-compare-icon")).click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[contains(@alt,'Добавлено')]"), addedToCompare.size()));
    }
}
