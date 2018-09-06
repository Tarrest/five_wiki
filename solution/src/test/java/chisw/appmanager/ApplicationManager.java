package chisw.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class ApplicationManager {

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
            System.setProperty("webdriver.gecko.driver", "c:\\Tools\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "c:\\Tools\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            System.setProperty("webdriver.edge.driver", "c:\\Tools\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }
        mainPage = new MainPageHelper(driver);
        resultPage = new ResultPageHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        driver.manage().window().maximize();
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
