package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

    public static Connection getConection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/prova", "root", "femina123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
