import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();

            FileReader reader = new FileReader("src/resources/db.properties");

            properties.load(reader);

            reader.close();

            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String swap = properties.getProperty("swap");
            System.out.println(swap);

            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected!");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}