package org.example.IHM;

import org.example.Entity.Adresse;
import org.example.Entity.Lieu;
import org.example.Repository.AdressRepository;
import org.example.Repository.LieuRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class IHM_Lieu {

    private Scanner sc ;
    private AdressRepository adressRepository;
    private LieuRepository lieuRepository;


    public IHM_Lieu(Scanner sc, EntityManager em) {
        this.sc = sc;
        adressRepository = new AdressRepository(em);
        lieuRepository = new LieuRepository(em);

    }

    public void start() {
        while (true) {
            System.out.println("Menu Lieu: ");
            System.out.println("1/ cree");
            System.out.println("2/ afficher tout");
            System.out.println("3/ afficher par id");
            System.out.println("4/ supprimer");
            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry) {
                case 1:
                    createLieu();
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
        List<Lieu> lieus = lieuRepository.findAll();

        for (Lieu lieu : lieus){
            System.out.println(lieu);
        }
    }

    private void createLieu() {
        System.out.println("Veuillez indiquez l'id de l'adresse");

        int id = sc.nextInt();
        sc.nextLine();

        Adresse adresse = adressRepository.findById(id);

        System.out.println("Veuillez entrer la capacité du lieu ");
        int capacite = sc.nextInt();
        sc.nextLine();

        Lieu lieu = Lieu.builder().ville(adresse.getVille()).rue(adresse.getRue()).capacite(capacite).build();

        lieuRepository.save(lieu);
    }
}
