package com.swagger.api.steps;

import com.swagger.api.bestbuyinfo.UtilitiesSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class UtilitieSteps {

    static ValidatableResponse response;

    @Steps
    UtilitiesSteps utilitiesSteps;

    @Given("^I am on homepage of utilities endpoint$")
    public void iAmOnHomepageOfUtilitiesEndpoint() {

    }

    @When("^I send a GET request to check version of the utilities endpoint$")
    public void iSendAGETRequestToCheckVersionOfTheUtilitiesEndpoint() {
        response = utilitiesSteps.getVersion().statusCode(200);
    }

    @Then("^I must get a valid response code (\\d+) from utilities endpoint$")
    public void iMustGetAValidResponseCodeFromUtilitiesEndpoint(int statusCode) {
        response.assertThat().statusCode(statusCode);
    }

    @When("^I send a GET request to check health of the utilities endpoint$")
    public void iSendAGETRequestToCheckHealthOfTheUtilitiesEndpoint() {
        response = utilitiesSteps.getHealthCheck().statusCode(200);
    }
}
