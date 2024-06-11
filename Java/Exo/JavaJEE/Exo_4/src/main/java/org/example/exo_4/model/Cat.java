package org.example.exo_4.model;

import java.time.LocalDate;
import java.util.Date;

public class Cat {

    private String nom;

    private String race;

    private LocalDate naissance;

    private String plat;

    public Cat(String nom, String race, LocalDate naissance, String plat) {
        this.nom = nom;
        this.race = race;
        this.naissance = naissance;
        this.plat = plat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public LocalDate getNaissance() {
        return naissance;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "nom='" + nom + '\'' +
                ", race='" + race + '\'' +
                ", naissance=" + naissance +
                ", plat='" + plat + '\'' +
                '}';
    }

    public void setNaissance(LocalDate naissance) {
        this.naissance = naissance;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }
}
