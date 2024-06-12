package DataBaseWorks;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseManager {

    public static Connection connection;
    private static final String URL = ConfigManager.dataBaseURL;

    public static void ConnectToDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://pg:5432/studs", "s408301", "iWZm1YsglolA8IOX");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Возникла ошибка при подключении к базе данных");
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
