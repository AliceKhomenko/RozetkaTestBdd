package cucumber.ui.stepDefs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage {
    final WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="big-promo")
    public WebElement promoBlock;

    @FindBy(css = "img[title='Ноутбуки с SSD']")
    public WebElement notebooksWithSSD;

    public CatalogPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(promoBlock));
    }

    public ProductListPage selectInCatalog(String s){
        WebElement element = driver.findElement(By.cssSelector("img[title='"+s+"']"));
        element.click();
       return new ProductListPage(driver);
    }



}
