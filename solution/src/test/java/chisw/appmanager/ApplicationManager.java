package chisw.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class  ApplicationManager {

    WebDriver driver;
    private String browser;
    private MainPageHelper mainPage;
    private ResultPageHelper resultPage;
    private NavigationHelper navigationHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {

        if (browser.equals(BrowserType.FIREFOX)) {
            FirefoxOptions options = new FirefoxOptions();
            options.setCapability("locationContextEnabled", "false");
            driver = new FirefoxDriver(options);
        } else if (browser.equals(BrowserType.CHROME)) {
            ChromeOptions options = new ChromeOptions();
            options.setCapability("unexpectedAlertBehaviour", "dismiss");
            driver = new ChromeDriver(options);
        } else if (browser.equals(BrowserType.EDGE)) {
            EdgeOptions options = new EdgeOptions();
            options.setCapability("unexpectedAlertBehaviour", "dismiss");
            driver = new EdgeDriver(options);
        }
        mainPage = new MainPageHelper(driver);
        resultPage = new ResultPageHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        //driver.manage().window().maximize();
    }

    public void stop() {
        driver.quit();
    }

    public MainPageHelper getMainPage() {
        return mainPage;
    }

    public ResultPageHelper getResultPage() {
        return resultPage;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
}
