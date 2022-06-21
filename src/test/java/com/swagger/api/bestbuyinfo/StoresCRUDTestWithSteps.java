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
public class StoresCRUDTestWithSteps extends TestBase {

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
    static HashMap<Object, Object> servicesData = new HashMap<>();
    //static HashMap<Object, Object> services;

    static int storeID;

@Steps
 StoresSteps storesSteps;

@Title("This will create a new Stores")
@Test
public void test001(){

    ValidatableResponse response = storesSteps.creatingStoresByName(name, type, address, address2, city, state, zip, lat, lng, hours,servicesData);
    response.log().all().statusCode(201);
    storeID = response.log().all().extract().path("id");
    System.out.println(storeID);
}

 @Title("Verify if the store information was added into the application")
 @Test
    public void test002() {
        HashMap<String, ?> storeMap = storesSteps.getStoreInfoByName(storeID);
        Assert.assertThat(storeMap, hasValue(name));
        System.out.println(storeMap);
    }

 @Title("Update the product information")
 @Test
    public void test003() {
        name = name + "_updated";
        HashMap<Object, Object> servicesData = new HashMap<>();
        storesSteps.updateStore(storeID,name, type, address, address2, city, state, zip, lat, lng, hours,servicesData);
        HashMap<String, ?> productList = storesSteps.getStoreInfoByName(storeID);
        Assert.assertThat(productList, hasValue(name));
        System.out.println(productList);
    }

 @Title("Delete the product by ID")
 @Test
    public void test004() {
        storesSteps.deleteStore(storeID).statusCode(200);
        storesSteps.getStoreByID(storeID).statusCode(404);
    }
}
