package org.example.Repository;

import org.example.Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;

import java.util.List;

public class ProductRepository extends BaseRepository<Product>{


    public ProductRepository(Session session, SessionFactory sessionFactory, StandardServiceRegistry registre) {
        super();
    }

    @Override
    public void save(Product element) {
        session.getTransaction().begin();
        session.save(element);
        session.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        session.getTransaction().begin();
        Product p = findById(id);
        session.remove(p);
        session.close();

    }

    @Override
    public void update(Product element) {
        session.getTransaction().begin();
        session.update(element);

    }

    @Override
    public Product findById(int id) {
        session.getTransaction().begin();
        Product p =  session.load(Product.class,id) ;
        session.close();
        return p;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
