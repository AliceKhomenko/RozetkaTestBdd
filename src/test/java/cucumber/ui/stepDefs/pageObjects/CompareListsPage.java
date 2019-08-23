package cucumber.ui.stepDefs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareListsPage {
    final WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="//*[contains(text(),'Сравнить эти товары')]")
    public WebElement compareButton;


    public CompareListsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,20);
    }

    public CompareDetailsPage clickCompareButton(){
        compareButton.click();
        return new CompareDetailsPage(driver);

    }
}
