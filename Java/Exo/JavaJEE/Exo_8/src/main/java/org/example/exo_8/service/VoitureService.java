package org.example.exo_8.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.exo_8.Voiture;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VoitureService {

    List<Voiture> voitureList = new ArrayList<>();

    public Voiture save(int id,String marque,String modele,String annee,String couleur){
        voitureList.add(new Voiture(id,marque,modele,annee,couleur));
        return new Voiture(id,marque,modele,annee,couleur);
    }

    public List<Voiture> getVoitureList(){
        return voitureList;
    }
}
