package org.example.exo6.repository;

import org.example.exo6.model.Users;
import org.hibernate.Session;

import java.util.List;

public class UserRepository extends Repository<Users>{
    public UserRepository(Session session) {
        super(session);
    }

    @Override
    public Users findById(int id) {
        return (Users) _session.get(Users.class,id);
    }

    @Override
    public List<Users> findAll() {
        return _session.createQuery("from Users ").list();
    }
}
