package chisw.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPageHelper extends BaseHelper {

    @FindBy(how = How.NAME, using = "q")
    private WebElement inputField;

    @FindBy(how = How.NAME, using = "btnK")
    private WebElement enterBtn;


    public MainPageHelper(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillSearchRequest(String text) {
        type(inputField, text);
        inputField.sendKeys(Keys.ENTER);
    }

}
