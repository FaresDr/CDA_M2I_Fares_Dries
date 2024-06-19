package org.example.exo_8;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;


@Path("/cars")
public class VoitureRessource {





        @GET
        @Path("/one")
        @Produces("application/json")
        public Voiture getOneCar(){

            return new Voiture(1,"Ferrari","La Ferrari", "2012","Rouge");
        }


        @GET
        @Path("")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Voiture> getOtherPerson(){
            List<Voiture> voitureList = new ArrayList<>();
            Voiture v1 = Voiture.builder().annee("2002").id(2).couleur("Noir").modele("Skyline GT-R V-Spec II ").marque("Nissan").build();
            voitureList.add(v1);
            Voiture v2 = Voiture.builder().marque("Toyota Corola").modele("AE86 Trueno").couleur("Panda").id(3).annee("1998").build();
            voitureList.add(v2);
            return voitureList;

        }


}
