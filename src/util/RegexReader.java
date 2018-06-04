package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RegexReader {
    private Properties prop = new Properties();

    public Properties getProp() {
        return prop;
    }

    public void readFile(String filepath){
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream(filepath);
            prop.load(stream);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
