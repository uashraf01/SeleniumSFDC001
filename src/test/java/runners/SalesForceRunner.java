package runners;

import org.junit.runner.RunWith; 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)

@CucumberOptions(format = {"pretty", "html:target/cucumber"},
                        features = {"src/test/resources/features" },
                        glue = { "sfdc.automation.steps" },
                        tags = {"@current"},
                        monochrome = true ,
                        dryRun = false)
public class SalesForceRunner {
 
    }


// @BeforeClass
/*public static void setup() {
    String reportsOutput = LocalConfUtils.getRootDir() + File.separator + "html-reports";
    EcrmConfUtils.setBaseResultsDir(reportsOutput);*/


//import com.fanniemae.ecrm.automation.libs.EcrmConfUtils;
//import com.fanniemae.testeng.automation.utils.LocalConfUtils;