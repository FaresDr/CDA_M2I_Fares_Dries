package org.example.exo6.repository;

import org.example.exo6.model.Product;
import org.example.exo6.model.Users;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository extends Repository<Product>{

    public ProductRepository(Session session) {
        super(session);
    }

    @Override
    public Product findById(int id) {
        return (Product) _session.get(Product.class,id);
    }

    @Override
    public List<Product> findAll() {
        return _session.createQuery("from Product ").list();
    }
}
