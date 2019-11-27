package cucumber.ui.stepDefs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Header {
    final WebDriver driver;
    WebDriverWait wait;
    private static final Logger logger
            = LoggerFactory.getLogger(Header.class);


    @FindBy(id = "comparison")
    private WebElement compareIcon;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public CompareListsPage clickCompareElement() {
        logger.info("click compare icon in header");

        compareIcon.click();
        return new CompareListsPage(driver);


    }
}
