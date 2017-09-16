package sfdc.automation.steps;

import java.util.HashMap;
import java.util.Map;
 
//import org.springframework.test.context.ContextConfiguration;
 //@ContextConfiguration(locations = {"classpath:cucumber.xml"})

public abstract class SfdcBaseStep {
     
      public static String AGREEMENT_NAME = "AGREEMENT_NAME";
     
      private static ThreadLocal<Map<String, String>> scenarioData = new ThreadLocal<>();
     
      public String get(String key) {
            return scenarioData.get().get(key);
      }
     
      public void put(String key, String value) {
            synchronized (scenarioData) {
                  if (scenarioData.get() == null) {
                        scenarioData.set(new HashMap<String, String>());
                  }
            }
            scenarioData.get().put(key, value);
      }
}
