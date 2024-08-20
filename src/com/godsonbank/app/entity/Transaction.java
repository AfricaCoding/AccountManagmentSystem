package com.godsonbank.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private TypeTransaction type;
    private double montant;
    private Compte compte;

    private static final List<Transaction> historiqueTransactions = new ArrayList<>();

    public Transaction(Compte compte) {
        this.compte = compte;
    }

    public void enregistrerTransaction(TypeTransaction type, double montant, Compte destination) {

        operationSurCompte(type, montant, destination);
        this.type = type;
        this.montant = montant;
        historiqueTransactions.add(this);
        System.out.println("classe: Transaction -> Transaction enregistree: " + type + " de $" + montant + " sur le compte. Nouveau solde: $" + compte.getSolde());

    }

    private void operationSurCompte(TypeTransaction type, double montant, Compte destination) {
        switch (type){
            case DEPOT:
                this.compte.depot(montant);
                break;
            case RETRAIT:
                this.compte.retrait(montant);
            case TRANSFERT:
                this.compte.transfert(destination, montant);
        }
    }

    public void annulerTransaction() {
        switch (type) {
            case DEPOT:
                compte.retrait(montant);
                break;
            case RETRAIT, TRANSFERT:
                compte.depot(montant);
                break;
            default:
                System.out.println("classe: Transaction -> Une erreur s'est produite");
        }
        System.out.println("classe: Transaction -> Transaction annulee : " + type + " de $" + montant);
    }

    public static void afficherHistorique() {
        for (Transaction transaction : historiqueTransactions) {
            System.out.println("classe: Transaction -> Type " + transaction.type + " de $" + transaction.montant);
        }
    }

    public Compte getCompte() {
        return compte;
    }
}
