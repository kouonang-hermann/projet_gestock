package sercice;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

    public static Connection createConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://loclhost:3307/Getock", "root", "Fa13/08/99");
        } catch (Exception exception){
            exception.printStackTrace();

        }
        return null;

    }
}
