package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String contenu;

    @Temporal(TemporalType.DATE)
    private Date datePublication;

    private int Note;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public int getNote() {
        return Note;
    }

    public void setNote(int note) {
        Note = note;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", contenu='" + contenu + '\'' +
                ", datePublication=" + datePublication +
                ", Note=" + Note +
                ", produit=" + produit +
                '}';
    }
}
