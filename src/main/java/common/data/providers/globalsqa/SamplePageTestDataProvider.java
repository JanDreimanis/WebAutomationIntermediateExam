package common.data.providers.globalsqa;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class SamplePageTestDataProvider {

    @DataProvider(name = "sample page testdata")
    public Object[][] testData(Method method) {
        switch (method.getName()) {
            case "future test":
                return new Object[][]{{"Janis", "janis@banis.lv"},
                        {"Olga", "olga@volga.lv"},
                        {"Zane", "zane@gane.lv"}};
            case "test004":
                return new Object[][]{{"Olis", "olis@polis.lv"},
                        {"ball", "ball@small.lv"},
                        {"Zoss", "zoss@govs.lv"}};
        }
        return null;
    }
}
