package org.example.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder
public class Lieu extends Adresse{

  //  @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
   // protected int id;

    private int capacite;

    public Lieu() {
        super();
    }

    @Override
    public String toString() {
        return "Lieu{" +
                "id=" + id +
                ", capacite=" + capacite +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
