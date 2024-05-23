package org.example.IHM;

import org.example.Entity.Product_Electronic;
import org.example.Entity.Product_Food;
import org.example.Entity.Product_housing;
import org.example.Repository.FoodRepository;
import org.example.Repository.HousingRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class IHM_Housing {

    private Scanner sc ;
    private HousingRepository housingRepository;


    public IHM_Housing(Scanner sc, EntityManager em) {
        this.sc = sc;
        housingRepository = new HousingRepository(em);

    }


    public void start() {
        while (true) {
            System.out.println("Menu Housing : ");
            System.out.println("1/ cree");
            System.out.println("2/ afficher tout");
            System.out.println("3/ afficher par id");
            System.out.println("4/ supprimer");
            System.out.println("5/ editer");
            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    getAllProducts();
                    break;
                case 3:
                    getProductById();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    editProduct();
                    break;

                default:
                    return;
            }
        }

    }

    private void editProduct() {
    }

    private void deleteProduct() {
        System.out.println("id du produit");
        int id = sc.nextInt();
        sc.nextLine();

        Product_housing peripherique = housingRepository.findById(id);
        if(peripherique != null){
            housingRepository.delete(peripherique);
        }else{
            System.out.println("aucun produit trouvé");
        }
    }

    private void getProductById() {
        System.out.println("id du produit : ");
        int id = sc.nextInt();
        sc.nextLine();

        Product_housing peripherique = housingRepository.findById(id);
        if(peripherique != null){
            System.out.println(peripherique);
        }else {
            System.out.println("aucun produit trouvé");
        }
    }

    private void getAllProducts() {
        List<Product_housing> productElectronics = housingRepository.findAll();

        for (Product_housing peripherique : productElectronics){
            System.out.println(peripherique);
        }
    }

    private void createProduct() {
        System.out.println("Veuillez indiquez le nom du produit");
        String name = sc.nextLine();
        System.out.println("Veuillez indiquez le prix du produit");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Veuillez indiquez la hauteur du produit");
        double height = sc.nextDouble();
        sc.nextLine();
        System.out.println("Veuillez indiquez la largeur du produit");
        double width = sc.nextDouble();
        sc.nextLine();

        Product_housing productFood = Product_housing.builder().name(name).price(price).height(height).width(width).build();
        housingRepository.save(productFood);
    }
}
