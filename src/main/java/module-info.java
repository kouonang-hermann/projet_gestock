module main.Getock{

    requires javafx.controls;
    requires javafx.graphics;

    requires java.sql;


    requires javafx.fxml;

    opens controllers to javafx.controls, javafx.graphics, java.sql;

    exports controllers;
}