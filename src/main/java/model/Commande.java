package model;

public class Commande {

    private int id;

    private int idArticle;

    private String nomArticle;

    private int quantite;

    private int idLotDeCommande;

    public Commande(int id, int idArticle, String nomArticle, int quantite, int idLotDeCommande) {
        this.id = id;
        this.nomArticle = nomArticle;
        this.quantite = quantite;
        this.idLotDeCommande = idLotDeCommande;
        this.idArticle = idArticle;
    }

    public int getId() {
        return id;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getIdLotDeCommande() {
        return idLotDeCommande;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setIdLotDeCommande(int idLotDeCommande) {
        this.idLotDeCommande = idLotDeCommande;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }
}
