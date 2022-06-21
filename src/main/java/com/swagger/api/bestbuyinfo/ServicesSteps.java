package com.swagger.api.bestbuyinfo;

import com.swagger.api.constants.EndPoints;
import com.swagger.api.model.ServicesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ServicesSteps  {

@Step("This will create services by name: {0}}")
public ValidatableResponse createServicesByName(String name){
    ServicesPojo servicesPojo = new ServicesPojo();
    servicesPojo.setName(name);
       return SerenityRest.given().log().all()
               .contentType(ContentType.JSON)
               .body(servicesPojo)
               .when()
               .post(EndPoints.CREATE_SERVICE)
               .then();
}
@Step("Getting the Services information with ID: {0}")
public HashMap<String, Object> getServiceInfoByName(int serviceID){
    HashMap<String, Object> serviceMap = SerenityRest.given().log().all()
            .when()
            .pathParam("serviceID",serviceID)
            .get(EndPoints.GET_SINGLE_SERVICE)
            .then()
            .statusCode(200)
            .extract().path("");
    return serviceMap;

}
@Step("Updating service by name: {0}")
    public ValidatableResponse updateServices(int serviceID, String name){
    ServicesPojo servicesPojo = new ServicesPojo();
    servicesPojo.setName(name);

    return SerenityRest.given().log().all()
            .contentType(ContentType.JSON)
            .body(servicesPojo)
            .pathParam("serviceID", serviceID)
            .when()
            .patch(EndPoints.UPDATE_SERVICES)
            .then();
}
@Step("Delete service with Id {0}")
    public ValidatableResponse deleteService(int serviceID) {
        return SerenityRest.given().log().all()
                .pathParam("serviceID", serviceID)
                .when()
                .delete(EndPoints.DELETE_SERVICES)
                .then();
    }
@Step("Getting service by Id: {0}")
    public ValidatableResponse getService(int serviceID){

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("serviceID",serviceID)
                .when()
                .get(EndPoints.GET_SINGLE_SERVICE)
                .then();
}
    @Step("Getting All Services ")
    public ValidatableResponse getAllService(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_SERVICES)
                .then();
    }

}
