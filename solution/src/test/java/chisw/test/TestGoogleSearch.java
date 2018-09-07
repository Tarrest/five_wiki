package chisw.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;


public class TestGoogleSearch extends TestBase {

    @DataProvider(name = "wiki")
    public static Object[][] dataSet() {
        return new Object[][] {
                {"citrus"},
                {"madonna"},
                {"picasso"}
        };
    }

    @Test(dataProvider = "wiki")
    public void checkGoogleSearch(String searchQuery) {
        app.goTo().openWebsite("http://www.google.com.ua");
        app.getMainPage().fillSearchRequest(searchQuery);
        List<String> results = app.getResultPage().getSearchResultsList();
        Assert.assertTrue(results.toString().contains("wikipedia.org"), "wikipedia.org не содерджится в первой 5ке");
    }

}
