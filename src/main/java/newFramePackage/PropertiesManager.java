package newFramePackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesManager {

    private static Properties properties;
    private static FileInputStream fis;
    private static FileOutputStream fos;

    static String projectPath = System.getProperty("user.dir") + "/";
    private static final String propertiesFilePatchRoot = "src/test/resources/config.properties";

    public static void setPropertiesFile() {
        properties = new Properties();
        try {
            fis = new FileInputStream(projectPath + propertiesFilePatchRoot);
            properties.load(fis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static String getPropValue(String keyProp) {
        String value = null;

        try {
            value = properties.getProperty(keyProp);
            System.out.println(value);
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return value;
    }

    public static void setPropValue(String keyProp, String value) {
        try {
            fos = new FileOutputStream(projectPath + propertiesFilePatchRoot);
            properties.setProperty(keyProp, value);
            properties.store(fos, "Set up new value for: " + value + "!");
            System.out.println("Set up new value for: " + value + "!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

}
