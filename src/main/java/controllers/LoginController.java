package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sercice.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {
    @FXML
    private Button btn_login;

    @FXML
    private TextField tf_id;

    @FXML
    private PasswordField tf_password;

    // base de donner
    Connection con;

    //variable de requete preparer
    PreparedStatement statement;
    ResultSet resultSet;

    public void login(ActionEvent event) throws SQLException {

        // on recupere les valeurs a l'ecran entrer par l'utilisateur

        String id =  tf_id.getText();
        String password = tf_password.getText();

        String query = "select * from user where userName='%s' and password='%s'".formatted(id, password);

        //on crée la connection a la connection
        con = DataBase.createConnection();

        //on converti le query en requete sql puisque tel que déclarer initialement elle etait un string
        statement = con.prepareStatement(query);

        resultSet = statement.executeQuery();

        // ici on  definis les actions qui vont suivre derriere la validation du boutton login
        if(resultSet.next()){
            //premierement on test la valeur contenu dans le resultSet si c'est vrai on affiche login successful
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("login successfull");
            alert.showAndWait();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/AgencyView.fxml"));
                Stage window = new Stage();
                Scene scene = new Scene(root);
                window.setScene(scene);
                window.show();
                System.out.println("helloWorld");

                Stage loginWindow = (Stage) btn_login.getScene().getWindow();
                loginWindow.close();
            } catch (Exception exception){
                exception.printStackTrace();
            }



        } else {
            //sinon
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("error connection");
            alert.showAndWait();
        }


       /* System.out.println("id is "  + tf_id.getText());
        System.out.println("password is "  + tf_password.getText());*/
    }
}
