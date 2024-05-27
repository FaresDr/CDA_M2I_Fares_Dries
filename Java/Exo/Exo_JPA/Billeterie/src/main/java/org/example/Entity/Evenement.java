package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;



@Entity
@Data
@AllArgsConstructor
@SuperBuilder

public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;

    @OneToOne
    private Lieu lieu;

    private String date;
    private String heure;
    private int nbPlaces;

    @OneToMany(mappedBy = "evenement")
    private List<Billet> billets;

    private void add(Billet billet){
        billets.add(billet);
    }





    public Evenement() {

    }
}
