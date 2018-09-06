package chisw.appmanager;

import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void openWebsite(String link) {
        driver.get(link);
    }



}
