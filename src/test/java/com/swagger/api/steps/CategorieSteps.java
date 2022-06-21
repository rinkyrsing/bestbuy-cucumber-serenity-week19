package com.swagger.api.steps;

import com.swagger.api.bestbuyinfo.CategoriesSteps;
import com.swagger.api.utils.TestUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class CategorieSteps {

    static String name = "Amy" + TestUtils.getRandomValue();
    static String id = "0007" + TestUtils.getRandomValue();
    static String categoriesId;
    static ValidatableResponse response;

    @Steps
    CategoriesSteps categoriesSteps;

    @Given("^I am on homepage of categories$")
    public void iAmOnHomepageOfCategories() {

    }

    @When("^I send a GET request to the categories endpoint$")
    public void iSendAGETRequestToTheCategoriesEndpoint() {
        response = categoriesSteps.getAllCategory().statusCode(200);
    }

    @Then("^I should get a valid response code (\\d+) from categories endpoint$")
    public void iShouldGetAValidResponseCodeFromCategoriesEndpoint(int statusCode) {
        response.assertThat().statusCode(statusCode);

    }

    @When("^I send a POST request with a valid payload to the categories endpoint$")
    public void iSendAPOSTRequestWithAValidPayloadToTheCategoriesEndpoint() {
        response = categoriesSteps.createCategories(name, id);
        response.log().all().statusCode(201);
        categoriesId = response.log().all().extract().path("id");
    }

    @When("^I send a GET request to newly created categories with product ID$")
    public void iSendAGETRequestToNewlyCreatedCategoriesWithProductID() {
        HashMap<String, ?> categoryMap = categoriesSteps.getCategoriesByName(categoriesId);
        Assert.assertThat(categoryMap, hasValue(name));
    }

    @Then("^I verify if the categories is created with correct details$")
    public void iVerifyIfTheCategoriesIsCreatedWithCorrectDetails() {
        HashMap<String, ?> categoryMap = categoriesSteps.getCategoriesByName(categoriesId);
        Assert.assertThat(categoryMap, hasValue(name));
        Assert.assertThat(categoryMap, hasValue(id));

    }

    @When("^I send a PUT request to newly created categories with product ID$")
    public void iSendAPUTRequestToNewlyCreatedCategoriesWithProductID() {
        name = name + "_updated";
        categoriesSteps.updateInfoByName(categoriesId, name, id);
    }

    @Then("^I verify if the categories details is updated with correct details$")
    public void iVerifyIfTheCategoriesDetailsIsUpdatedWithCorrectDetails() {
        HashMap<String, ?> productList = categoriesSteps.getCategoriesByName(categoriesId);
        Assert.assertThat(productList, hasValue(name));
    }

    @When("^I send a DELETE request to newly created categories with product ID$")
    public void iSendADELETERequestToNewlyCreatedCategoriesWithProductID() {
        categoriesSteps.deleteCategoriesId(categoriesId).statusCode(200);
    }

    @Then("^I verify if the categories is deleted$")
    public void iVerifyIfTheCategoriesIsDeleted() {
        categoriesSteps.getDeleteCategoriesId(categoriesId).statusCode(404);
    }
}
