package org.example.IHM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class IHM {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Product_Jpa");
    EntityManager em = emf.createEntityManager();

    Scanner sc = new Scanner(System.in);


    public void start() {
        while (true) {
            System.out.println("Menu : ");
            System.out.println("1/ IHM_Nourriture");
            System.out.println("2/ IHM_Electronic");
            System.out.println("3/ IHM_Housing");

            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry) {
                case 1:
                    IHM_Food ihmFood = new IHM_Food(sc,em);
                    ihmFood.start();
                    break;
                case 2:
                    IHM_Electronic ihmElectronic = new IHM_Electronic(sc,em);
                    ihmElectronic.start();
                    break;
                case 3:
                    IHM_Housing ihm_housing = new IHM_Housing(sc,em);
                    ihm_housing.start();
                    break;
                default:
                    return;
            }
        }

    }




}
