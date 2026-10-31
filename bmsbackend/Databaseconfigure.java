package bmsbackend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databaseconfigure {
    static String url = "jdbc:mysql://localhost:3306/BOOKYOURTICKET";

    static  String username ="root";
    static  String password="*****";

    public static Connection getconnection() throws SQLException {

        return DriverManager.getConnection(url,username,password);


    }
}
