package cucumber.ui.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty","json:target/report/cucumber2.json"},
        strict = true,
        features = {"src/test/java/cucumber/ui/features/RozetkaTest.feature"},
        glue = {"cucumber.ui.stepDefs"},
        monochrome=true

)



@Test
public class RozetkaTest  extends AbstractTestNGCucumberTests {
}
