package com.swagger.api.bestbuyinfo;

import com.swagger.api.testbase.TestBase;
import com.swagger.api.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class ServicesCRUDTestWithSteps extends TestBase {

    static String name = "Best Buy For Business" + TestUtils.getRandomValue();
    static int serviceID;

    @Steps
       ServicesSteps servicesSteps;

 @Title("This will create a New Service")
 @Test
    public void test001(){
     ValidatableResponse response = servicesSteps.createServicesByName(name);
     response.log().all().statusCode(201);
     serviceID = response.log().all().extract().path("id");
     System.out.println(serviceID);
 }

 @Title("Verify if the Product was added to the application")
 @Test
    public void test002(){
     HashMap<String, ?> serviceMap = servicesSteps.getServiceInfoByName(serviceID);
     Assert.assertThat(serviceMap, hasValue(name));
     System.out.println(serviceMap);
 }
@Title("Update the product information")
@Test
  public void test003(){
     name = name + "_updated";
     HashMap<String, ?> createMap = new HashMap<>();
     servicesSteps.updateServices(serviceID,name);
     HashMap<String, ?> serviceMap = servicesSteps.getServiceInfoByName(serviceID);
    Assert.assertThat(serviceMap, hasValue(name));
    System.out.println(serviceMap);
 }
    @Title("Delete the product by ID")
    @Test
    public void test004() {
        servicesSteps.deleteService(serviceID).statusCode(200);
        servicesSteps.getService(serviceID).statusCode(404);
    }


}
