package org.example.tp_final.repository;

import org.hibernate.Session;

import java.util.List;

public abstract class Repository<T> {
    protected Session _session;
    public Repository(Session session){
        _session = session;
    }

    public void create(T o){
        _session.save(o);
    }

    public void update(T o){
        _session.update(o);
    }

    public void delate(T o){
        _session.delete(o);
    }

    abstract T findById(int id);

    abstract List<T> findAll();
}