package chisw.test;

import com.jayway.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.when;


public class TestRestAssured extends TestBase {

    @Test
    public void checkApiStatusQode() {
        when()
                .get("http://restcountries.eu/rest/v1/name/ukraine")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void checkApiPageContent() {
        ValidatableResponse response = when()
                .get("http://restcountries.eu/rest/v1/name/ukraine")
                .then();
        Assert.assertEquals(response
                .extract()
                .body()
                .jsonPath()
                .getString("region"), "[Europe]");
    }
}
