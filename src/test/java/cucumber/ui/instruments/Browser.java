package cucumber.ui.instruments;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static Browser instance;
    Properties prop = new Properties();
    protected WebDriver driver;

    private Browser(){}
    public static Browser getInstance(){
        if(instance == null){		//если объект еще не создан
            instance = new Browser();
    }
    return instance;
    }

    public WebDriver init(String browserName) {
        OSDetector();
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = initChrome();
                break;
            case "firefox":
            case "mozilla":
            case "mozilla firefox"://to dd
                break;
            default:
                testFailed("Sorry, your browser is unsupported");


        }
        return driver;
    }


    private WebDriver initChrome() {
        WebDriver driver = null;
        try {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver.path"));
            ChromeOptions options = new ChromeOptions();
           //options.addArguments("headless");
            options.addArguments("window-size=1920,1080");
            driver = new ChromeDriver(options);
            //driver.manage().window().setSize(new Dimension(1366, 768));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            testFailed(e.toString());
        }
        return driver;
    }

    public void testFailed(String s) {
        System.out.println(s);
        Assert.fail();
    }

    public void OSDetector() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            InputStream input;


            if (os.contains("win")) {
                input = new FileInputStream("src/test/resources/windows.properties");
                prop.load(input);
            } else if (os.contains("nux") || os.contains("nix") || (os.contains("centos")) || (os.contains("ubuntu"))) {
                input = new FileInputStream("src/test/resources/linux.properties");
                prop.load(input);
            } else {
                System.out.println("Sorry, your OS is unsupported");
                Assert.fail();
            }
        } catch (Exception e) {
            testFailed(e.toString());
        }

    }


    public WebDriver getDriver() {
        return this.driver;
    }
}
