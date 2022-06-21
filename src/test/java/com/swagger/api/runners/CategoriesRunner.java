package com.swagger.api.runners;

import com.swagger.api.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/java/resouces/feature",
        glue = "com/swagger/api",
        tags = "@categories"
)
public class CategoriesRunner extends TestBase {


}
