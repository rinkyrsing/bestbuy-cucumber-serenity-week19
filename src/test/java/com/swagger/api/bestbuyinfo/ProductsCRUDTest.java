package com.swagger.api.bestbuyinfo;

import com.swagger.api.constants.EndPoints;
import com.swagger.api.model.ProductsPojo;
import com.swagger.api.testbase.TestBase;
import com.swagger.api.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class ProductsCRUDTest extends TestBase {

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

 @Steps
  ProductsSteps productsSteps;

 @Title("This will create new product")
@Test
 public void test001(){
     ValidatableResponse response = productsSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image );
     response.log().all().statusCode(201);
     productID = response.log().all().extract().path("id");
     System.out.println(productID);
 }
@Title("Verify if the product was added to the application")
 @Test
 public void test002(){
    HashMap<String, ?> productMap = productsSteps.getProductInfoByName(productID);
    Assert.assertThat(productMap, hasValue(name));
    System.out.println(productMap);
 }
 @Title("Update product id ")
 @Test
 public void test003(){
     name = name + "_updateName";
     productsSteps.updateProduct(productID, name, type, price, shipping, upc, description, manufacturer, model, url, image);
     HashMap<String, ?> productMap = productsSteps.getProductInfoByName(productID);
     Assert.assertThat(productMap, hasValue(name));
     System.out.println(productMap);
 }
@Title("Delete the product by ID")
@Test
 public void test004(){
     productsSteps.deleteProduct(productID).statusCode(200);
     productsSteps.getProductById(productID).statusCode(404);
}

}