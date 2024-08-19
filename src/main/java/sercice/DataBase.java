package sercice;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

    public static Connection createConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/getock", "root", "Fa13/08/99");
            return con;
        } catch (Exception exception){
            exception.printStackTrace();

        }
        return null;

    }
}
