package com.swagger.api.steps;

import com.swagger.api.bestbuyinfo.ServicesSteps;
import com.swagger.api.utils.TestUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class ServiceSteps {
    static String name = "Best Buy For Business" + TestUtils.getRandomValue();
    static int serviceID;
    static ValidatableResponse response;

    @Steps
    ServicesSteps servicesSteps;

    @Given("^I am on homepage of services$")
    public void iAmOnHomepageOfServices() {

    }

    @When("^I send a GET request to the services endpoint$")
    public void iSendAGETRequestToTheServicesEndpoint() {

        response = servicesSteps.getAllService().statusCode(200);
    }

    @Then("^I should get a valid response code (\\d+) from services endpoint$")
    public void iShouldGetAValidResponseCodeFromServicesEndpoint(int statusCode) {
        response.assertThat().statusCode(statusCode);
    }

    @When("^I send a POST request with a valid payload to the services endpoint$")
    public void iSendAPOSTRequestWithAValidPayloadToTheServicesEndpoint() {
        response = servicesSteps.createServicesByName(name);
        response.log().all().statusCode(201);
        serviceID = response.log().all().extract().path("id");
        System.out.println(serviceID);
    }

    @When("^I send a GET request to newly created services with product ID$")
    public void iSendAGETRequestToNewlyCreatedServicesWithProductID() {
        HashMap<String, ?> storeMap = servicesSteps.getServiceInfoByName(serviceID);
        Assert.assertThat(storeMap, hasValue(name));
    }

    @Then("^I verify if the services is services with correct details$")
    public void iVerifyIfTheServicesIsServicesWithCorrectDetails() {
        HashMap<String, ?> storeMap = servicesSteps.getServiceInfoByName(serviceID);
        Assert.assertThat(storeMap, hasValue(name));
    }

    @When("^I send a PUT request to newly created services with product ID$")
    public void iSendAPUTRequestToNewlyCreatedServicesWithProductID() {
        name = name + "_updated";
        HashMap<Object, Object> servicesData = new HashMap<>();
        servicesSteps.updateServices(serviceID,name);

    }
    @Then("^I verify if the services details is updated with correct details$")
    public void iVerifyIfTheServicesDetailsIsUpdatedWithCorrectDetails() {
        HashMap<String, ?> productList = servicesSteps.getServiceInfoByName(serviceID);
        Assert.assertThat(productList, hasValue(name));
        System.out.println(productList);
    }

    @When("^I send a DELETE request to newly created services with product ID$")
    public void iSendADELETERequestToNewlyCreatedServicesWithProductID() {
        servicesSteps.deleteService(serviceID).statusCode(200);
    }

    @Then("^I verify if the services is deleted$")
    public void iVerifyIfTheServicesIsDeleted() {
        servicesSteps.getService(serviceID).statusCode(404);

    }
    }

