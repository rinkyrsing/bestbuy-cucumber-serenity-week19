package com.swagger.api.bestbuyinfo;

import com.swagger.api.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UtilitiesCRUTest extends TestBase {


    @Steps
    UtilitiesSteps utilitiesSteps;

@Title("Creating utilities version ")
@Test
public void test001(){
    ValidatableResponse response = utilitiesSteps.getVersion();
       response.log().all().statusCode(200);

}
    @Title("Get the Health check of Application")
    @Test
    public void test002(){
        ValidatableResponse response = utilitiesSteps.getHealthCheck();
        response.log().all().statusCode(200);

    }
}
