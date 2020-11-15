package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static utils.UtilConstants.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

public class CircuitsApiStepDefs {

    // Add class level private variables here
    String ReqURI;
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    //region private functions
    //endregion

    //region @Given

    @Given("I want to know the number of Formula One races in {int}")
    public void set_season(Integer season)
    {
        ReqURI = TEST_ENDPOINT_SUFFIX + season.toString() + "/circuits" + DEFAULT_RESPONSE_FORMAT;
        request = given().accept("application/json");
    }
    //endregion

    @Given("I want to set limit {int} with offset {int}")
    public void set_limit_and_offset(Integer limit, Integer offset)
    {
        request.queryParam("limit", limit);
        request.queryParam("offset", offset);
    }

    //region @When
    @When("I retrieve the circuit list for that season")
    public void i_request_current_weather(){
        request.log().all();
        response = request.when().get(ReqURI);
    }
    //endregion

    //region @Then
    @Then("there should be {int} circuits in the list returned")
    public void compare_circuits_count(Integer numberOfCircuits) throws Throwable {
        json = response.then().statusCode(200).log().all();
        json.body("MRData.total", containsString(numberOfCircuits.toString()));
    }
    //endregion
}