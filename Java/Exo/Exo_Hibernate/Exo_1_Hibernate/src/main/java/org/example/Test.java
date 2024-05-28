package org.example;

import org.example.Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.getTransaction().begin();
        Product p1 = Product.builder().stock(25).price(12).dateAchat(new Date()).marque("Nike").reference("R5EB").build();
        Product p2 = Product.builder().stock(50).price(9).dateAchat(new Date()).marque("Adidas").reference("R4EC").build();
        Product p3 = Product.builder().stock(30).price(15).dateAchat(new Date()).marque("Puma").reference("R3ED").build();
        Product p4 = Product.builder().stock(10).price(20).dateAchat(new Date()).marque("Jordan").reference("R2EE").build();
        Product p5 = Product.builder().stock(100).price(8).dateAchat(new Date()).marque("Reebok").reference("R1EF").build();

        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        session.save(p5);

        session.getTransaction().commit();

        session.getTransaction().begin();
        Product pLoad = session.load(Product.class,2);
        System.out.println(pLoad.toString());

        Product pDelete = session.load(Product.class,3);

        session.delete(pDelete);

        Product pUpdate = session.load(Product.class,1);

        System.out.println(pUpdate.getStock());

        pUpdate.setStock(23);

        session.update(pUpdate);

        session.getTransaction().commit();
        //Fermeture de la session et la sessionfactory
        session.close();
        sessionFactory.close();







    }
}
