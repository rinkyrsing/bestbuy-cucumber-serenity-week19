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

import static org.hamcrest.collection.IsMapContaining.hasValue;

@RunWith(SerenityRunner.class)
public class CategoriesCRUDTest extends TestBase {

    static String name = "Amy" + TestUtils.getRandomValue();
    static String id = "0007" + TestUtils.getRandomValue();

    static String categoriesId;

 @Steps
 CategoriesSteps categoriesSteps;

 @Title("This will create new categories")
@Test
public void test001(){

     ValidatableResponse response = categoriesSteps.createCategories(name,id);
     response.log().all().statusCode(201);
     categoriesId = response.log().all().extract().path("id");
     System.out.println(categoriesId);

 }
    @Title(" Verify the categories by name: {0}")
    @Test
    public void test002(){
        HashMap<String,?> categoriesMap = categoriesSteps.getCategoriesByName(categoriesId);
        Assert.assertThat(categoriesMap, hasValue(name));
        System.out.println(categoriesId);
 }
    @Title(" Update categories with id{0}, name: {0}, Id{0}")
    @Test
    public void test003(){
     name = name + "_updateName";
     categoriesSteps.updateInfoByName(categoriesId,name,id);
     HashMap<String, ?> categoriesMap = categoriesSteps.getCategoriesByName(categoriesId);
     Assert.assertThat(categoriesMap, hasValue(name));
     System.out.println(categoriesMap);
 }
    @Title("Delete the product by ID{0}")
    @Test
    public void test004() {
     categoriesSteps.deleteCategoriesId(categoriesId).statusCode(200);
     categoriesSteps.getDeleteCategoriesId(categoriesId).statusCode(404);
    }

}
