/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestpausup;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DYLAN
 */
public class AlertDialogController implements Initializable {
    Stage stage;
    @FXML
    private JFXButton btnOK;
    @FXML
    private Label msg;
    @FXML
    private JFXButton btnNon;
    @FXML
    private JFXButton btnOui;
    public static boolean o=false, n=false;

    public static boolean isO() {
        return o;
    }

    public static void setO(boolean o) {
        AlertDialogController.o = o;
    }

    public static boolean isN() {
        return n;
    }

    public static void setN(boolean n) {
        AlertDialogController.n = n;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        msg.setText(FXMLDocumentController.msg);
        msg.setVisible(true);
        System.out.println("le messsssaggeee est    "+FXMLDocumentController.getMsg());
        if(FXMLDocumentController.on){
            btnNon.setVisible(true);
            btnOui.setVisible(true);
            btnOK.setVisible(false);
        }else{
            btnNon.setVisible(false);
            btnOui.setVisible(false);
        }
    }    

    @FXML
    private void onAction(ActionEvent event) throws IOException {
        
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml"));
        Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
        st.close();
    }

    @FXML
    private void nAction(ActionEvent event) throws IOException {
        setO(false);
        setN(true);
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml"));
        Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
        st.close();
    }

    @FXML
    private void oAction(ActionEvent event) throws IOException {
        setO(true);
        setN(false);
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml"));
        Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
        st.close();
    }
    
}
