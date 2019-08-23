package cucumber.ui.stepDefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.ui.instruments.Browser;
import cucumber.ui.instruments.Screen;

public class Hooks extends Browser{
    Scenario scenario;
@Before
    public void setUp(Scenario scenario){
    this.scenario=scenario;
    System.out.println("start");

}

@After
    public void close(){
    System.out.println("finish");

    if(driver==null)
    System.out.println("Driver is null");
        if (scenario.isFailed())
        {
            Screen screen = new Screen(driver);
            screen.setPath("test","testik");
            screen.get();
        }
        driver.quit();
}


}

