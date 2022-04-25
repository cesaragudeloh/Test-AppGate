package co.com.appgatetest.cesar.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/api_test.feature",
        glue = "co.com.appgatetest.cesar.stepdefinitions",
        snippets =CAMELCASE
)
public class APITest {
}
