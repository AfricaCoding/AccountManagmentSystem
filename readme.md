
#### **3. Système de Gestion de Compte Bancaire**

- **Description :** Créez une application pour gérer différents types de comptes bancaires (épargne, courant) avec des opérations de dépôt, retrait, et transfert.
- **Classes :**
    - **Compte :** Représente un compte bancaire général.
        - `dépôt(double montant)`: Ajoute de l'argent sur le compte.
        - `retrait(double montant)`: Retire de l'argent du compte, s'il y a suffisamment de fonds.
        - `transfert(Compte compteDestination, double montant)`: Transfère de l'argent vers un autre compte.
    - **CompteÉpargne :** Spécialisation de `Compte` avec des fonctionnalités supplémentaires pour l'épargne.
        - `calculerIntérêt()`: Calcule l'intérêt gagné sur le solde du compte en fonction du taux d'intérêt.
    - **CompteCourant :** Spécialisation de `Compte` pour les comptes courants avec découvert autorisé.
        - `vérifierDécouvert()`: Vérifie si le compte est à découvert et applique des frais si nécessaire.
    - **Transaction :** Représente une transaction effectuée sur un compte.
        - `enregistrerTransaction(String type, double montant)`: Enregistre une transaction de dépôt, retrait ou transfert.
        - `annulerTransaction()`: Permet d'annuler une transaction si une erreur a été commise.

- **Logique :**
    - La classe `Compte` gère les opérations bancaires de base comme les dépôts, retraits, et transferts.
    - La classe `CompteÉpargne` calcule l'intérêt sur le solde.
    - La classe `CompteCourant` gère les découverts et les frais associés.
    - La classe `Transaction` enregistre les transactions et permet de les annuler si nécessaire.

---
