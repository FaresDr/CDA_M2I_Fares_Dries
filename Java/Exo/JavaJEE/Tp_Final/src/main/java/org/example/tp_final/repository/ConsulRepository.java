package org.example.tp_final.repository;

import org.example.tp_final.model.Consul;
import org.hibernate.Session;

import java.util.List;

public class ConsulRepository extends Repository<Consul>{


    public ConsulRepository(Session session) {
        super(session);
    }

    @Override
   public Consul findById(int id) {
        return null;
    }

    @Override
   public List<Consul> findAll() {
        return null;
    }
}
