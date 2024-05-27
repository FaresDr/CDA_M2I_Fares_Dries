package org.example.Repository;

import org.example.Entity.Adresse;

import javax.persistence.EntityManager;
import java.util.List;

public class AdressRepository extends BaseRepository<Adresse>{

    public AdressRepository(EntityManager em) {
        super(em);
    }
    @Override
    public void save(Adresse element) {
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Adresse element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Adresse findById(int id) {
        return em.find(Adresse.class,id);
    }

    @Override
    public List<Adresse> findAll() {
        return em.createQuery("SELECT c from Adresse c",Adresse.class).getResultList();
    }
}
