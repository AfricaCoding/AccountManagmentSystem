package com.godsonbank.app;

import com.godsonbank.app.entity.CompteCourant;
import com.godsonbank.app.entity.CompteEpargne;
import com.godsonbank.app.entity.Transaction;
import com.godsonbank.app.entity.TypeTransaction;

public class Main {
    public static void main(String[] args) {
        CompteCourant compteCourant = new CompteCourant(1000,500);
        CompteEpargne compteEpargne = new CompteEpargne(2000,1.5);
        System.out.println("\n******************* transaction1 ************************** ");

        Transaction transaction1 = new Transaction(compteCourant);

        transaction1.enregistrerTransaction(TypeTransaction.DEPOT, 200, null);


        compteCourant.retrait(1500);
        compteCourant.verifierDecouvert();

        System.out.println("\n******************* transaction2 ************************** ");
        Transaction transaction2 = new Transaction(compteEpargne);
        transaction2.enregistrerTransaction(TypeTransaction.DEPOT, 1000, null);
//        compteEpargne.depot(1000);

        compteEpargne.calculerInteret();

        compteCourant.transfert(compteEpargne,500);

        System.out.println("\n******************* transaction3 ************************** ");

        Transaction transaction3 = new Transaction(compteCourant);
        transaction3.enregistrerTransaction(TypeTransaction.TRANSFERT,200, compteEpargne);
        System.out.println("\n******************* historique transactions ************************** ");
        Transaction.afficherHistorique();

        transaction1.annulerTransaction();

    }
}