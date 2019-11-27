package cucumber.ui.stepDefs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompareListsPage {
    final WebDriver driver;
    private WebDriverWait wait;

    private static final Logger logger
            = LoggerFactory.getLogger(CompareListsPage.class);

    @FindBy(xpath = "//*[contains(text(),'Сравнить эти товары')]")
    public WebElement compareButton;


    public CompareListsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public CompareDetailsPage clickCompareButton() {
        logger.info("click compare button for first products");

        compareButton.click();
        return new CompareDetailsPage(driver);

    }
}
