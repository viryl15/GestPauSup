/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestpausup;

/**
 *
 * @author DYLAN
 */
public class Personnel {
    private String nom, prenom, fonction, adresse;
    private int tel;
    private String email;
    private int id_perso;

    public Personnel(String nom, String prenom, String fonction, String adresse, int tel, String email, int id_perso) {
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.id_perso = id_perso;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_perso() {
        return id_perso;
    }

    public void setId_perso(int id_perso) {
        this.id_perso = id_perso;
    }
    
    
}
