package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder

public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numberPlace;

    @OneToOne
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_evenement")
    private Evenement evenement;

    private String typePlace;

    @Override
    public String toString() {
        return "Billet{" +
                "id=" + id +
                ", numberPlace=" + numberPlace +
                ", client=" + client +
                ", evenement=" + evenement +
                ", typePlace='" + typePlace + '\'' +
                '}';
    }

    public Billet() {

    }
}
