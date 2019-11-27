package cucumber.ui.stepDefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.ui.instruments.Browser;
import cucumber.ui.instruments.Screen;
import org.openqa.selenium.WebDriver;

public class Hooks {
    Scenario scenario;
    String scenarioName;
    String featureName;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        scenarioName = Preparing.getScenarioName(scenario);
        featureName = Preparing.getFeatureName(scenario);
        Preparing.deleteOldScreenshots();

    }


    @After
    public void close() {
        WebDriver driver = Browser.getInstance().getDriver();

        if (scenario.isFailed()) {
            Screen screen = new Screen(driver);
            screen.setPath(featureName, scenarioName);
            screen.get();
        }
        driver.quit();
    }


}

