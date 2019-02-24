package web.model;

import compte.Compte;

public class Guichet {
    private Compte compte;
    private double montant;

    public Guichet(Compte compte) {
        this.compte = compte;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getNumero() {
        return compte.getNumero();
    }

    public String getService() {
        return compte.getService();
    }

    public String getNom() {
        return compte.getNom();
    }

    public String getNumeroTel() {
        return compte.getNumeroTel();
    }

    public double getSolde() {
        return compte.getSolde();
    }

    public void deposer(double montant) {
        compte.deposer(montant);
    }

    public String retirer(double montant) {
        return compte.retirer(montant);
    }
}
