package com.godsonbank.app.entity;

public class Compte {

    protected double solde;

    public Compte(double solde) {
        this.solde = solde;
    }

    public void depot(double montant) {
        if (montant > 0) {
            this.solde += montant;
            System.out.println("classe: Compte -> Depot effectue. Nouveau solde: $" + this.solde);
        } else {
            System.out.println("classe: Compte -> Le montant du depot doit etre superieur a 0");
        }
    }

    public void retrait(double montant) {
        if (montant > 0 && montant <= this.solde) { // montant <= this.solde
            this.solde -= montant; // this.solde = this.solde - montant
            System.out.println("classe: Compte -> Retrait effectue. Nouveau solde $" + this.solde);
        } else {
            System.out.println("classe: Compte -> Retrait impossible. Fonds insuffisants ou invalide");
        }
    }

    public void transfert(Compte compteDestination, double montant) {
        if (montant > 0 && montant <= this.solde) {  // this.solde >= montant
            this.solde -= montant; // this.solde = this.solde - montant
            compteDestination.depot(montant);
            System.out.println("classe: Compte -> Transfert de $" + montant + " effectue vers le compte destination. Nouveau solde $" + this.solde);
        } else {
            System.out.println("classe: Compte -> Transfert echoue. Fonds insuffisants ou invalide");
        }
    }

    public double getSolde() {
        return solde;
    }
}
