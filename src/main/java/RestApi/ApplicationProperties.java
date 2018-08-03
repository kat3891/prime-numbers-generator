package RestApi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  This class defines the application properies, by reading the file called config.properties.
 */
class ApplicationProperties {

    String IP_ADDRESS;
    int PORT;
    String CSP_HEADERS;
    String SERVER_NAME;
    String KEYSTORE_FILENAME;
    String KEYSTORE_PASSWORD;
    String DATABASE_URL;
    String LOG_FILE;
    int LOG_LIMIT;
    int LOG_COUNT;

    ApplicationProperties() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("src/main/java/RestApi/config.properties");

            // load a config.properties file
            prop.load(input);

            this.CSP_HEADERS = prop.getProperty("CSP_HEADERS");
            this.SERVER_NAME = prop.getProperty("SERVER_NAME");
            this.KEYSTORE_FILENAME = prop.getProperty("KEYSTORE_FILENAME");
            this.KEYSTORE_PASSWORD = prop.getProperty("KEYSTORE_PASSWORD");
            this.DATABASE_URL = prop.getProperty("DB_URL");

            this.LOG_FILE = prop.getProperty("LOG_FILE");
            this.LOG_COUNT = Integer.parseInt(prop.getProperty("LOG_COUNT"));
            this.LOG_LIMIT = Integer.parseInt(prop.getProperty("LOG_LIMIT"));

            // get the property value and print it out
            this.IP_ADDRESS = System.getenv("OPENSHIFT_DIY_IP") != null ? System.getenv("OPENSHIFT_DIY_IP") : prop.getProperty("URL");
            this.PORT = System.getenv("OPENSHIFT_DIY_PORT") != null ? Integer.parseInt(System.getenv("OPENSHIFT_DIY_PORT")) : Integer.parseInt(prop.getProperty("PORT"));


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
