package chisw.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ResultPageHelper extends BaseHelper {

    public ResultPageHelper(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "cite.iUh30")
    private List<WebElement> resultLinks;

    public List<String> getSearchResultsList() {
        List<String> results = new ArrayList<>();
        List<WebElement> links = resultLinks;
        for (WebElement link : links) {
            String text = link.getText();
            results.add(text);
        }
        return results;
    }
}
