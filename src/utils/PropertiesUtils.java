package utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author EDZ
 */
public class PropertiesUtils {
    private static Properties pro;
    static {
        pro = new Properties();
        try (InputStream is = PropertiesUtils.class.getClassLoader().getResourceAsStream("chessConfig")) {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double getDoubleProperties(String key) {
        return Double.parseDouble(pro.getProperty(key));
    }
}
