package model;

import java.sql.Date;

public class LotCommande {

    private int id;

    private int quantite;

    private String etat;

    private Date dateEnvoie;

    private Date dateValidation;

    private String nomAgence;

    private int idAgence;

    public LotCommande(int id, String etat, Date dateEnvoie, Date dateValidation, String nomAgence, int idAgence, int quantite){

        this.id = id;

        this.etat = etat;

        this.dateEnvoie = dateEnvoie;

        this.dateValidation = dateValidation;

        this.nomAgence = nomAgence;

        this.quantite = quantite;

        this.idAgence = idAgence;
    }

    public Date getDateEnvoie() {
        return dateEnvoie;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public int getId() {
        return id;
    }

    public String getEtat() {
        return etat;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getIdCommande() {
        return idAgence;
    }

    public void setDateEnvoie(Date dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setIdCommande(int idCommande) {
        this.idAgence = idCommande;
    }
}

