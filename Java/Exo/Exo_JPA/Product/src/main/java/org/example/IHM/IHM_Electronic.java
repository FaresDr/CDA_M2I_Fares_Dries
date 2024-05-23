package org.example.IHM;

import org.example.Entity.Product_Electronic;
import org.example.Repository.ElectronicRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class IHM_Electronic {

    private Scanner sc ;
    private ElectronicRepository electronicRepository;


    public IHM_Electronic(Scanner sc, EntityManager em) {
        this.sc = sc;
        electronicRepository = new ElectronicRepository(em);

    }


    public void start() {
        while (true) {
            System.out.println("Menu Electronic: ");
            System.out.println("1/ cree");
            System.out.println("2/ afficher tout");
            System.out.println("3/ afficher par id");
            System.out.println("4/ supprimer");
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

        Product_Electronic peripherique = electronicRepository.findById(id);
        if(peripherique != null){
            electronicRepository.delete(peripherique);
        }else{
            System.out.println("aucun produit trouvé");
        }
    }

    private void getProductById() {

        System.out.println("id du produit : ");
        int id = sc.nextInt();
        sc.nextLine();

        Product_Electronic peripherique = electronicRepository.findById(id);
        if(peripherique != null){
            System.out.println(peripherique);
        }else {
            System.out.println("aucun produit trouvé");
        }
    }

    private void getAllProducts() {
        List<Product_Electronic> productElectronics = electronicRepository.findAll();

        for (Product_Electronic peripherique : productElectronics){
            System.out.println(peripherique);
        }
    }

    private void createProduct() {
        System.out.println("Veuillez indiquez le nom du produit");
        String name = sc.nextLine();
        System.out.println("Veuillez indiquez le prix du produit");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Veuillez indiquez le temps restant de la batterie");
        String bat = sc.nextLine();
        Product_Electronic productElectronic = Product_Electronic.builder().name(name).price(price).batterie_duration(bat).build();
        electronicRepository.save(productElectronic);

    }
}
