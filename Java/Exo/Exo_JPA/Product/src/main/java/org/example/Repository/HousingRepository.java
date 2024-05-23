package org.example.Repository;

import org.example.Entity.Product_Food;
import org.example.Entity.Product_housing;

import javax.persistence.EntityManager;
import java.util.List;

public class HousingRepository extends BaseRepository<Product_housing>{
    public HousingRepository(EntityManager em) {
        super(em);
    }

    @Override
    public void save(Product_housing element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Product_housing element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Product_housing findById(int id) {
        return em.find(Product_housing.class,id);
    }

    @Override
    public List<Product_housing> findAll() {
        return em.createQuery("SELECT c from Product_housing c").getResultList();
    }
}
