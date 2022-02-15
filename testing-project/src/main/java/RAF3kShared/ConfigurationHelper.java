package RAF3kShared;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationHelper {
    private final Properties configProp = new Properties();

    public ConfigurationHelper()
    {
        //Private constructor to restrict new instances
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key){
        return configProp.getProperty(key);
    }
}
