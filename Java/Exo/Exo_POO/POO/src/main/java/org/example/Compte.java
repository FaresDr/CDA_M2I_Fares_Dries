package org.example;



import java.util.List;

public abstract class Compte {

    public double solde;

    private String client ;

    private List<String> Operation;

    public Compte(double solde, String client, List<String> operation) {
        this.solde = solde;
        this.client = client;
        this.Operation = operation;
    }
}
