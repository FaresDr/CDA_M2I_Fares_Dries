package org.example;

import org.example.entity.Produit;
import org.example.service.ProduitService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.type.DateType;
import org.hibernate.type.StringType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        // Exercice 1
      //  - Créer cinq produits,

        ProduitService ps = new ProduitService();
        Scanner sc = new Scanner(System.in);


//        ps.create(new Produit("Apple","i5685",1500,199,new Date("2024/05/20")));
//        ps.create(new Produit("Samsung","s7985",800,85,new Date("2024/01/10")));
//        ps.create(new Produit("DELL","d5685",300,75,new Date("2023/07/20")));
//        ps.create(new Produit("Huawei","hu568",20,800,new Date("2022/12/22")));
//        ps.create(new Produit("Nokia","3310",50,89,new Date("2024/05/10")));



      //  - Afficher les informations du produit dont id = 2,

        Produit p = ps.findById(2);
        System.out.println(p);


      //  - Supprimer le produit dont id = 3,

      //  ps.delete(ps.findById(3));
      //  - Modifier les informations du produit dont id = 1,
//
//        Produit p1 = ps.findById(1);
//        if(p1 != null){
//            p1.setPrix(2000);
//            ps.update(p1);
//        }


        ps.close();

        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query<Produit> allProductQuery = session.createQuery("from Produit ");

        // avec la liste
        List<Produit> products = allProductQuery.list();
        for (Produit produit: products) {
            System.out.println(produit.toString());
        }

        System.out.println("-------------------------------------------");

        Query<Produit> productAboveHundred = session.createQuery("from Produit WHERE prix>100");

        List<Produit> productsHundred = productAboveHundred.list();
        for (Produit produit: productsHundred) {
            System.out.println(produit.toString());
        }
        System.out.println("-------------------------------------------");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse("2024-01-10");
        Date endDate = format.parse("2024-05-21");



        Query<Produit> productBetweenDate = session.createQuery("from Produit WHERE dateAchat BETWEEN :start AND :end");

        productBetweenDate.setParameter("start",startDate);
        productBetweenDate.setParameter("end",endDate);


        List<Produit> produitsDate = productBetweenDate.list();
        for (Produit produit: produitsDate) {
            System.out.println(produit.toString());
        }
        System.out.println("-------------------------------------------");

        System.out.println("Veuillez entrer la date de début au format YYYY-MM-DD");
        String dateStart = sc.nextLine();
        Date startDate2 = format.parse(dateStart);
        System.out.println("Veuillez entrer la date de fin au format YYYY-MM-DD");
        String dateEnd = sc.nextLine();
        Date endDate2 = format.parse(dateEnd);
        Query<Produit> productBetweenDateEntered = session.createQuery("from Produit WHERE dateAchat BETWEEN :start AND :end");

        productBetweenDateEntered.setParameter("start",startDate2);
        productBetweenDateEntered.setParameter("end",endDate2);


        List<Produit> produitsDateEntered = productBetweenDateEntered.list();
        for (Produit produit: produitsDateEntered) {
            System.out.println(produit.toString());
        }
        System.out.println("-------------------------------------------");

        System.out.println("Veuillez indiquer la valeur du stock");

        int stockValue = sc.nextInt();
        sc.nextLine();

        Query<Produit> produitQueryStock = session.createQuery("from Produit as p where p.stock < :stockVal");
        produitQueryStock.setParameter("stockVal",stockValue);

        List<Produit> produitsStock = produitQueryStock.list();
        for (Produit produit: produitsStock) {
            System.out.println(produit.getMarque());
            System.out.println(produit.getReference());
        }

        System.out.println("-------------------------------------------");

        System.out.println("Veuillez indiquer la marque voulu");
        String marque =  sc.nextLine();
        Query<Double> produitQueryPrice = session.createQuery("SELECT prix*stock from Produit as p where p.marque = :marque");
        produitQueryPrice.setParameter("marque",marque);
        Double produitsValue = produitQueryPrice.getSingleResult();
        System.out.println(produitsValue);

        System.out.println("-------------------------------------------");

        System.out.println("Veuillez indiquer la marque voulu");

        Query<Double> produitQueryAveragePrice = session.createQuery("SELECT avg(prix) from Produit");

        Double produitsAverageValue = produitQueryAveragePrice.getSingleResult();
        System.out.println(produitsAverageValue);

        System.out.println("-------------------------------------------");

        System.out.println("Veuillez entrer le nom de la marque voulue");
        marque = sc.nextLine();
        Query<Produit> productFromBrand = session.createQuery("from Produit WHERE marque =:marque");

        productFromBrand.setParameter("marque",marque);



        List<Produit> produitsFromBrand = productFromBrand.list();
        for (Produit produit: produitsFromBrand) {
            System.out.println(produit.toString());
        }

        System.out.println("-------------------------------------------");

        System.out.println("Veuillez entrer le nom de la marque voulue");
        marque = sc.nextLine();
        Query<Produit> deleteProductFromBrand = session.createQuery("DELETE from Produit WHERE marque =:marque");
        deleteProductFromBrand.setParameter("marque",marque);
        session.getTransaction().begin();
        int success = deleteProductFromBrand.executeUpdate(); // C'est le nombre de ligne affectée par la requete
        session.getTransaction().commit();
        System.out.println(success);







    }
}