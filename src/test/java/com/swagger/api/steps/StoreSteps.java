package com.swagger.api.steps;

import com.swagger.api.bestbuyinfo.StoresSteps;
import com.swagger.api.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasValue;

public class StoreSteps {
    static String name = "Yogurt" + TestUtils.getRandomValue();
    static String type = "Dairy" + TestUtils.getRandomValue();
    static String address = "xxyz";
    static String address2 = "aabc";
    static String city = "London";
    static String state = "landon";
    static String zip = "1111";
    static int lat = 14;
    static int lng = 50;
    static String hours = "1.00";

    static int storeID;
    static ValidatableResponse response;

    StoresSteps storesSteps;

    @Given("^I am on homepage of stores$")
    public void iAmOnHomepageOfStores() {

    }

    @When("^I send a GET request to the stores endpoint$")
    public void iSendAGETRequestToTheStoresEndpoint() {
        response = storesSteps.getAllStores().statusCode(200);
    }

    @Then("^I should get a valid response code (\\d+) from stores endpoint$")
    public void iShouldGetAValidResponseCodeFromStoresEndpoint(int statusCode) {
        response.statusCode(statusCode);
        response.assertThat().statusCode(statusCode);
    }

    @When("^I send a POST request with a valid payload to the stores endpoint$")
    public void iSendAPOSTRequestWithAValidPayloadToTheStoresEndpoint() {
        HashMap<Object, Object> servicesData = new HashMap<>();
        response = storesSteps.creatingStoresByName(name, type, address, address2, city, state, zip, lat, lng, hours, servicesData);
        response.log().all().statusCode(201);
        storeID = response.log().all().extract().path("id");
        System.out.println(storeID);
    }

    @When("^I send a GET request to newly created stores with product ID$")
    public void iSendAGETRequestToNewlyCreatedStoresWithProductID() {
        HashMap<Object, Object> storeList = new HashMap<>();
        response = storesSteps.creatingStoresByName(name, type, address, address2, city, state, zip, lat, lng, hours, storeList);
        response.log().all().statusCode(201);
        storeID = response.log().all().extract().path("id");
        System.out.println(storeID);
    }


    @Then("^I must get a valid response code (\\d+) from stores endpoint$")
    public void iMustGetAValidResponseCodeFromStoresEndpoint(int statusCode) {
        response.statusCode(statusCode);
        response.assertThat().statusCode(statusCode);
    }

    @When("^I send a GET request to newly created store with product ID$")
    public void iSendAGETRequestToNewlyCreatedStoreWithProductID() {
        HashMap<String, ?> storeMap = storesSteps.getStoreInfoByName(storeID);
    }

    @Then("^I verify if the store is created with correct details$")
    public void iVerifyIfTheStoreIsCreatedWithCorrectDetails() {
    }

    @When("^I send a PUT request to newly created store with product ID$")
    public void iSendAPUTRequestToNewlyCreatedStoreWithProductID() {
    }

    @Then("^I verify if the store details is updated with correct details$")
    public void iVerifyIfTheStoreDetailsIsUpdatedWithCorrectDetails() {
        HashMap<String, ?> storeMap = storesSteps.getStoreInfoByName(storeID);
        Assert.assertThat(storeMap, hasValue(name));
        Assert.assertThat(storeMap, hasValue(type));
        Assert.assertThat(storeMap, hasValue(city));
    }

    @When("^I send a DELETE request to newly created store with product ID$")
    public void iSendADELETERequestToNewlyCreatedStoreWithProductID() {
        storesSteps.deleteStore(storeID).statusCode(200);
    }

    @Then("^I verify if the store is deleted$")
    public void iVerifyIfTheStoreIsDeleted() {
        storesSteps.getStoreByID(storeID).statusCode(404);
    }

    @And("^I verify the if the total is equal to (\\d+)$")
    public void iVerifyTheIfTheTotalIsEqualTo(int expectedData) {
        response = storesSteps.getAllStores();
        int total = response.extract().path("total");
        Assert.assertEquals(expectedData, total);
    }

    @And("^I verify the if the stores of limit is equal to (\\d+)$")
    public void iVerifyTheIfTheStoresOfLimitIsEqualTo(int expectedDate) {
        response = storesSteps.getAllStores();
        int limit = response.extract().path("limit");
        Assert.assertEquals(expectedDate, limit);
    }

    @And("^I Check the single name \"([^\"]*)\"$")
    public void iCheckTheSingleName(String expectedText) {
        response = storesSteps.getAllStores();
        List<String> name = response.extract().path("data.name");
        Assert.assertThat(name, hasItem(expectedText));
    }

    @And("^I Check the multiple names \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iCheckTheMultipleNames(String name1, String name2, String name3) {
        response = storesSteps.getAllStores();
        List<String> names = response.extract().path("data.name");
        List<String> expectedNames = new ArrayList<>();
        expectedNames.add(name1);
        expectedNames.add(name2);
        expectedNames.add(name3);
        for (String data : expectedNames) {
            Assert.assertThat(names, hasItem(data));
        }
    }

    @And("^I Verify the storied (\\d+) inside storeservices of the third store of second services$")
    public void iVerifyTheStoriedInsideStoreservicesOfTheThirdStoreOfSecondServices(int expected) {
        response = storesSteps.getAllStores();
        int storeID = response.extract().path("data[2].services[1].storeservices.storeId");
        Assert.assertEquals(expected, storeID);
    }

    @And("^I Check hash map values createdAt inside storeservices map where store name is \"([^\"]*)\"$")
    public void iCheckHashMapValuesCreatedAtInsideStoreservicesMapWhereStoreNameIs(String expectedText) {
        response = storesSteps.getAllStores();
        List<String> createdAt = response.extract().path("data.findAll{it.name=='Roseville'}.services[0].storeservices.createdAt");

    }

    @And("^I Verify the state \"([^\"]*)\" of forth store$")
    public void iVerifyTheStateOfForthStore(String expected) {
        response = storesSteps.getAllStores();
        String stateName = response.extract().path("data[3].state");
        Assert.assertEquals(expected, stateName);
    }

    @And("^I Verify the store name \"([^\"]*)\" of ninth store$")
    public void iVerifyTheStoreNameOfNinthStore(String expectedText) {
        response = storesSteps.getAllStores();
        String storeName = response.extract().path("data[8].name");
        Assert.assertEquals(expectedText, storeName);
    }

    @And("^I Verify the storeId is (\\d+) for the sixth store$")
    public void iVerifyTheStoreIdIsForTheSixthStore(int expected) {
        response = storesSteps.getAllStores();
        List<Integer> storeIDSixthStore = response.extract().path("data[5].services.storeservices.storeId");
        for (int data : storeIDSixthStore) {
            Assert.assertEquals(expected, data);
        }
    }

    @Then("^Verify the serviceId is (\\d+) for the seventh store of forth service$")
    public void verifyTheServiceIdIsForTheSeventhStoreOfForthService(int expected) {
        response = storesSteps.getAllStores();
        int serviceID = response.extract().path("data[6].services[3].storeservices.serviceId");
        Assert.assertEquals(expected, serviceID);
    }
}
