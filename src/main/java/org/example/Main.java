package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Création de quelques livres
        Livre livre1 = new Livre("Le Seigneur des Anneaux", 15.99, "J.R.R. Tolkien", 10);
        Livre livre2 = new Livre("Harry Potter", 12.50, "J.K. Rowling", 20);
        Livre livre3 = new Livre("1984", 9.99, "George Orwell", 15);

        // Création d'un client
        Client client = new Client("John Doe", 0.1);

        // Initialisation du panier pour ce client
        Panier panier = new Panier(client);

        // Ajout de livres dans le panier
        panier.ajouterLivre(livre1, 2);
        panier.ajouterLivre(livre2, 1);
        panier.ajouterLivre(livre3, 3);

        // Affichage du panier et de la facture
        System.out.println("Contenu du Panier:");
        for (Map.Entry<Livre, Integer> entry : panier.getItems().entrySet()) {
            System.out.println(entry.getKey() + " Quantité: " + entry.getValue());
        }
        System.out.println("\nFacture:");
        System.out.println(panier.genererFacture());
    }
}
