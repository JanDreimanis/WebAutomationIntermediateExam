package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ConfigfileReader {

    private final Properties properties = getProperties();

    private static final String PATH =
            "src" + File.separator +
                    "main" + File.separator +
                    "resources" + File.separator +
                    "configs" + File.separator +
                    "configuration.properties";

    private Properties getProperties(){
        Properties properties1 = new Properties();
        BufferedReader bufferedReader;
        try{
            bufferedReader = new BufferedReader(new FileReader(PATH));
            try{
                properties1.load(bufferedReader);
                bufferedReader.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
        return properties1;
    }

    private String getProperty(String key){
        return properties.getProperty(key);
    }

    public String getAutomationPractiseUrl() {
        return getProperty("automation.site.url");
    }

    public String getGlobalSqaSamplePageTestUrl() {
        return getProperty("globalSqa.sample.page.test.site.url");
    }

    public String getGlobalSqaDemoSiteUrl() {
        return getProperty("globalSqa.demo.site.url");
    }

    public String getAuthor() { return getProperty("author"); }
}
