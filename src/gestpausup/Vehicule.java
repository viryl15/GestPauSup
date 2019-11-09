package gestpausup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DYLAN
 */
public class Vehicule {
    private String immatriculation, modele, type, numCatreGrise;
    private int nbrPlace;

    public Vehicule(String immatriculation, String modele, String type, int nbrPlace, String numCatreGrise) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.type = type;
        this.nbrPlace = nbrPlace;
        this.numCatreGrise = numCatreGrise;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public String getNumCatreGrise() {
        return numCatreGrise;
    }

    public void setNumCatreGrise(String numCatreGrise) {
        this.numCatreGrise = numCatreGrise;
    }
    
}
