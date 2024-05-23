package org.example.Repository;

import org.example.Entity.Product_Food;

import javax.persistence.EntityManager;
import java.util.List;

public class FoodRepository extends BaseRepository<Product_Food>{
    public FoodRepository(EntityManager em) {
        super(em);
    }

    @Override
    public void save(Product_Food element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Product_Food element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Product_Food findById(int id) {
        return em.find(Product_Food.class,id);
    }

    @Override
    public List<Product_Food> findAll() {
        return em.createQuery("SELECT c from Product_Food c").getResultList();
    }
}
