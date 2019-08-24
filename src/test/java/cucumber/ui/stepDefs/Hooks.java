package cucumber.ui.stepDefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.ui.instruments.Browser;
import cucumber.ui.instruments.Screen;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Hooks {
    Scenario scenario;
    String scenarioName;
    String featureName;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        scenarioName = getScenarioName(scenario);
        featureName = getFeatureName(scenario);
        deleteOldScreenshots();

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

    public String getFeatureName(Scenario scenario) {
        return scenario.getUri()
                .replaceAll("src/test/java/cucumber/ui/features/", "")
                .replaceAll(".feature", "");
    }

    public String getScenarioName(Scenario scenario) {
        return scenario.getName();
    }

    private void deleteOldScreenshots() {
        try {
            File featureDirectory = new File("Screenshots/" + featureName + "/");
            if (featureDirectory.exists()) {

                for (File f : featureDirectory.listFiles()) {
                    if (f.getName().startsWith(scenarioName))
                        f.delete();

                }
                if (featureDirectory.listFiles().length == 0)
                    featureDirectory.delete();
            }
        } catch (Exception e) {
            Browser.getInstance().testFailed(e.toString());

        }
    }

}

