package com.godsonbank.app.entity;

public class CompteCourant extends Compte {

    private final double decouvertAutorise;

    public CompteCourant(double soldeItinitial, double decouvertAutorise) {
        super(soldeItinitial);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retrait(double montant) {
        if (montant > 0 && montant <= (getSolde() + decouvertAutorise)) {
            this.solde -= montant;
            System.out.println("classe: CompteCourant -> Retrait effectue. Nouveau solde $" + (getSolde() + decouvertAutorise));
        } else {
            System.out.println("classe: CompteCourant -> Retrait echoue. Fonds insuffisants, meme avec decouvert.");
        }
    }

    public void transfert(Compte compteDestination, double montant) {
        if (montant > 0 && montant <= (getSolde() + decouvertAutorise)) {  // this.solde >= montant
            this.solde -= montant; // this.solde = this.solde - montant
            compteDestination.depot(montant);
            System.out.println("classe: CompteCourant -> Transfert de $" + montant + " effectue vers le compte destination. Nouveau solde $" + this.solde);
        } else {
            System.out.println("classe: CompteCourant -> Transfert echoue. Fonds insuffisants ou invalide");
        }
    }

    public void verifierDecouvert() {
        if (getSolde() < 0) {
            double frais = 10;
            super.retrait(frais);
            System.out.println("classe: CompteCourant -> Decouvert detecte/ Frais de $" + frais + " appliques.");
        }
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }
}
