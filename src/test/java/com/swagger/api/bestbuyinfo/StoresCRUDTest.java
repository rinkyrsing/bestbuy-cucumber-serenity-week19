package com.swagger.api.bestbuyinfo;

import com.swagger.api.constants.EndPoints;
import com.swagger.api.model.StoresPojo;
import com.swagger.api.testbase.TestBase;
import com.swagger.api.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.HashMap;
import static org.hamcrest.Matchers.hasValue;



public class StoresCRUDTest extends TestBase {
//
//    static String name = "Yogurt" + TestUtils.getRandomValue();
//    static String type = "Dairy" + TestUtils.getRandomValue();
//    static String address = "xxyz";
//    static String address2 = "aabc";
//    static String city = "London";
//    static String state = "landon";
//    static String zip = "1111";
//    static int lat = 14;
//    static int lng = 50;
//    static String hours = "11.11";
//    static HashMap<Object, Object> servicesData;
//
//    static int storeID;
//
////    @Title("This will get list of stores")
////    @Test
////    public void getAllStores() {
////        SerenityRest.given()
////                .when()
////                .contentType(ContentType.JSON)
////                .get(EndPoints.GET_ALL_STORES)
////                .then()
////                .log()
////                .all()
////                .statusCode(200);
////    }
//
//    @Title("This will create new list into stores")
//    @Test
//    public void createStores() {
//
//        StoresPojo storesPojo = new StoresPojo();
//        storesPojo.setName(name);
//        storesPojo.setType(type);
//        storesPojo.setAddress(address);
//        storesPojo.setAddress2(address2);
//        storesPojo.setCity(city);
//        storesPojo.setState(state);
//        storesPojo.setZip(zip);
//        storesPojo.setLat(lat);
//        storesPojo.setLng(lng);
//        storesPojo.setHours(hours);
//        storesPojo.setServices(servicesData);
//
//        SerenityRest.given().log().all()
//                .contentType(ContentType.JSON)
//                .body(storesPojo)
//                .when()
//                .post()
//                .then().log().all().statusCode(201);
//    }
//
//    @Title("Verify if the stores was added to the application")
//    @Test
//    public void getStoreInfoById() {
//
//        HashMap<String, Object> storeMap = SerenityRest.given().log().all()
//                .when()
//                .get(EndPoints.GET_SINGLE_STORES_ID)
//                .then()
//                .statusCode(200)
//                .extract()
//                .path("");
//        Assert.assertThat(storeMap, hasValue(name));
//        storeID = (int) storeMap.get("id");
//        System.out.println(storeMap);
//    }
//
//    @Title("Update the store information and verify the updated information")
//    @Test
//    public void test003() {
//
//        name = name + "_updated";
//
//        StoresPojo storesPojo = new StoresPojo();
//        storesPojo.setName(name);
//        storesPojo.setType(type);
//        storesPojo.setAddress(address);
//        storesPojo.setAddress2(address2);
//        storesPojo.setCity(city);
//        storesPojo.setState(state);
//        storesPojo.setZip(zip);
//        storesPojo.setLat(lat);
//        storesPojo.setLng(lng);
//        storesPojo.setHours(hours);
//
//        SerenityRest.given().log().all()
//                .contentType(ContentType.JSON)
//                .body(storesPojo)
//                .when()
//                .put(EndPoints.UPDATE_STORES_BY_ID)
//                .then().log().all().statusCode(200);
// }
//    @Title("Delete the store and verify if that store is deleted!")
//    @Test
//    public void test004(){
//        SerenityRest.given().log().all()
//                .pathParam("studentID", storeID)
//                .when()
//                .delete(EndPoints.DELETE_STORES_BY_ID)
//                .then().statusCode(204);
//
//        SerenityRest.given().log().all()
//                .pathParam("studentID", storeID)
//                .when()
//                .get(EndPoints.GET_SINGLE_STORES_ID)
//                .then()
//                .statusCode(404);
//
//
//}
}