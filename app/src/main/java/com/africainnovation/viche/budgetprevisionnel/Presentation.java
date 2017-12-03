package com.africainnovation.viche.budgetprevisionnel;

/**
 * Created by viche on 03/12/2017.
 */

public class Presentation {
    private String nom;
    private String profil;
    private String finalite;
    private String atouts;

    public Presentation(String nom, String profil, String finalite, String atouts) {
        this.nom = nom;
        this.profil = profil;
        this.finalite = finalite;
        this.atouts = atouts;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public void setFinalite(String finalite) {
        this.finalite = finalite;
    }

    public void setAtouts(String atouts) {
        this.atouts = atouts;
    }

    public String getNom() {
        return nom;
    }

    public String getProfil() {
        return profil;
    }

    public String getFinalite() {
        return finalite;
    }

    public String getAtouts() {
        return atouts;
    }
}
