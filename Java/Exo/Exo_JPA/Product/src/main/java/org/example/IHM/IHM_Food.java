package org.example.IHM;

import org.example.Entity.Product_Electronic;
import org.example.Entity.Product_Food;
import org.example.Repository.ElectronicRepository;
import org.example.Repository.FoodRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class IHM_Food {

    private Scanner sc ;
    private FoodRepository foodRepository;


    public IHM_Food(Scanner sc, EntityManager em) {
        this.sc = sc;
        foodRepository = new FoodRepository(em);

    }


    public void start() {
        while (true) {
            System.out.println("Menu Food: ");
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

        Product_Food peripherique = foodRepository.findById(id);
        if(peripherique != null){
            foodRepository.delete(peripherique);
        }else{
            System.out.println("aucun produit trouvé");
        }
    }

    private void getProductById() {
        System.out.println("id du produit : ");
        int id = sc.nextInt();
        sc.nextLine();

        Product_Food peripherique = foodRepository.findById(id);
        if(peripherique != null){
            System.out.println(peripherique);
        }else {
            System.out.println("aucun produit trouvé");
        }
    }

    private void getAllProducts() {
        List<Product_Food> productFoods = foodRepository.findAll();

        for (Product_Food peripherique : productFoods){
            System.out.println(peripherique);
        }
    }

    private void createProduct() {
        System.out.println("Veuillez indiquez le nom du produit");
        String name = sc.nextLine();
        System.out.println("Veuillez indiquez le prix du produit");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Veuillez indiquez la date de péremption");
        String bat = sc.nextLine();
        Product_Food productFood = Product_Food.builder().name(name).price(price).expiry_date(bat).build();
        foodRepository.save(productFood);
    }
}
