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
public class Chauffeur {
    private String nom, prenom, typePermis, adresse, email;
    private int tel;
    private int id_ch;

    public Chauffeur(String nom, String prenom, String typePermis, String adresse, String email, int tel, int id_ch) {
        this.nom = nom;
        this.prenom = prenom;
        this.typePermis = typePermis;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.id_ch = id_ch;
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

    public String getTypePermis() {
        return typePermis;
    }

    public void setTypePermis(String typePermis) {
        this.typePermis = typePermis;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getId_ch() {
        return id_ch;
    }

    public void setId_ch(int id_ch) {
        this.id_ch = id_ch;
    }

    
    
}
