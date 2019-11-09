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
public class Activite {
    private int ID_ACTIVITE;
    private String TYPE, LIBELLE, DATE_DEPART, DATE_ARRIVEE, DESTINATION, LIEU_DEPART, CHAUFFEUR, VEHICULE;

    public Activite(int ID_ACTIVITE, String TYPE, String LIBELLE, String DATE_DEPART, String DATE_ARRIVEE, String DESTINATION, String LIEU_DEPART, String CHAUFFEUR, String VEHICULE) {
        this.ID_ACTIVITE = ID_ACTIVITE;
        this.TYPE = TYPE;
        this.LIBELLE = LIBELLE;
        this.DATE_DEPART = DATE_DEPART;
        this.DATE_ARRIVEE = DATE_ARRIVEE;
        this.DESTINATION = DESTINATION;
        this.LIEU_DEPART = LIEU_DEPART;
        this.CHAUFFEUR = CHAUFFEUR;
        this.VEHICULE = VEHICULE;
    }

    public int getID_ACTIVITE() {
        return ID_ACTIVITE;
    }

    public void setID_ACTIVITE(int ID_ACTIVITE) {
        this.ID_ACTIVITE = ID_ACTIVITE;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getLIBELLE() {
        return LIBELLE;
    }

    public void setLIBELLE(String LIBELLE) {
        this.LIBELLE = LIBELLE;
    }

    public String getDATE_DEPART() {
        return DATE_DEPART;
    }

    public void setDATE_DEPART(String DATE_DEPART) {
        this.DATE_DEPART = DATE_DEPART;
    }

    public String getDATE_ARRIVEE() {
        return DATE_ARRIVEE;
    }

    public void setDATE_ARRIVEE(String DATE_ARRIVEE) {
        this.DATE_ARRIVEE = DATE_ARRIVEE;
    }

    public String getDESTINATION() {
        return DESTINATION;
    }

    public void setDESTINATION(String DESTINATION) {
        this.DESTINATION = DESTINATION;
    }

    public String getLIEU_DEPART() {
        return LIEU_DEPART;
    }

    public void setLIEU_DEPART(String LIEU_DEPART) {
        this.LIEU_DEPART = LIEU_DEPART;
    }

    public String getCHAUFFEUR() {
        return CHAUFFEUR;
    }

    public void setCHAUFFEUR(String CHAUFFEUR) {
        this.CHAUFFEUR = CHAUFFEUR;
    }

    public String getVEHICULE() {
        return VEHICULE;
    }

    public void setVEHICULE(String VEHICULE) {
        this.VEHICULE = VEHICULE;
    }
    
}
