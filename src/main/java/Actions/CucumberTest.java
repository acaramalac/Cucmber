package Actions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\Projects\\Cucumber\\src\\main\\resources\\Feauters",
        glue = {"BDD"}
//        tags = {"@Select"} //{"@or,@or","@and","~@not"}
)
public class CucumberTest {

}
