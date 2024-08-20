package com.godsonbank.app.entity;

public class CompteEpargne extends Compte {

    private double tauxInteret; // 10%

    public CompteEpargne(double soldeItinitial, double tauxInteret){
        super(soldeItinitial);
        this.tauxInteret=tauxInteret;
    }
    public void calculerInteret(){
        double interet = getSolde() * tauxInteret/100;
        depot(interet);
        System.out.println("classe: CompteEpargne -> Interet calcule et ajoute au solde: $" + interet );
    }
}
