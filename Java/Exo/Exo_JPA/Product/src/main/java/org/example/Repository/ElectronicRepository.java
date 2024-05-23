package org.example.Repository;

import org.example.Entity.Product_Electronic;
import org.example.Entity.Product_Food;

import javax.persistence.EntityManager;
import java.util.List;

public class ElectronicRepository extends BaseRepository<Product_Electronic>{
    public ElectronicRepository(EntityManager em) {
        super(em);
    }

    @Override
    public void save(Product_Electronic element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Product_Electronic element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Product_Electronic findById(int id) {
        return em.find(Product_Electronic.class,id);
    }

    @Override
    public List<Product_Electronic> findAll() {
        return em.createQuery("SELECT c from Product_Electronic c").getResultList();
    }
}
