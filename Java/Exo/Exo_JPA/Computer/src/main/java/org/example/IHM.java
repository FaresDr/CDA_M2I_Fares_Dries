package org.example;

import org.example.Entity.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHM {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("Computer_Jpa");
    EntityManager em = emf.createEntityManager();

    Scanner sc = new Scanner(System.in);


    public void start (){
        while (true){
            System.out.println("Menu : ");
            System.out.println("1/ cree");
            System.out.println("2/ afficher tout");
            System.out.println("3/ afficher par id");
            System.out.println("4/ supprimer");
            System.out.println("5/ editer");
            System.out.println("6/ create os");
            System.out.println("7/ create processor");
            System.out.println("8/ Show OS");
            System.out.println("9/ cree peripherique");
            System.out.println("10/ afficher tout peripherique");
            System.out.println("11/ afficher peripherique par id");
            System.out.println("12/ supprimer peripherique par id");
            System.out.println("13/ editer peripherique");
            System.out.println("14/ add peripherique to computer");
            System.out.println("15/ add computer to peripherique");
            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry){
                case 1:
                    createComputer();
                    break;
                case 2:
                    getAllComputer();
                    break;
                case 3:
                    getComputerById();
                    break;
                case 4:
                    deleteComputer();
                    break;
                case 5:
                    editComputer();
                    break;
                case 6 :
                    createOs();
                    break;
                case 7 :
                    createProcessor();
                    break;
                case 8 :
                    showInfo();
                    break;
                case 9 :
                    createPheri();
                    break;
                case 10 :
                    showPheri();
                    break;
                case 11 :
                    showPheriById();
                    break;
                case 12 :
                    deletePeri();
                    break;
                case 13 :
                    editPeri();
                    break;
                case 14 :
                    addPeriToComputer();
                    break;
                case 15 :
                    addComputerToPeri();
                    break;
                default:
                    return;
            }
        }

    }

    private void addPeriToComputer() {
        Computer computer = getComputerById();
        computer.setPeripheriques(new ArrayList<>());
        em.getTransaction().begin();
//        computer.add(em.find(Peripherique.class,1));
      computer.add(em.find(Peripherique.class,1));
        em.persist(computer);
        em.flush();
        em.getTransaction().commit();
    }
    private void addComputerToPeri() {
        Peripherique peri = showPheriById();
        em.getTransaction().begin();
        peri.add(em.find(Computer.class,2));
        em.persist(peri);
        em.flush();
        em.getTransaction().commit();
    }

    private void editPeri() {
        Peripherique peripherique = showPheriById();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(peripherique != null){
            peripherique.setName("HDMI");

        }
        transaction.commit();
    }

    private void deletePeri() {
        Peripherique peripherique = showPheriById();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(peripherique != null){
            em.remove(peripherique);
        }
        transaction.commit();
    }

    private Peripherique showPheriById() {
        System.out.println("id peripherique :");
        int id = sc.nextInt();
        sc.nextLine();

        Peripherique peripherique = em.find(Peripherique.class,id);
        if(peripherique != null){
            System.out.println(peripherique);
        }else {
            System.out.println("Periphérique not found");
        }
        return peripherique;
    }

    private void showPheri() {

        Query query = em.createQuery("select p from Peripherique p");
        List peripheriques = query.getResultList();

        for (Object peripherique : peripheriques){
            System.out.println(peripherique);
        }
    }

    private void createPheri() {
        Peripherique peripherique = Peripherique.builder().name("USB").build();
        em.getTransaction().begin();
        em.persist(peripherique);
        em.getTransaction().commit();
    }

    private void createComputer (){

        Identifiant identifiant = Identifiant.builder().iMac("Mon adresse imac").ip("mon adress ip").build();
        Processor processor = em.find(Processor.class,1);
        OS os = em.find(OS.class,1);
        Computer computer = Computer.builder().name("MyComputer").price(1200.50f).identifiant(identifiant).processor(processor).os(os).build();

        em.getTransaction().begin();
        em.persist(computer);
        em.getTransaction().commit();
    }

    private void getAllComputer (){
        Query query = em.createQuery("select c from Computer c");
        List computerList = query.getResultList();

        for (Object computer : computerList){
            System.out.println(computer);
        }
    }

    private void createOs (){
        OS os = OS.builder().name("Windows").Version("10.12").build();
        em.getTransaction().begin();
        em.persist(os);
        em.getTransaction().commit();
    }

    private void createProcessor (){
        Processor processor = Processor.builder().heart(5).thread(8000).generation(7).build();
        em.getTransaction().begin();
        em.persist(processor);
        em.getTransaction().commit();
    }

    private Computer getComputerById (){
        System.out.println("id computer :");
        int id = sc.nextInt();
        sc.nextLine();

        Computer computer = em.find(Computer.class,id);
        if(computer != null){
            System.out.println(computer);
        }else {
            System.out.println("Computer not found");
        }
        return computer;
    }

    private void deleteComputer (){
        Computer computer = getComputerById();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(computer != null){
            em.remove(computer);
        }
        transaction.commit();
    }

    private void editComputer (){
        Computer computer = getComputerById();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(computer != null){
            computer.setName("myComputer2");
            computer.setPrice(1000.99f);
        }
        transaction.commit();
    }

    private void showInfo (){
        OS os = em.find(OS.class,1);
        System.out.println( "Os found : "+os);
    }
}
