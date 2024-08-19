module main.Getock{

    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires java.sql;



    requires javafx.fxml;
    requires java.desktop;
    requires mysql.connector.java;

    opens controllers to javafx.controls, javafx.graphics, java.sql, javafx.fxml;
    opens model to javafx.base;

    exports controllers;
    exports model;
}