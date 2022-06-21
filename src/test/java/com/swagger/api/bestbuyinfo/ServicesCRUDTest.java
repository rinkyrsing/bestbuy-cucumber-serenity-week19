package com.swagger.api.bestbuyinfo;

import com.swagger.api.constants.EndPoints;
import com.swagger.api.model.ServicesPojo;
import com.swagger.api.testbase.TestBase;
import com.swagger.api.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import static org.hamcrest.Matchers.hasValue;

public class ServicesCRUDTest extends TestBase {

//    static String name = "Best Buy For Business" + TestUtils.getRandomValue();
//    static int serviceID;
//
//    @Title("This will get list of services")
//    @Test
//    public void getAllServices() {
//        SerenityRest.given()
//                .when()
//                .contentType(ContentType.JSON)
//                .get(EndPoints.GET_ALL_SERVICES)
//                .then()
//                .log()
//                .all()
//                .statusCode(200);
//    }
//
//    @Title("Creating services with name: {0}")
//    @Test
//    public void creatService01() {
//        ServicesPojo servicesPojo = new ServicesPojo();
//        servicesPojo.setName(name);
//
//        SerenityRest.given().log().all()
//                .contentType(ContentType.JSON)
//                .body(servicesPojo)
//                .when()
//                .post(EndPoints.CREATE_SERVICE)
//                .then().log().all()
//                .statusCode(201);
//
//    }
//
//    @Title("Verify if the services was added to the application")
//    @Test
//    public void verifyServiceAdd() {
//
//        HashMap<String, Object> serviceMap = SerenityRest.given().log().all()
//                .when()
//                .pathParam("serviceID", serviceID)
//                .get(EndPoints.GET_SINGLE_SERVICE)
//                .then()
//                .statusCode(200)
//                .extract().path("");
//        Assert.assertThat(serviceMap, hasValue(name));
//        serviceID = (int) serviceMap.get("id");
//        System.out.println(serviceID);
//    }
//
//    @Title("This will update servive name: {0}")
//    @Test
//    public void updateServiceByName() {
//
//        ServicesPojo servicesPojo = new ServicesPojo();
//        servicesPojo.setName(name);
//
//        SerenityRest.given().log().all()
//                .contentType(ContentType.JSON)
//                .body(servicesPojo)
//                .pathParam("serviceID", serviceID)
//                .when()
//                .patch(EndPoints.UPDATE_SERVICES)
//                .then();
//    }
//
//@Title("This will Delete service with Id {0}")
//@Test
// public void deleteServiceId() {
//        SerenityRest.given().log().all()
//                .pathParam("serviceID", serviceID)
//                .when()
//                .delete(EndPoints.DELETE_SERVICES)
//                .then()
//                .statusCode(200);
//    }
//@Title("This will get service by id{0}")
//@Test
// public void getServiceById(){
//    SerenityRest.given().log().all()
//            .contentType(ContentType.JSON)
//            .pathParam("serviceID",serviceID)
//            .when()
//            .get(EndPoints.GET_SINGLE_SERVICE)
//            .then()
//            .statusCode(404);
//
//}
}
