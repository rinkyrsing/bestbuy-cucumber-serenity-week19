package com.swagger.api.steps;

import com.swagger.api.bestbuyinfo.ProductsSteps;
import com.swagger.api.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.collection.IsMapContaining.hasValue;

public class ProductSteps {

    static String name = "Practice-Energizer" + TestUtils.getRandomValue();
    static String type = "HardGood" + TestUtils.getRandomValue();
    static Integer price = 5;
    static Integer shipping = 15;
    static String upc = "012562165141";
    static String description = "Alkaline batteries; 1.5V";
    static String manufacturer = "Energizer";
    static String model = "E91BP-4";
    static String url = "learningSchool@gmail.com";
    static String image = "learningSchool@gmail.com/image";
    static int productID;
    static ValidatableResponse response;

    @Steps
    ProductsSteps productsSteps;

    @Given("^I am on homepage of products$")
    public void iAmOnHomepageOfProducts() {
    }

    @When("^I send a GET request to the products endpoint$")
    public void iSendAGETRequestToTheProductsEndpoint() {
        response = productsSteps.getAllProduct();
        response.statusCode(200);
    }

    @Then("^I should get a valid response code (\\d+) from products endpoint$")
    public void iShouldGetAValidResponseCodeFromProductsEndpoint(int statusCode) {
        response.statusCode(statusCode);
        response.assertThat().statusCode(statusCode);
    }

    @When("^I send a POST request with a valid payload to the products endpoint$")
    public void iSendAPOSTRequestWithAValidPayloadToTheProductsEndpoint() {
        response = productsSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image);
        response.log().all().extract().path("id");
        System.out.println(productID);
    }

    @When("^I send a GET request to newly created product with product ID$")
    public void iSendAGETRequestToNewlyCreatedProductWithProductID() {
        HashMap<String, ?> prodMap = productsSteps.getProductInfoByName(productID);
        Assert.assertThat(prodMap, hasValue(name));
        System.out.println(prodMap);
    }

    @Then("^I verify if the product is created with correct details$")
    public void iVerifyIfTheProductIsCreatedWithCorrectDetails() {
        HashMap<String, ?> prodMap = productsSteps.getProductInfoByName(productID);
        Assert.assertThat(prodMap, Matchers.hasValue(name));
        Assert.assertThat(prodMap, Matchers.hasValue(type));
        System.out.println(prodMap);
    }

    @When("^I send a PUT request to newly created product with product ID$")
    public void iSendAPUTRequestToNewlyCreatedProductWithProductID() {
        name = name + "_updated";
        productsSteps.updateProduct(productID, name, type, price, shipping, upc, description, manufacturer, model, url, image);
    }

    @Then("^I verify if the product details is updated with correct details$")
    public void iVerifyIfTheProductDetailsIsUpdatedWithCorrectDetails() {
        HashMap<String, ?> productMap = productsSteps.getProductInfoByName(productID);
        Assert.assertThat(productMap, Matchers.hasValue(name));
        System.out.println(productMap);
    }

    @When("^I send a DELETE request to newly created product with product ID$")
    public void iSendADELETERequestToNewlyCreatedProductWithProductID() {
        productsSteps.deleteProduct(productID).statusCode(200);
    }

    @Then("^I verify if the product is deleted$")
    public void iVerifyIfTheProductIsDeleted() {
        productsSteps.getProductById(productID).statusCode(404);

    }

    @Given("^I am on homepage of products endpoint$")
    public void iAmOnHomepageOfProductsEndpoint() {
    }

    @Then("^I must get a valid response code (\\d+) from products endpoint$")
    public void iMustGetAValidResponseCodeFromProductsEndpoint(int arg0) {
    }
}
