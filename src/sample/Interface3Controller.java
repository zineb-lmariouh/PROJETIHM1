package sample;

import Conx.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Interface3Controller {
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Button v1;
    @FXML
    private Button v2;
    @FXML
    private Button v3;
    @FXML
    private Button c1;
    @FXML
    private Button c2;
    @FXML
    private Button c3;
    @FXML
    private Button clear;
    @FXML
    private AnchorPane pane;

    public void sendinter2(ActionEvent event){
        pane.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("interface2.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Interface3Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }
   public void Monter(ActionEvent actionEvent) {
        ConnectionClass connectionClass = new ConnectionClass() ;
        Connection connection=connectionClass.getConnection();
        String sql2=" select email from Matable where email='"+Static.x+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet queryOutput = statement.executeQuery(sql2);
            while (queryOutput.next()){
                l1.setText(queryOutput.getString( "email"));
            }
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
}
}