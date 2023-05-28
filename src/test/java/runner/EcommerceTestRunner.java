package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/feature"},
		
        glue = {"stepDefinition", "hooks"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        //tags = ("@compareMobiles or @LoginValidCred or @MobileListSort or @SonyExperia")
        //tags = "@LoginValidCred or @LoginInValidCred"
        //tags = (" @MobileListSort or @SonyExperia")
        		 //tags = "@compareMobiles"
        tags = "@CreateAccount"
		)
public class EcommerceTestRunner {

}
