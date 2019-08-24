package cucumber.ui.stepDefs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
    final WebDriver driver;
    WebDriverWait wait;


    @FindBy(id = "comparison")
    private WebElement compareIcon;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public CompareListsPage clickCompareElement() {
        compareIcon.click();
        return new CompareListsPage(driver);


    }
}
