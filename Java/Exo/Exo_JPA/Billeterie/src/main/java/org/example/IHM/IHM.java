package org.example.IHM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class IHM {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Billeterie_JPA");
    EntityManager em = emf.createEntityManager();

    Scanner sc = new Scanner(System.in);


    public void start() {
        while (true) {
            System.out.println("Menu : ");
            System.out.println("1/ IHM_Adresse");
            System.out.println("2/ IHM_Lieu");
//            System.out.println("3/ IHM_Housing");

            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry) {
                case 1:
                    IHM_Adresse ihmAdresse = new IHM_Adresse(sc,em);
                    ihmAdresse.start();
                    break;
                case 2:
                    IHM_Lieu ihmLieu = new IHM_Lieu(sc,em);
                    ihmLieu.start();
                    break;
//                case 3:
//                    IHM_Housing ihm_housing = new IHM_Housing(sc,em);
//                    ihm_housing.start();
//                    break;
                default:
                    return;
            }
        }

    }




}
