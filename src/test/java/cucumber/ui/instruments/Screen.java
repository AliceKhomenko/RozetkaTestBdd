package cucumber.ui.instruments;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;

public class Screen{
    String feature;
    String scenario;
    WebDriver driver;

    public Screen(WebDriver driver){
        this.driver=driver;
    }

    public void setPath(String feature,String scenario){
        this.feature=feature;
        this.scenario= scenario;

    }
    public void get(){
     try {


        File directory = new File("Screenshots/");
        if (!directory.exists())
            directory.mkdir();
        File featureDirectory = new File("Screenshots/" + feature + "/");
        if (!featureDirectory.exists())
            featureDirectory.mkdir();

        for (File f : featureDirectory.listFiles()) {
            if (f.getName().startsWith(scenario)) {
                f.delete();
            }
        }
        Screenshot screen1 = new AShot().takeScreenshot(driver);

        ImageIO.write(screen1.getImage(), "PNG", new File("Screenshots/" + feature + "/" + scenario + ".png"));
    } catch (Exception e) {
         Browser.getInstance().testFailed(e.toString());
    }

}
}
