

    package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Commande;
import model.LotCommande;
import sercice.DataBase;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.ResourceBundle;

    public class AgencyController implements Initializable {

        @FXML
        private TableColumn<Commande, Integer> QuantiteCommande_col;

        @FXML
        private Button btn_add;


        @FXML
        private TableView<LotCommande> commandeLot_table;

        @FXML
        private TableView<Commande> commande_table;

        @FXML
        private TableColumn<LotCommande, Date> dateEnvoieLot_col;

        @FXML
        private TableColumn<LotCommande, Date> dateValidationLot_col;

        @FXML
        private TableColumn<LotCommande, String> etatLot_col;

        @FXML
        private TableColumn<LotCommande, Integer> idLot_col;

        @FXML
        private TableColumn<LotCommande, String> nomAgenceLot_col;

        @FXML
        private TableColumn<Commande, String> nomProduitCommande_col;

        Connection con;

        PreparedStatement statement;

        ResultSet resultSet;

        @FXML
        void addCommand(ActionEvent event) {

        }


        public void showCommande(MouseEvent event){



            fillCommandTable();
        }


        // pour le lots de commande.
        public ObservableList<LotCommande> fetchLotCommand(){


            //ici on declareune liste observable qui sera retourner a la fin de l'execution de la methode de la fonction

            ObservableList<LotCommande> listLot = FXCollections.observableArrayList();

            try {

                String query = "select * from lot_de_commande";

                //on crée la connection a la connection
                con = DataBase.createConnection();

                //on converti le query en requete sql puisque tel que déclarer initialement elle etait un string
                statement = con.prepareStatement(query);

                resultSet = statement.executeQuery();

                LotCommande lot;

                while (resultSet.next()){
                    lot = new LotCommande(
                            resultSet.getInt("id"),
                            resultSet.getString("etat"),
                            resultSet.getDate("dateEnvoie"),
                            resultSet.getDate("dateValidation"),
                            resultSet.getString("nomAgence"),
                            resultSet.getInt("idAgence"),
                            resultSet.getInt("quantite")
                    );

                    listLot.add(lot);
                }

            } catch(Exception exception){

                exception.printStackTrace();
            }

            return listLot;
        }

        public void fillLotCommandeBachTable(){

            ObservableList<LotCommande> listLot = fetchLotCommand();

            idLot_col.setCellValueFactory(new PropertyValueFactory<>("id"));
            etatLot_col.setCellValueFactory(new PropertyValueFactory<>("etat"));
            dateEnvoieLot_col.setCellValueFactory(new PropertyValueFactory<>("dateEnvoie"));
            dateValidationLot_col.setCellValueFactory(new PropertyValueFactory<>("dateValidation"));
            nomAgenceLot_col.setCellValueFactory(new PropertyValueFactory<>("nomAgence"));
            commandeLot_table.setItems(listLot);
        }



        // pour la commande

        public ObservableList<Commande> fetchCommand(int idLotcommande){

            ObservableList<Commande> listCom = FXCollections.observableArrayList();

            try{

                String query = """
                SELECT commande.id, commande.idArticle, commande.quantite, commande.idLotCommande, fourniture.nomArticle
                FROM commande
                INNER JOIN fourniture
                ON commande.idArticle = fourniture.id
                WHERE commande.idLotCommande =%d        
                """.formatted(idLotcommande);

                //on crée la connection a la connection
                con = DataBase.createConnection();

                //on converti le query en requete sql puisque tel que déclarer initialement elle etait un string
                statement = con.prepareStatement(query);

                resultSet = statement.executeQuery();

                Commande com;

                while (resultSet.next()){
                    com = new Commande(
                            resultSet.getInt("id"),
                            resultSet.getInt("idArticle"),
                            resultSet.getString("nomArticle"),
                            resultSet.getInt("quantite"),
                            resultSet.getInt("idLotCommande")

                    );

                    listCom.add(com);
                }

            } catch(Exception exception){
                exception.printStackTrace();
            }

            return listCom;

        }

        public void fillCommandTable(){

            // recuperer l'identifiant de la commande selectionee sur la table commandeLot
            // et pour avoir ca on vas devoire utiliser le model de selection de la table
            LotCommande selectedbatch = commandeLot_table.getSelectionModel().getSelectedItem();
            // puisque les elelments de la table commandLot sont des objects de type )
            int idLot = selectedbatch.getId();

            ObservableList<Commande> listCom = fetchCommand(idLot);

            nomProduitCommande_col.setCellValueFactory(new PropertyValueFactory<>("nomArticle"));
            QuantiteCommande_col.setCellValueFactory(new PropertyValueFactory<>("quantite"));

            commande_table.setItems(listCom);
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            fillLotCommandeBachTable();


        }


    }

