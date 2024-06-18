package org.example.exo6.services;

import org.example.exo6.model.Product;
import org.example.exo6.model.Users;
import org.example.exo6.repository.ProductRepository;
import org.example.exo6.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class ProductService {

    private ProductRepository productRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public ProductService(SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
    }

    public Product getProduct(int id){
        Product product = null;
        session = _sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        try {
            product = productRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return product;
    }

    public boolean createProduct(String name, String marque, String reference, LocalDate dateAchat, double price, int stock,String url ){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        productRepository= new ProductRepository(session);
        Product product = Product.builder().nom(name).marque(marque).reference(reference).dateAchat(dateAchat).price(price).stock(stock).url(url).build();
        try {
            productRepository.create(product);
            session.getTransaction().commit();
            result = true;
        }catch (Exception except){
            try {
                session.getTransaction().rollback();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }finally {
            session.close();
        }
        return result;
    }
    public List<Product> getProduct(){
        List<Product> productList = null;
        session = _sessionFactory.openSession();
        productRepository = new ProductRepository(session);
        try {
            productList = productRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
        return productList;
    }

    public boolean Delete(int id){
        Product o = getProduct(id);
        session = _sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }


}
