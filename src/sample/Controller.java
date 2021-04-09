package sample;

import Conx.ConnectionClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    @FXML
    private TextField fromField;
    @FXML
    private TextField toField;
    @FXML
    private TextField subField;
    @FXML
    private TextArea emailFeild;
    @FXML
    private Button send;
    @FXML
    private AnchorPane pane;


    public void Save(ActionEvent actionEvent)
            throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass() ;
        Connection connection=connectionClass.getConnection();
        Random rd = new Random();
        int random = rd.nextInt(1000);
        String sql=" INSERT INTO Matable  values ('"+random+"','" +fromField.getText()+"','"+toField.getText()+"','"+subField.getText()+"','"+emailFeild.getText()+"')";
        System.out.println(sql);
        Static.x=emailFeild.getText();

        Statement statement=connection.createStatement();
        statement.executeUpdate(sql) ;


        pane.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("interface3.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }


}
