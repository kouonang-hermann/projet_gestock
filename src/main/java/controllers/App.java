package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class App extends Application {


    public static void main(String args[]){

        launch(args);
    }
    @Override
    public void start (Stage window){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));

            Scene scene = new Scene(root);

            window.setScene(scene);

            window.show();

        }catch(Exception exception){

            exception.printStackTrace();
        }
    }
}
