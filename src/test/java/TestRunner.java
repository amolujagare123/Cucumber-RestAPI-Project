import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature",glue = "stepDefinition"
        ,tags = "@chatUserCreate")
public class TestRunner {
}
