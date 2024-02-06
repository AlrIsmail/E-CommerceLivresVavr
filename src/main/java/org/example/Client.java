package org.example;

public class Client {
    private final String nomComplet;
    private final double reduction;

    public Client(String nomComplet, double reduction) {
        this.nomComplet = nomComplet;
        this.reduction = reduction;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public double getReduction() {
        return reduction;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nomComplet='" + nomComplet + '\'' +
                ", reduction=" + reduction +
                '}';
    }
}