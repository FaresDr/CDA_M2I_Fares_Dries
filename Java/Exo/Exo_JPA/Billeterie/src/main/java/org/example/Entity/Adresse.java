package org.example.Entity;

import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
@SuperBuilder

public  class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String rue;
    protected String ville;


    public Adresse() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
