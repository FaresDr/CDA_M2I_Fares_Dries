package org.example.exo_8;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exo_8.service.VoitureService;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;


@Path("/cars")
public class VoitureRessource {

    private final VoitureService voitureService;


    @Inject
    public VoitureRessource(VoitureService voitureService){
        this.voitureService = voitureService;
    }




    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Voiture getOneCar(@PathParam("id")int id){

        return voitureService.getVoitureList().get(id-1);
            //return new Voiture(1,"Ferrari","La Ferrari", "2012","Rouge");
    }


    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voiture> getOtherPerson() {
        return voitureService.getVoitureList();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture postVoiture(Voiture voiture){
        return voitureService.save(voiture.getId(), voiture.getMarque(), voiture.getModele(), voiture.getAnnee(), voiture.getCouleur());
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture deleteVoiture(@PathParam("id")int id){
      return  voitureService.getVoitureList().remove(id-1);
    }




}
