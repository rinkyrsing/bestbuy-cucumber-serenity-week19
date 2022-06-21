package com.swagger.api.bestbuyinfo;

import com.swagger.api.constants.EndPoints;
import com.swagger.api.model.CategoriesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.HashMap;

import static net.serenitybdd.rest.SerenityRest.then;

public class CategoriesSteps {


@Step("Creating categories with name: {0}, Id: {0}")
 public ValidatableResponse createCategories(String name, String id){

      CategoriesPojo categoriesPojo = new CategoriesPojo();
      categoriesPojo.setName(name);
      categoriesPojo.setId(id);

   return SerenityRest.given().log().all()
            .contentType(ContentType.JSON)
            .body(categoriesPojo)
            .when()
            .post(EndPoints.CREATE_CATEGORIES)
            .then();
}
@Step("Get the categories information by id: {0}")
  public HashMap<String, ?> getCategoriesByName(String categoriesId){
    HashMap<String, ?> categoriesMap = SerenityRest.given().log().all()
            .when()
            .pathParams("categoriesID", categoriesId)
            .get(EndPoints.GET_SINGLE_CATEGORIES_ID)
            .then()
            .statusCode(200)
            .extract()
            .path("");

      return categoriesMap;
}
@Step("Updating the categories")
    public ValidatableResponse updateInfoByName(String name, String id, String categoriesId){

    CategoriesPojo categoriesPojo = new CategoriesPojo();
    categoriesPojo.setName(name);
    categoriesPojo.setName(id);

    return SerenityRest.given().log().all()
            .contentType(ContentType.JSON)
            .body(categoriesPojo)
            .pathParam("categoriesID",categoriesId)
            .when()
            .patch(EndPoints.UPDATE_CATEGORIES_BY_ID)
            .then();
}
@Step("Delete the created categories Id: {0}")
    public ValidatableResponse deleteCategoriesId(String categoriesId){
    return SerenityRest.given().log().all()
            .pathParam("categoriesID", categoriesId)
            .when()
            .delete(EndPoints.DELETE_CATEGORIES_BY_ID)
            .then();
}
@Step(" Get the Deleting Category with ID {0}")
    public ValidatableResponse getDeleteCategoriesId(String categoriesId){

    return SerenityRest.given().log().all()
            .pathParam("categoriesID",categoriesId)
            .when()
            .get(EndPoints.GET_SINGLE_CATEGORIES_ID)
            .then();
}
    @Step("Getting All Categories")
    public ValidatableResponse getAllCategory(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_CATEGORIES)
                .then();
    }
}
