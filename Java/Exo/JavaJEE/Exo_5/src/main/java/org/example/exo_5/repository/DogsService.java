package org.example.exo_5.repository;

import org.example.exo_5.Interface.Repository;
import org.example.exo_5.model.Dogs;
import org.hibernate.query.Query;

import java.util.List;

public class DogsService extends BaseService implements Repository<Dogs> {
    public DogsService(){
        super();
    }


    @Override
    public boolean create(Dogs o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Dogs o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Dogs o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Dogs findById(int id) {
        session = sessionFactory.openSession();
        Dogs dogs = session.get(Dogs.class,id);
        session.close();
        return dogs;
    }

    @Override
    public List<Dogs> findAll() {
        List<Dogs> dogsList = null;
        session = sessionFactory.openSession();
        Query<Dogs> dogsQuery = session.createQuery("from Dogs ");
        dogsList = dogsQuery.list();
        session.close();

        return dogsList;
    }

    public void close(){
        sessionFactory.close();
    }
}
