package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/reports/cucumber.html", "json:target/report.json"},
        features = "src/test/resources/features",
        glue = "steps",
        dryRun = false,
        tags = "@login"


)
public class CucumberRunner {


}
