/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestpausup;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *
 * @author DYLAN
 */
public class FXMLDocumentController implements Initializable {
    Statement stmt;
    ResultSet rs;
    @FXML
    private Button btnConnexion;
    @FXML
    private Pane welcomePanel, connexionPanel, connexionPanel1;
    @FXML
    private ComboBox<String> cbtypeCpt;
    @FXML
    private JFXButton btnGvh;
    @FXML
    private AnchorPane anc2;
    @FXML
    private Button btnConnexion1;
    @FXML
    private ComboBox<?> cbtypeCpt1;
   
    @FXML
    private JFXButton btnGch;
    @FXML
    private JFXButton btnGpr;
    @FXML
    private VBox gestPersoPanel;
    @FXML
    private VBox gestChPanel;
    @FXML
    private VBox gestVhPanel;
    @FXML
    private GridPane ajoutVhPanel;
    @FXML
    private JFXButton btnAjouter;
    @FXML
    private GridPane ajoutChPanel;
    @FXML
    private GridPane ajoutPersoPanel;
    @FXML
    private JFXTextField immatriculation;
    @FXML
    private JFXTextField numCatreGrise;
    @FXML
    private JFXTextField nbrPlace;
    @FXML
    private JFXTextField type;
    @FXML
    private JFXTextField modele;
    @FXML
    private JFXButton btnAjoutVhValidation;
    @FXML
    private TableView<Vehicule> listeVhTv;
    @FXML
    private TableColumn<Vehicule, String> immatriculationClumn;
    @FXML
    private TableColumn<Vehicule, String> modeleColumn;
    @FXML
    private TableColumn<Vehicule, Integer> nbrPlaceColumn;
    @FXML
    private TableColumn<Vehicule, String> numCartreGriseColumn;
    @FXML
    private TableColumn<Vehicule, String> typeVhColumn;
    @FXML
    private AnchorPane anchorPrincipal;
    @FXML
    private JFXTextField nomChTf;
    @FXML
    private JFXTextField telChTf;
    @FXML
    private JFXTextField adressChTf;
    @FXML
    private JFXTextField prenomChTf;
    @FXML
    private JFXTextField emailChTf;
    @FXML
    private ComboBox<String> typePermisCb;
    @FXML
    private JFXTextField nomPersoTf;
    @FXML
    private JFXTextField telPersoTf;
    @FXML
    private JFXTextField adressPersoTf;
    @FXML
    private JFXTextField prenomPersoTf;
    @FXML
    private JFXTextField emailPersoTf;
    @FXML
    private JFXTextField fonctionPersoTf;
    @FXML
    private TableColumn<Chauffeur, String> nomChCln;
    @FXML
    private TableColumn<Chauffeur, String> prenomChCln;
    @FXML
    private TableColumn<Chauffeur, String> typePermisChCln;
    @FXML
    private TableColumn<Chauffeur, String> adressChCln;
    @FXML
    private TableColumn<Chauffeur, Integer> telChCln;
    @FXML
    private TableColumn<Chauffeur, String> emailChCln;
    @FXML
    private TableView<Chauffeur> listeChTv;
    @FXML
    private TableView<Personnel> listePersoTv;
    @FXML
    private TableColumn<Personnel, String> nomPersoCln;
    @FXML
    private TableColumn<Personnel, String> prenomPersoCln;
    @FXML
    private TableColumn<Personnel, String> fonctionPersoCln;
    @FXML
    private TableColumn<Personnel, String> adressPersoCln;
    @FXML
    private TableColumn<Personnel, Integer> telPersoCln;
    @FXML
    private TableColumn<Personnel, String> emailPersoCln;
    @FXML
    private GridPane modifVhPanel;
    @FXML
    private JFXTextField tfmImmatVh;
    @FXML
    private JFXTextField tfmModelVh;
    @FXML
    private JFXTextField tfmTypeVh;
    @FXML
    private JFXTextField tfmNbrPlaceVh;
    @FXML
    private JFXTextField tfmNumCarteGriseVh;
    @FXML
    private JFXButton btnModifVhValidation;
    @FXML
    private Label lblmImmatVh;
    @FXML
    private Label lblmModelVh;
    @FXML
    private Label lblmTypeVh;
    @FXML
    private Label lblmNbrPlaceVh;
    @FXML
    private Label lblmNumCarteGriseVh;
    @FXML
    private TableColumn<Personnel, Integer> id_persoCln;
    @FXML
    private TableColumn<Chauffeur, Integer> id_chCln;
    @FXML
    private GridPane modifChPanel;
    @FXML
    private JFXTextField tfmNomCh;
    @FXML
    private JFXTextField tfmPrenomCh;
    @FXML
    private JFXTextField tfmAdresseCh;
    @FXML
    private JFXTextField tfmTelCh;
    @FXML
    private JFXButton btnModifChValidation;
    @FXML
    private Label lblmNomCh;
    @FXML
    private Label lblmPrenomCh;
    @FXML
    private Label lblmTypePermisCh;
    @FXML
    private Label lblmAdresseCh;
    @FXML
    private Label lblmTelCh;
    @FXML
    private JFXTextField tfmEmailCh;
    @FXML
    private Label lblmEmailCh;
    @FXML
    private GridPane modifPersoPanel;
    @FXML
    private JFXTextField tfmNomPerso;
    @FXML
    private JFXTextField tfmPrenomPerso;
    @FXML
    private JFXTextField tfmAdressePerso;
    @FXML
    private JFXTextField tfmTelPerso;
    @FXML
    private JFXButton btnModifPersoValidation;
    @FXML
    private Label lblmNomPerso;
    @FXML
    private Label lblmPrenomPerso;
    @FXML
    private Label lblmFonctPerso;
    @FXML
    private Label lblmAdressePerso;
    @FXML
    private Label lblmTelPerso;
    @FXML
    private JFXTextField tfmEmailPerso;
    @FXML
    private Label lblmEmailPerso;
    @FXML
    private ComboBox<String> typePermisCb1;
    @FXML
    private JFXTextField tfmFonctPerso;
    @FXML
    private JFXButton btnDeleteVh;
    @FXML
    private JFXButton btnDeleteCh;
    @FXML
    private JFXButton btnDeletePerso;
    @FXML
    private JFXButton btnPrintPerso;
    
    public static String msg;
    public static boolean on=false;

    public static boolean isOn() {
        return on;
    }

    public static void setOn(boolean on) {
        FXMLDocumentController.on = on;
    }
    @FXML
    private JFXButton btnGur;
    @FXML
    private Label lblEtat3;
    @FXML
    private Label lblEtat1;
    @FXML
    private Label lblEtat2;
    @FXML
    private Label lblEtat4;
    @FXML
    private Label lblEtat5;
    @FXML
    private Label lblEtat6;
    @FXML
    private Label lblEtat7;
    @FXML
    private Label lblEtat8;
    @FXML
    private Label lblEtat9;
    @FXML
    private VBox gestUserPanel;
    @FXML
    private Label lblEtat;
    @FXML
    private TableView<User> listeUserTv;
    @FXML
    private TableColumn<User, String> loginUserCln;
    @FXML
    private TableColumn<User, String> mdpUserCln;
    @FXML
    private TableColumn<User, String> roleUserCln;
    @FXML
    private TableColumn<User, Integer> id_userCln;
    @FXML
    private JFXButton btnActivite;
    @FXML
    private VBox activitePanel;
    @FXML
    private Label lblEtat11;
    @FXML
    private TableColumn<Activite, String> vhACln;
    @FXML
    private TableColumn<Activite, String> chACln;
    @FXML
    private TableColumn<Activite, String> typeACln;
    @FXML
    private TableColumn<Activite, String> libelleCln;
    @FXML
    private TableColumn<Activite, String> dateDepartCln;
    @FXML
    private TableColumn<Activite, String> dateArriveeCln;
    @FXML
    private TableColumn<Activite, String> destinationCln;
    @FXML
    private TableColumn<Activite, String> lieuDepartCln;
    @FXML
    private TableColumn<Activite, Integer> id_ACln;
    @FXML
    private GridPane ajoutActivitePanel;
    @FXML
    private JFXTextField tfTypeAct;
    @FXML
    private JFXTextField tfDestinAct;
    @FXML
    private JFXTextField tfLibelleAct;
    @FXML
    private JFXTextField tfLieuDepAct;
    @FXML
    private Label lblEtat61;
    @FXML
    private JFXDatePicker dateDepAct;
    @FXML
    private JFXDatePicker dateArrAct;
    @FXML
    private JFXTextField tfChAct;
    @FXML
    private JFXTextField tfVhAct;
    @FXML
    private TableView<Activite> listeActTv;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(ConnexionController.getPoste().equals("Responsable")){
            btnGur.setVisible(false);
        }
        
        
        lblEtat.setText("Vous etes connecté en tant que "+ConnexionController.getPoste());
        lblEtat1.setText("Vous etes connecté en tant que "+ConnexionController.getPoste());
        lblEtat2.setText("Vous etes connecté en tant que "+ConnexionController.getPoste());
        lblEtat3.setText("Vous etes connecté en tant que "+ConnexionController.getPoste());
        lblEtat4.setText("Vous etes connecté en tant que "+ConnexionController.getPoste());
        lblEtat5.setText("Vous etes connecté en tant que "+ConnexionController.getPoste());
        lblEtat6.setText("Vous etes connecté en tant que "+ConnexionController.getPoste());
        lblEtat7.setText("Vous etes connecté en tant que "+ConnexionController.getPoste());
        lblEtat8.setText("Vous etes connecté en tant que "+ConnexionController.getPoste());
        lblEtat9.setText("Vous etes connecté en tant que "+ConnexionController.getPoste());
        
//        listeVhTv.getColumns().addAll(immatriculationClumn, modeleColumn, nbrPlaceColumn, numCartreGriseColumn);
        typePermisCb.setValue("A");
        typePermisCb.getItems().add("A");
        typePermisCb.getItems().add("B");
        typePermisCb.getItems().add("C");
        typePermisCb.getItems().add("D");
        typePermisCb.getItems().add("Pas de permis");
        
        typePermisCb1.setValue("A");
        typePermisCb1.getItems().add("A");
        typePermisCb1.getItems().add("B");
        typePermisCb1.getItems().add("C");
        typePermisCb1.getItems().add("D");
        typePermisCb1.getItems().add("Pas de permis");

//------*******Activite
        vhACln.setCellValueFactory(new PropertyValueFactory<Activite, String>("VEHICULE"));
        chACln.setCellValueFactory(new PropertyValueFactory<Activite, String>("CHAUFFEUR"));
        typeACln.setCellValueFactory(new PropertyValueFactory<Activite, String>("TYPE"));
        libelleCln.setCellValueFactory(new PropertyValueFactory<Activite, String>("LIBELLE"));
        dateDepartCln.setCellValueFactory(new PropertyValueFactory<Activite, String>("DATE_DEPART"));
        dateArriveeCln.setCellValueFactory(new PropertyValueFactory<Activite, String>("DATE_ARRIVEE"));
        destinationCln.setCellValueFactory(new PropertyValueFactory<Activite, String>("DESTINATION"));
        lieuDepartCln.setCellValueFactory(new PropertyValueFactory<Activite, String>("LIEU_DEPART"));
        id_ACln.setCellValueFactory(new PropertyValueFactory<Activite, Integer>("ID_ACTIVITE"));
        
//-----*******User
        loginUserCln.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        mdpUserCln.setCellValueFactory(new PropertyValueFactory<User, String>("mdp"));
        roleUserCln.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
        id_userCln.setCellValueFactory(new PropertyValueFactory<User, Integer>("id_user"));
        
//-----*******Personnel
        nomPersoCln.setCellValueFactory(new PropertyValueFactory<Personnel, String>("nom"));
        prenomPersoCln.setCellValueFactory(new PropertyValueFactory<Personnel, String>("prenom"));
        fonctionPersoCln.setCellValueFactory(new PropertyValueFactory<Personnel, String>("fonction"));
        adressPersoCln.setCellValueFactory(new PropertyValueFactory<Personnel, String>("adresse"));
        telPersoCln.setCellValueFactory(new PropertyValueFactory<Personnel, Integer>("tel"));
        emailPersoCln.setCellValueFactory(new PropertyValueFactory<Personnel, String>("email"));
        id_persoCln.setCellValueFactory(new PropertyValueFactory<Personnel, Integer>("id_perso"));
        
//-----*******Chauffeur
        nomChCln.setCellValueFactory(new PropertyValueFactory<Chauffeur, String>("nom"));
        prenomChCln.setCellValueFactory(new PropertyValueFactory<Chauffeur, String>("prenom"));
        typePermisChCln.setCellValueFactory(new PropertyValueFactory<Chauffeur, String>("typePermis"));
        adressChCln.setCellValueFactory(new PropertyValueFactory<Chauffeur, String>("adresse"));
        telChCln.setCellValueFactory(new PropertyValueFactory<Chauffeur, Integer>("tel"));
        emailChCln.setCellValueFactory(new PropertyValueFactory<Chauffeur, String>("email"));
        id_chCln.setCellValueFactory(new PropertyValueFactory<Chauffeur, Integer>("id_ch"));
        
//----****vehicule
        immatriculationClumn.setCellValueFactory(new PropertyValueFactory<Vehicule, String>("immatriculation"));
        modeleColumn.setCellValueFactory(new PropertyValueFactory<Vehicule, String>("modele"));
        typeVhColumn.setCellValueFactory(new PropertyValueFactory<Vehicule, String>("type"));
        nbrPlaceColumn.setCellValueFactory(new PropertyValueFactory<Vehicule, Integer>("nbrPlace"));
        numCartreGriseColumn.setCellValueFactory(new PropertyValueFactory<Vehicule, String>("numCatreGrise"));
        actualiserListeVh();
        actualiserListeCh();
        actualiserListePerso();
        actualiserListeUser();
        actualiserListeActivite();
//        listeVhTv.setItems(actualiserListeVh());
        
    }
    
    private void actualiserListeActivite(){
        ArrayList<Activite> listeUsr = new ArrayList<>();
        try {
            Connection con = getConnection();
            stmt = con.createStatement();   
            rs = stmt.executeQuery("SELECT * FROM activite");
            Activite u;
            while(rs.next()){
                u = new Activite(rs.getInt("ID_ACTIVITE"),rs.getString("TYPE"), rs.getString("LIBELLE"),
                        rs.getString("DATE_DEPART"), rs.getString("DATE_ARRIVEE"), rs.getString("DESTINATION"), rs.getString("LIEU_DEPART"),
                        rs.getString("VEHICULE"), rs.getString("CHAUFFEUR"));
                listeUsr.add(u);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        final ObservableList<Activite> data = FXCollections.observableArrayList(
            listeUsr
        );
        listeActTv.setItems(data);
    }
    
    
    private void actualiserListeUser(){
        ArrayList<User> listeUsr = new ArrayList<>();
        try {
            Connection con = getConnection();
            stmt = con.createStatement();   
            rs = stmt.executeQuery("SELECT * FROM user");
            User u;
            while(rs.next()){
                u = new User(rs.getInt("id_user"),rs.getString("login"), rs.getString("mdp"),
                        rs.getString("role"));
                listeUsr.add(u);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        final ObservableList<User> data = FXCollections.observableArrayList(
            listeUsr
        );
        listeUserTv.setItems(data);
    }
    private void actualiserListeVh(){
        ArrayList<Vehicule> listeVh = new ArrayList<>();
        try {
            Connection con = getConnection();
            stmt = con.createStatement();   
            rs = stmt.executeQuery("SELECT * FROM vehicule");
            Vehicule v;
            while(rs.next()){
                v = new Vehicule(rs.getString("immatriculation"), rs.getString("modele"),
                        rs.getString("type"), rs.getInt("NOMBRE_PLACE"), 
                        rs.getString("NUM_CARTEGRISE"));
                listeVh.add(v);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        final ObservableList<Vehicule> data = FXCollections.observableArrayList(
            listeVh
        );
        listeVhTv.setItems(data);
    }
    
    private void actualiserListeCh(){
        ArrayList<Chauffeur> listeCh = new ArrayList<>();
        try {
            Connection con = getConnection();
            stmt = con.createStatement();   
            rs = stmt.executeQuery("SELECT nom_ch, prenom_ch, type_permis, add_ch,"
                    + " tel_ch, email_ch,id_ch FROM chauffeur");
            Chauffeur c;
            while(rs.next()){
                c = new Chauffeur(rs.getString("nom_ch"), rs.getString("prenom_ch"),
                        rs.getString("type_permis"), rs.getString("add_ch"), 
                        rs.getString("email_ch"), rs.getInt("tel_ch"), rs.getInt("id_ch"));
                listeCh.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        final ObservableList<Chauffeur> data = FXCollections.observableArrayList(
            listeCh
        );
        listeChTv.setItems(data);
    }
    
    private void actualiserListePerso(){
        ArrayList<Personnel> listePerso = new ArrayList<>();
        try {
            Connection con = getConnection();
            stmt = con.createStatement();   
            rs = stmt.executeQuery("SELECT nom_perso, prenom_perso, fonction_perso, "
                    + "add_perso, tel_perso, email_perso, id_perso FROM personnel");
            Personnel p;
            while(rs.next()){
                p = new Personnel(rs.getString("nom_perso"), rs.getString("prenom_perso"), 
                        rs.getString("fonction_perso"), rs.getString("add_perso"), 
                        rs.getInt("tel_perso"), rs.getString("email_perso"), rs.getInt("id_perso"));
                listePerso.add(p);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        final ObservableList<Personnel> data = FXCollections.observableArrayList(
            listePerso
        );
        listePersoTv.setItems(data);
    }
    
    
    private void hide(){
        welcomePanel.setVisible(false);
        connexionPanel.setVisible(false);
        connexionPanel1.setVisible(false);
        gestPersoPanel.setVisible(false);
        gestChPanel.setVisible(false);
        gestVhPanel.setVisible(false);
        ajoutVhPanel.setVisible(false);
        ajoutChPanel.setVisible(false);
        ajoutPersoPanel.setVisible(false);
        modifVhPanel.setVisible(false);
        modifChPanel.setVisible(false);
        modifPersoPanel.setVisible(false);
        gestUserPanel.setVisible(false);
        activitePanel.setVisible(false);
        ajoutActivitePanel.setVisible(false);
    }
    
    @FXML
    private void btnConnexionAction(ActionEvent event) {
        welcomePanel.setVisible(true);
        connexionPanel.setVisible(false);
        connexionPanel1.setVisible(false);
        gestPersoPanel.setVisible(false);
        gestChPanel.setVisible(false);
    }

    @FXML
    private void btnMenu(ActionEvent event) {
        System.out.println(((Button)event.getSource()).getText());
        btnGvh.setStyle("-fx-background-color:  #0090f3;");
        btnGch.setStyle("-fx-background-color:  #0090f3;");
        btnGpr.setStyle("-fx-background-color:  #0090f3;");
        btnActivite.setStyle("-fx-background-color:  #0090f3;");
        btnGur.setStyle("-fx-background-color:  #0090f3;");
        ((Button)event.getSource()).setStyle("-fx-background-color:  #0040ff;");
        btnGvh.setStyle("/css/cssBtn.css");
        btnGch.setStyle("/css/cssBtn.css");
        btnGpr.setStyle("/css/cssBtn.css");
        btnActivite.setStyle("/css/cssBtn.css");
        btnGur.setStyle("/css/cssBtn.css");
        ((Button)event.getSource()).setStyle("-fx-background-color:  #0040ff;");
        
        if(((Button)event.getSource()).getText().equals("Gerer le personnel")){
            hide();
            gestPersoPanel.setVisible(true);
        }else if(((Button)event.getSource()).getText().equals("Gerer les chauffeurs")){
            hide();
            gestChPanel.setVisible(true);
        }else if(((Button)event.getSource()).getText().equals("Gerer les vehicules")){
            hide();
            gestVhPanel.setVisible(true);            
        }else if(((Button)event.getSource()).getText().equals("Gerer les utilisateurs")){
            hide();
            gestUserPanel.setVisible(true);
        }else if(((Button)event.getSource()).getText().equals("Activités")){
            hide();
            activitePanel.setVisible(true);            
        }
        
        
    }
    
    
    @FXML
    private void lblDeconnexion(MouseEvent event) throws IOException {
        //Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml"));
        Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
        st.close();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Connexion.fxml"));
        Stage stage = new Stage();//Gerer les utilisateurs
        Scene scene = new Scene(root);
        stage.setTitle("GestPauSup");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ajoutVh(ActionEvent event) {
        hide();
        ajoutVhPanel.setVisible(true);
//        AlertDialogController ad = new AlertDialogController();
//        ad.AlertD();
    }

    @FXML
    private void ajoutCh(ActionEvent event) {
        hide();
        ajoutChPanel.setVisible(true);
    }

    @FXML
    private void ajoutPerso(ActionEvent event) {
        hide();
        ajoutPersoPanel.setVisible(true);
    }

    @FXML
    private void ajoutVhValidation(ActionEvent event) {
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO vehicule VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, immatriculation.getText());
            ps.setString(2, modele.getText());
            ps.setString(3, type.getText());
            ps.setInt(4, Integer.valueOf(nbrPlace.getText()));
            ps.setString(5, numCatreGrise.getText());
            ps.executeUpdate();
            immatriculation.setText("");
            type.setText("");
            modele.setText("");
            nbrPlace.setText("");
            numCatreGrise.setText("");   
            hide();
            gestVhPanel.setVisible(true);
            con.close();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            System.out.println("Duplicata de cle 1");
        }catch(SQLException e){
            String msg = e.getMessage();
            if(msg.contains("PRIMARY")){
                System.out.println("Duplicata de cle");
                
                //JOptionPane.showConfirmDialog(this, "");
            }
            //System.out.println(e.getMessage());
        }
        actualiserListeVh();
    }
    
    public Connection getConnection(){
        Connection con = null;
        try{
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestpausup", "root", "");
            System.out.println("Connexion a la bd etablie");
            return con;
        } catch (SQLException ex) {
            System.out.println("Echec de Connexion a la bd");
           return null;
        }
    }

    @FXML
    private void clicVhTv(MouseEvent event) {
        try{
            System.out.println(listeVhTv.getSelectionModel().selectedItemProperty().get().getImmatriculation());
        }catch(NullPointerException np){
            System.out.println(np);
        }
    }

    @FXML
    private void ajoutChValidation(ActionEvent event) {
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO "
                    + "chauffeur(nom_ch, prenom_ch, type_permis, add_ch, tel_ch, email_ch) "
                    + "VALUES(?, ?, ?, ?, ?, ?)");
            ps.setString(1, nomChTf.getText());
            ps.setString(2, prenomChTf.getText());
            ps.setString(3, typePermisCb.getSelectionModel().getSelectedItem());
            ps.setString(4, adressChTf.getText());
            ps.setInt(5, Integer.valueOf(telChTf.getText()));
            ps.setString(6, emailChTf.getText());
            ps.executeUpdate();
            nomChTf.setText("");
            prenomChTf.setText("");
            adressChTf.setText("");
            telChTf.setText("");
            emailChTf.setText("");
            hide();
            gestChPanel.setVisible(true);
            con.close();
            System.out.println("Y'a quoi ???????");
        } catch (MySQLIntegrityConstraintViolationException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            System.out.println("Duplicata de cle 1");
        }catch(SQLException e){
            String msg = e.getMessage();
            if(msg.contains("PRIMARY")){
                System.out.println("Duplicata de cle");
                
                //JOptionPane.showConfirmDialog(this, "");
            }
            //System.out.println(e.getMessage());
        }
        actualiserListeCh();
    }

    @FXML
    private void ajoutPersoValidation(ActionEvent event) throws IOException {
        if(!nomPersoTf.getText().isEmpty() && !prenomPersoTf.getText().isEmpty() && 
                !fonctionPersoTf.getText().isEmpty() && !adressPersoTf.getText().isEmpty() 
                && !telPersoTf.getText().isEmpty() && !emailPersoTf.getText().isEmpty()){
            try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO "
                    + "personnel(nom_perso, prenom_perso, fonction_perso, "
                    + "add_perso, tel_perso, email_perso) VALUES(?, ?, ?, ?, ?, ?)");
           
            ps.setString(1, nomPersoTf.getText());
            ps.setString(2, prenomPersoTf.getText());
            ps.setString(3, fonctionPersoTf.getText());
            ps.setString(4, adressPersoTf.getText());
            ps.setInt(5, Integer.valueOf(telPersoTf.getText()));
            ps.setString(6, emailPersoTf.getText());
            ps.executeUpdate();
            nomPersoTf.setText("");
            prenomPersoTf.setText("");
            fonctionPersoTf.setText("");
            adressPersoTf.setText("");
            telPersoTf.setText("");
            emailPersoTf.setText("");
            hide();
            gestPersoPanel.setVisible(true);
            con.close();
            System.out.println("Y'a quoi ???????");
        } catch (MySQLIntegrityConstraintViolationException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            System.out.println("Duplicata de cle 1");
        }catch(SQLException e){
            String msg = e.getMessage();
            if(msg.contains("PRIMARY")){
                System.out.println("Duplicata de cle");
                
                //JOptionPane.showConfirmDialog(this, "");
            }
            //System.out.println(e.getMessage());
        }
        actualiserListePerso();
        }else{
             dialog("Veuillez remplir tous les champs !!", false);
        }
        
    }

    @FXML
    private void ModifVhValidation(ActionEvent event) {
       try{
           Vehicule v = listeVhTv.getSelectionModel().getSelectedItem();
            Connection con = getConnection();
            String imt = v.getImmatriculation();
            PreparedStatement ps1 = con.prepareStatement("DELETE FROM vehicule WHERE immatriculation = ?");
            ps1.setString(1, imt);
            ps1.executeUpdate();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO vehicule VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, tfmImmatVh.getText());
            ps.setString(2, tfmModelVh.getText());
            ps.setString(3, tfmTypeVh.getText());
            ps.setInt(4, Integer.valueOf(tfmNbrPlaceVh.getText()));
            ps.setString(5, tfmNumCarteGriseVh.getText());
            ps.executeUpdate();
            tfmImmatVh.setText("");
            tfmTypeVh.setText("");
            tfmModelVh.setText("");
            tfmNbrPlaceVh.setText("");
            tfmNumCarteGriseVh.setText("");   
            hide();
            gestVhPanel.setVisible(true);
            con.close();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            System.out.println("Duplicata de cle 1");
        }catch(SQLException e){
            String msg = e.getMessage();
            if(msg.contains("PRIMARY")){
                System.out.println("Duplicata de cle");
                
                //JOptionPane.showConfirmDialog(this, "");
            }
            //System.out.println(e.getMessage());
        }
        actualiserListeVh();
        //listeVhTv.getSelectionModel().selectedItemProperty().get().getImmatriculation()
        
    }

    @FXML
    private void modifVh(ActionEvent event) {
        try{
            if(!listeVhTv.getSelectionModel().getSelectedItem().getImmatriculation().equals("")){
                
                Vehicule v = listeVhTv.getSelectionModel().getSelectedItem();
                tfmImmatVh.setText(v.getImmatriculation());
                tfmTypeVh.setText(v.getType());
                tfmModelVh.setText(v.getModele());
                tfmNbrPlaceVh.setText(String.valueOf(v.getNbrPlace()));
                tfmNumCarteGriseVh.setText(v.getNumCatreGrise());
                
                lblmImmatVh.setText(v.getImmatriculation());
                lblmModelVh.setText(v.getModele());
                lblmTypeVh.setText(v.getType());
                lblmNbrPlaceVh.setText(String.valueOf(v.getNbrPlace()));
                lblmNumCarteGriseVh.setText(v.getNumCatreGrise());
                hide();
                modifVhPanel.setVisible(true);
            }else{
                System.out.println("Is Empty !!");
            }
        }catch(NullPointerException np){
            System.out.println(np);
        }
        
    }

    @FXML
    private void ModifChValidation(ActionEvent event) {
        try{
           Chauffeur c = listeChTv.getSelectionModel().getSelectedItem();
            Connection con = getConnection();
            int imt = c.getId_ch();
            PreparedStatement ps1 = con.prepareStatement("DELETE FROM chauffeur WHERE id_ch = ?");
            ps1.setInt(1, imt);
            ps1.executeUpdate();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO "
                    + "chauffeur(nom_ch, prenom_ch, type_permis, add_ch, tel_ch, email_ch) "
                    + "VALUES(?, ?, ?, ?, ?, ?)");
            ps.setString(1, tfmNomCh.getText());
            ps.setString(2, tfmPrenomCh.getText());
            ps.setString(3, typePermisCb1.getSelectionModel().getSelectedItem());
            ps.setString(4, tfmAdresseCh.getText());
            ps.setInt(5, Integer.valueOf(tfmTelCh.getText()));
            ps.setString(6, tfmEmailCh.getText());
            ps.executeUpdate();
            tfmNomCh.setText("");
            tfmPrenomCh.setText("");
            tfmAdresseCh.setText("");
            tfmTelCh.setText("");
            tfmEmailCh.setText("");   
            hide();
            gestChPanel.setVisible(true);
            con.close();
        } catch (MySQLIntegrityConstraintViolationException ex) {
            //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            System.out.println("Duplicata de cle 1");
        }catch(SQLException e){
            String msg = e.getMessage();
            if(msg.contains("PRIMARY")){
                System.out.println("Duplicata de cle");
                
                //JOptionPane.showConfirmDialog(this, "");
            }
            //System.out.println(e.getMessage());
        }
        actualiserListeCh();
        //listeVhTv.getSelectionModel().selectedItemProperty().get().getImmatriculation()
        
    }

    @FXML
    private void ModifPersoValidation(ActionEvent event) throws IOException {
        dialog("Voullez vouus vraiment modifier ?", true);
        if(AlertDialogController.isO()){
                try{
               Personnel c = listePersoTv.getSelectionModel().getSelectedItem();
                Connection con = getConnection();
                int imt = c.getId_perso();
                PreparedStatement ps1 = con.prepareStatement("DELETE FROM personnel WHERE id_perso = ?");
                ps1.setInt(1, imt);
                ps1.executeUpdate();

                PreparedStatement ps = con.prepareStatement("INSERT INTO "
                        + "personnel(nom_perso, prenom_perso, fonction_perso, "
                        + "add_perso, tel_perso, email_perso) "
                        + "VALUES(?, ?, ?, ?, ?, ?)");
                ps.setString(1, tfmNomPerso.getText());
                ps.setString(2, tfmPrenomPerso.getText());
                ps.setString(3, tfmFonctPerso.getText());
                ps.setString(4, tfmAdressePerso.getText());
                ps.setInt(5, Integer.valueOf(tfmTelPerso.getText()));
                ps.setString(6, tfmEmailPerso.getText());
                ps.executeUpdate();
                tfmNomPerso.setText("");
                tfmPrenomPerso.setText("");
                tfmFonctPerso.setText("");
                tfmAdressePerso.setText("");
                tfmTelPerso.setText("");
                tfmEmailPerso.setText("");   
                hide();
                gestPersoPanel.setVisible(true);
                con.close();
            } catch (MySQLIntegrityConstraintViolationException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
                System.out.println("Duplicata de cle 1");
            }catch(SQLException e){
                String msg = e.getMessage();
                if(msg.contains("PRIMARY")){
                    System.out.println("Duplicata de cle");

                    //JOptionPane.showConfirmDialog(this, "");
                }
                //System.out.println(e.getMessage());
            }
            actualiserListePerso();
        }else{
            hide();
            gestPersoPanel.setVisible(true);
        }
        
    }

    @FXML
    private void modifCh(ActionEvent event) {
        try{
            
            
            if(listeChTv.getSelectionModel().getSelectedItem().getId_ch()>0){
                
                Chauffeur c = listeChTv.getSelectionModel().getSelectedItem();
                tfmNomCh.setText(c.getNom());
                tfmPrenomCh.setText(c.getPrenom());
                typePermisCb1.setValue(c.getTypePermis());
                tfmAdresseCh.setText(c.getAdresse());
                tfmTelCh.setText(String.valueOf(c.getTel()));
                tfmEmailCh.setText(c.getEmail());
                
                lblmNomCh.setText(c.getNom());
                lblmPrenomCh.setText(c.getPrenom());
                lblmTypePermisCh.setText(c.getTypePermis());
                lblmAdresseCh.setText(c.getAdresse());
                lblmTelCh.setText(String.valueOf(c.getTel()));
                lblmEmailCh.setText(c.getEmail());
                hide();
                modifChPanel.setVisible(true);
            }else{
                System.out.println("Is Empty !!");
            }
        }catch(NullPointerException np){
            System.out.println(np);
        }
        
        
    }

    @FXML
    private void modifPerso(ActionEvent event) {
        try{
            
            
            if(listePersoTv.getSelectionModel().getSelectedItem().getId_perso()>0){
                
                Personnel p = listePersoTv.getSelectionModel().getSelectedItem();
                tfmNomPerso.setText(p.getNom());
                tfmPrenomPerso.setText(p.getPrenom());
                tfmFonctPerso.setText(p.getFonction());
                tfmAdressePerso.setText(p.getAdresse());
                tfmTelPerso.setText(String.valueOf(p.getTel()));
                tfmEmailPerso.setText(p.getEmail());
                
                lblmNomPerso.setText(p.getNom());
                lblmPrenomPerso.setText(p.getPrenom());
                lblmFonctPerso.setText(p.getFonction());
                lblmAdressePerso.setText(p.getAdresse());
                lblmTelPerso.setText(String.valueOf(p.getTel()));
                lblmEmailPerso.setText(p.getEmail());
                hide();
                modifPersoPanel.setVisible(true);
            }else{
                System.out.println("Is Empty !!");
            }
        }catch(NullPointerException np){
            System.out.println(np);
        }
    }

    @FXML
    private void deleteVh(ActionEvent event) throws SQLException, IOException {
        setMsg("Voulez vous vraiment supprimer ce vehicule ?");
        on = true;
       Parent root = FXMLLoader.load(getClass().getResource("/fxml/AlertDialog.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        if(AlertDialogController.isO()){
            Vehicule v = listeVhTv.getSelectionModel().getSelectedItem();
            Connection con = getConnection();
            String imt = v.getImmatriculation();
            PreparedStatement ps1 = con.prepareStatement("DELETE FROM vehicule WHERE immatriculation = ?");
            ps1.setString(1, imt);
            ps1.executeUpdate();
            con.close();
            actualiserListeVh();
        }else if(AlertDialogController.isN()){
            System.out.println("pas de suppression");
        }
        
    }

    @FXML
    private void deleteCh(ActionEvent event) throws SQLException, IOException {
        setMsg("Voulez vous vraiment supprimer ce Chauffeur ?");
        on = true;
       Parent root = FXMLLoader.load(getClass().getResource("/fxml/AlertDialog.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        if(AlertDialogController.isO()){
        Chauffeur c = listeChTv.getSelectionModel().getSelectedItem();
            Connection con = getConnection();
            int imt = c.getId_ch();
            PreparedStatement ps1 = con.prepareStatement("DELETE FROM chauffeur WHERE id_ch = ?");
            ps1.setInt(1, imt);
            ps1.executeUpdate();
            con.close();
            actualiserListeCh();
        }else if(AlertDialogController.isN()){
            System.out.println("pas de suppression");
        }
    }

    @FXML
    private void deletePerso(ActionEvent event) throws SQLException, IOException {
        setMsg("Voulez vous vraiment supprimer ce membre du personnel ?");
        on = true;
       Parent root = FXMLLoader.load(getClass().getResource("/fxml/AlertDialog.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        if(AlertDialogController.isO()){
            Personnel c = listePersoTv.getSelectionModel().getSelectedItem();
            Connection con = getConnection();
            int imt = c.getId_perso();
            PreparedStatement ps1 = con.prepareStatement("DELETE FROM personnel WHERE id_perso = ?");
            ps1.setInt(1, imt);
            ps1.executeUpdate();
            con.close();
            actualiserListePerso();
        }else if(AlertDialogController.isN()){
            System.out.println("pas de suppression");
        }
    }

    @FXML
    private void printPersoList(ActionEvent event) throws FileNotFoundException, IOException {
          Document document = new Document();
    try 
    {
      PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\DYLAN\\Documents\\NetBeansProjects\\GestPauSup\\src\\pdf/ListePerso.pdf"));//C:\\Users\\DYLAN\\Documents\\GestPauSup\\src\\pdf
      document.open();
      document.add(tabPerso());
    } catch (DocumentException de) {
      de.printStackTrace();
    }
    document.close();
    setMsg("Impression de la liste du Personnel reussie !!!");
        on = false;
       Parent root = FXMLLoader.load(getClass().getResource("/fxml/AlertDialog.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public PdfPTable tabPerso(){
      //On créer un objet table dans lequel on intialise ça taille.
      PdfPTable table = new PdfPTable(6);
      
      //On créer l'objet cellule.
      PdfPCell cell;
      
      cell = new PdfPCell(new Phrase("Liste du Personnel"));
      cell.setColspan(6);
      cell.setRowspan(2);
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("         "));
      cell.setColspan(6);
      cell.setRowspan(2);
      table.addCell(cell);
      
      
      listePersoTv.getSelectionModel().getSelectedItem();
      ObservableList ol = listePersoTv.getItems();
//      Personnel p = (Personnel) ol.get(0);
//        System.out.println("\nLa taille est "+ol.size()+"\n");
//        System.out.println("Le nom du prem est "+ol.toString()+"   "+p.getNom());
            table.addCell("Nom");
            table.addCell("Prenom");
            table.addCell("Fonction");
            table.addCell("Adresse");
            table.addCell("Telephone");
            table.addCell("E-mail");
        for(int i=0; i < ol.size(); i++){
            Personnel p = (Personnel) ol.get(i);
            table.addCell(p.getNom());
            table.addCell(p.getPrenom());
            table.addCell(p.getFonction());
            table.addCell(p.getAdresse());
            table.addCell(String.valueOf(p.getTel()));
            table.addCell(p.getEmail());
            
        }
        
      return table;  
    }

    @FXML
    private void printChList(ActionEvent event) throws FileNotFoundException, IOException {
            Document document = new Document();
       try 
       {
         PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\DYLAN\\Documents\\NetBeansProjects\\GestPauSup\\src\\pdf/listeCh.pdf"));//C:\\Users\\DYLAN\\Documents\\GestPauSup\\src\\pdf
         document.open();

         document.add(tabCh());
       } catch (DocumentException de) {
         de.printStackTrace();
       }

       document.close();
       setMsg("Impression de la liste des chauffeurs reussie !!!");
        on = false;
       Parent root = FXMLLoader.load(getClass().getResource("/fxml/AlertDialog.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public PdfPTable tabCh(){
      //On créer un objet table dans lequel on intialise ça taille.
      PdfPTable table = new PdfPTable(6);
      
      //On créer l'objet cellule.
      PdfPCell cell;
      
      cell = new PdfPCell(new Phrase("Liste de chauffeurs"));
      cell.setColspan(6);
      cell.setRowspan(2);
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("         "));
      cell.setColspan(6);
      cell.setRowspan(2);
      table.addCell(cell);
      
      
      listeChTv.getSelectionModel().getSelectedItem();
      ObservableList ol = listeChTv.getItems();
//      Personnel p = (Personnel) ol.get(0);
//        System.out.println("\nLa taille est "+ol.size()+"\n");
//        System.out.println("Le nom du prem est "+ol.toString()+"   "+p.getNom());
            table.addCell("Nom");
            table.addCell("Prenom");
            table.addCell("Type de permis");
            table.addCell("Adresse");
            table.addCell("Telephone");
            table.addCell("E-mail");
        for(int i=0; i < ol.size(); i++){
            Chauffeur p = (Chauffeur) ol.get(i);
            table.addCell(p.getNom());
            table.addCell(p.getPrenom());
            table.addCell(p.getTypePermis());
            table.addCell(p.getAdresse());
            table.addCell(String.valueOf(p.getTel()));
            table.addCell(p.getEmail());
            
        }
        
      return table;  
    }

    @FXML
    private void printVhList(ActionEvent event) throws FileNotFoundException, IOException {
            Document document = new Document();
       try 
       {
         PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\DYLAN\\Documents\\NetBeansProjects\\GestPauSup\\src\\pdf/listeVh.pdf"));//C:\\Users\\DYLAN\\Documents\\GestPauSup\\src\\pdf
         document.open();

         document.add(tabVh());
       } catch (DocumentException de) {
         de.printStackTrace();
       }

       document.close();
       setMsg("Impression de la liste des Vehicules reussie !!!");
        on = false;
       Parent root = FXMLLoader.load(getClass().getResource("/fxml/AlertDialog.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static String getMsg() {
        return msg;
    }

    public static void setMsg(String msg) {
        FXMLDocumentController.msg = msg;
    }
    public PdfPTable tabVh(){
      //On créer un objet table dans lequel on intialise ça taille.
      PdfPTable table = new PdfPTable(5);
      
      //On créer l'objet cellule.
      PdfPCell cell;
      
      cell = new PdfPCell(new Phrase("Liste de Vehicules"));
      cell.setColspan(5);
      cell.setRowspan(2);
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("         "));
      cell.setColspan(5);
      cell.setRowspan(2);
      table.addCell(cell);
      
      
      listeVhTv.getSelectionModel().getSelectedItem();
      ObservableList ol = listeVhTv.getItems();
//      Personnel p = (Personnel) ol.get(0);
//        System.out.println("\nLa taille est "+ol.size()+"\n");
//        System.out.println("Le nom du prem est "+ol.toString()+"   "+p.getNom());
            table.addCell("IMMATRICULATION");
            table.addCell("MODELE");
            table.addCell("TYPE");
            table.addCell("NOMBRE DE PLACE");
            table.addCell("NUMERO DE CARTE GRISE");
            
        for(int i=0; i < ol.size(); i++){
            Vehicule p = (Vehicule) ol.get(i);
            table.addCell(p.getImmatriculation());
            table.addCell(p.getModele());
            table.addCell(p.getType());
            table.addCell(String.valueOf(p.getNbrPlace()));
            table.addCell(String.valueOf(p.getNumCatreGrise()));
            
        }
        
      return table;  
    }
    public void dialog(String msg,boolean b) throws IOException{
        on=b;
        setMsg(msg);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AlertDialog.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void retourVh(ActionEvent event) {
        hide();
        gestVhPanel.setVisible(true);
    }

    @FXML
    private void retourPerso(ActionEvent event) {
        hide();
        gestPersoPanel.setVisible(true);
    }

    @FXML
    private void retourCh(ActionEvent event) {
        hide();
        gestChPanel.setVisible(true);
    }

    @FXML
    private void ajoutUser(ActionEvent event) {
    }

    @FXML
    private void modifUser(ActionEvent event) {
    }

    @FXML
    private void printUserList(ActionEvent event) {
    }

    @FXML
    private void deleteUser(ActionEvent event) {
    }

    @FXML
    private void ajoutAc(ActionEvent event) {
        hide();
        ajoutActivitePanel.setVisible(true);
    }

    @FXML
    private void modifAc(ActionEvent event) {
    }

    @FXML
    private void printAcList(ActionEvent event) {
    }

    @FXML
    private void deleteAc(ActionEvent event) {
    }

    @FXML
    private void ajoutActiviteValidation(ActionEvent event) {
    }
}
