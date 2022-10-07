package common.data.providers.globalsqa;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class SamplePageTestDataProvider {

    @DataProvider(name = "sample page testdata")
    public Object[][] testData(Method method) {
        switch (method.getName()) {
            case "future test":
                return new Object[][] {{"Janis", "janis@janis.lv"},
                        {"Olga", "olga@olga.lv"},
                        {"Zane", "zane@zane.lv"} };
            case "test004":
                return new Object[][] {{"Olis", "olis@olis.lv"},
                        {"ball", "ball@lmt.lv"},
                        {"Zoss", "zoss@tele2.lv"} };
        } return null;
    }
}
