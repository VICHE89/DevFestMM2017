package com.africainnovation.viche.budgetprevisionnel;

/**
 * Created by viche on 03/12/2017.
 */

public class Revenu {
    private String designation;
    private String quantite;
    private String prix;
    private String total;

    public Revenu(String designation, String quantite, String prix, String total) {
        this.designation = designation;
        this.quantite = quantite;
        this.prix = prix;
        this.total = total;
    }

    public String getDesignation() {
        return designation;
    }

    public String getQuantite() {
        return quantite;
    }

    public String getPrix() {
        return prix;
    }

    public String getTotal() {
        return total;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
