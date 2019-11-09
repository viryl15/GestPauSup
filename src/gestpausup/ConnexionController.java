/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestpausup;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.stage.WindowHelper;
import static gestpausup.FXMLDocumentController.on;
import static gestpausup.FXMLDocumentController.setMsg;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import sun.plugin2.os.windows.Windows;

/**
 *
 * @author DYLAN
 */
public class ConnexionController implements Initializable {
    
    @FXML
    private ComboBox<String> cbtypeCpt;
    @FXML
    private Button btnConnexion;
    @FXML
    private JFXPasswordField tfMdp;
    @FXML
    private JFXTextField tfLogin;
    public static String poste;

    public static String getPoste() {
        return poste;
    }

    public static void setPoste(String poste) {
        ConnexionController.poste = poste;
    }
    public ConnexionController() {  
        
    }
    
    
    private void clic(){
        System.out.println("Test du clic !!!!!!!!!!!!!");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        ArrayList<String> list1 = new ArrayList<>();
//        list1.add("Directeur");
//        list1.add("Responsable");
//        ObservableList Oblist1 = FXCollections.observableArrayList(list1);
//        
//        cbtypeCpt.setItems((ObservableList)Oblist1);
//        cbtypeCpt.setVisibleRowCount(2);
        

        
        cbtypeCpt.setValue("Responsable");
        cbtypeCpt.getItems().add("Directeur");
        cbtypeCpt.getItems().add("Responsable");
        
        
        
    }

    @FXML
    private void btnConnexionAction(ActionEvent event) throws IOException {
        
        if(tfLogin.getText().equals("root") && tfMdp.getText().equals("root")){
            setPoste(cbtypeCpt.getValue());
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml"));
            Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
            st.close();
            Scene scene = new Scene(root);
            stage.setTitle("GestPauSup");
            stage.setScene(scene);

            stage.showAndWait();
        }else{
            on=false;
            setMsg("Login ou mot de passe incorrect");
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/AlertDialog.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        
        
        
        
    }
}
