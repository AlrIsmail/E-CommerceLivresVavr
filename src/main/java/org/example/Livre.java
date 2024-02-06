package org.example;

public class Livre {
    private final String titre;
    private final double prix;
    private final String auteur;
    private int quantite;

    public Livre(String titre, double prix, String auteur, int quantite) {
        this.titre = titre;
        this.prix = prix;
        this.auteur = auteur;
        this.quantite = quantite;
    }

    public String getTitre() {
        return titre;
    }

    public double getPrix() {
        return prix;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", prix=" + prix +
                ", auteur='" + auteur + '\'' +
                ", quantite=" + quantite +
                '}';
    }
}