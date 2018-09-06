package chisw.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHelper {

    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(WebElement element, String text) {
        click(element);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        element.click();
    }


}
