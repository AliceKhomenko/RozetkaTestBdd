package cucumber.ui.stepDefs.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CompareDetailsPage {
    private final WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".comparison-t-row")
    public List<WebElement> rows;

    @FindBy(name = "different")
    public List<WebElement> diffRows;

    @FindBy(css = "a[href='#only-different']")
    public WebElement differencesTab;

    public CompareDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public int getDiffrentRows() {
        List<WebElement> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int differentRows = 0;
        for (int i = 0; i < rows.size(); i++) {
            set.clear();
            list.clear();
            if (i == 0) rows.get(0).findElements(By.cssSelector("span.safe-merchant-label-title"));
            else list = rows.get(i).findElements(By.cssSelector("span.chars-value-inner"));
            for (int j = 0; j < list.size(); j++)
                set.add(list.get(j).getText());
            if (set.size() > 1) differentRows += 1;
        }
        return differentRows;
    }


    public void clickDifferentTab() {
        differencesTab.click();
    }

    public int checkOnlyDifferenrRows() {
        int count = 0;
        for (WebElement el : rows) {
            if (el.isDisplayed()) count++;
        }
        return count;
    }
}
