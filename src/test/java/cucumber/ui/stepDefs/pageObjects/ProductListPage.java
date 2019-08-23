package cucumber.ui.stepDefs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductListPage {
    final WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".g-i-tile.g-i-tile-catalog")
    public List<WebElement> products;
    public ProductListPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver,20);

    }

    public void addToCompareList(int i){
        Actions actions = new Actions(driver);
        WebElement element;
        List<WebElement> addedToCompare=driver.findElements(By.xpath("//img[contains(@alt,'Добавлено')]"));
        System.out.println("added: "+addedToCompare);

        System.out.println("size:"+products.size());
        element = products.get(i-1);

            actions.moveToElement(element).build().perform();
            wait.until(ExpectedConditions.visibilityOf(element.findElement(By.cssSelector("div.short-description"))));

        element.findElement(By.cssSelector("img.sprite.g-compare-icon")).click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[contains(@alt,'Добавлено')]"),addedToCompare.size()));
    }
}
