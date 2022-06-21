package com.swagger.api.bestbuyinfo;


import com.swagger.api.constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UtilitiesSteps {

@Step("Getting version")
    public ValidatableResponse getVersion(){

    return SerenityRest.given().log().all()
            .contentType(ContentType.JSON)
            .when()
            .get(EndPoints.CREATE_UTILITIES_VERSION)
            .then();
}
    @Step("Getting health check")
    public ValidatableResponse getHealthCheck() {

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get(EndPoints.CREATE_UTILITIES_HEALTHCHECK)
                .then();
    }

}
