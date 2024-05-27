package org.example.IHM;

import org.example.Entity.Adresse;
import org.example.Repository.AdressRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class IHM_Adresse {

    private Scanner sc ;
    private AdressRepository adressRepository;


    public IHM_Adresse(Scanner sc, EntityManager em) {
        this.sc = sc;
        adressRepository = new AdressRepository(em);

    }

    public void start() {
        while (true) {
            System.out.println("Menu Adresse: ");
            System.out.println("1/ cree");
            System.out.println("2/ afficher tout");
            System.out.println("3/ afficher par id");
            System.out.println("4/ supprimer");
            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry) {
                case 1:
                    createAdress();
                    break;
                case 2:
                    getAllAdresse();
                    break;
                case 3:
                    getAdresseById();
                    break;
               case 4:
                    deleteAdresse();
                    break;
//                case 5:
//                    editProduct();
//                    break;

                default:
                    return;
            }
        }

    }

    private void deleteAdresse() {
        System.out.println("id de l'adresse");
        int id = sc.nextInt();
        sc.nextLine();

        Adresse adresse = adressRepository.findById(id);
        if(adresse != null){
            adressRepository.delete(adresse);
        }else{
            System.out.println("aucun produit trouvé");
        }
    }

    private void getAdresseById() {
        System.out.println("id de l'adresse : ");
        int id = sc.nextInt();
        sc.nextLine();

        Adresse adresse = adressRepository.findById(id);
        if(adresse != null){
            System.out.println(adresse);
        }else {
            System.out.println("aucune adresse trouvé");
        }
    }

    private void getAllAdresse() {
        List<Adresse> adresses = adressRepository.findAll();

        for (Adresse adresse : adresses){
            System.out.println(adresse);
        }
    }

    private void createAdress() {
        System.out.println("Veuillez indiquez la rue");

        String rue = sc.nextLine();

        System.out.println("Veuillez indiquez la ville");

        String ville = sc.nextLine();

        Adresse adresse = Adresse.builder().ville(ville).rue(rue).build();
        adressRepository.save(adresse);
    }
}
