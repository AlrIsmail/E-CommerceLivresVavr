package org.example;

import java.util.HashMap;
import java.util.Map;

// Classe représentant un panier d'achats
public class Panier {
    private final Map<Livre, Integer> items;
    private final Client client;

    public Panier(Client client) {
        this.client = client;
        this.items = new HashMap<>();
    }

    // Ajouter un livre dans le panier
    public void ajouterLivre(Livre livre, int quantite) {
        int newQuantite = items.getOrDefault(livre, 0) + quantite;
        items.put(livre, newQuantite);
    }

    // Retirer un livre du panier
    public void retirerLivre(Livre livre, int quantite) {
        int currentQuantite = items.getOrDefault(livre, 0);
        if (quantite >= currentQuantite) {
            items.remove(livre);
        } else {
            items.put(livre, currentQuantite - quantite);
        }
    }

    // Vider le panier
    public void viderPanier() {
        items.clear();
    }

    // Calculer le prix total du panier
    public double calculerPrixTotal() {
        double total = 0.0;
        for (Map.Entry<Livre, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrix() * entry.getValue();
        }
        return total;
    }

    // Générer une facture
    public String genererFacture() {
        StringBuilder sb = new StringBuilder();
        sb.append("Facture pour ").append(client.getNomComplet()).append(" :\n");
        for (Map.Entry<Livre, Integer> entry : items.entrySet()) {
            Livre livre = entry.getKey();
            int quantite = entry.getValue();
            sb.append(livre.getTitre()).append(" (").append(quantite).append(") : ").append(livre.getPrix() * quantite).append("\n");
        }
        sb.append("Total : ").append(calculerPrixTotal());
        return sb.toString();
    }

    public Map<Livre, Integer> getItems() {
        return items;
    }

    public int getQuantite(Livre livre1) {
        return items.getOrDefault(livre1, 0);
    }
}
