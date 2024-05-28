package org.example.Repository;

import org.example.Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class  BaseRepository<T> {

    StandardServiceRegistry registre;
    SessionFactory sessionFactory;

    Session session;

    public BaseRepository() {
               registre= new StandardServiceRegistryBuilder().configure().build();
               sessionFactory=new MetadataSources(registre).buildMetadata().buildSessionFactory() ;
    }

    public abstract void save (T element);
    public abstract void delete (int id);

    public abstract void update (T element);
    public abstract T findById (int id);
    public abstract List<T> findAll ();
}
