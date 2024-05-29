package org.example.service;

import org.example.entity.Commentaire;
import org.example.entity.Produit;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;


import java.util.Date;
import java.util.List;
import java.util.Queue;

public class ProduitService extends BaseService implements Repository<Produit> {

    public ProduitService(){
        super();
    }


    @Override
    public boolean create(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Produit findById(int id) {
       // Produit produit = null;
        session = sessionFactory.openSession();
        Produit produit = session.get(Produit.class,id);
        session.close();
        return produit;
    }


    // 1. Afficher la totalité des produits
    @Override
    public List<Produit> findAll() {
        List<Produit> produitList = null;
        session = sessionFactory.openSession();
        Query<Produit> produitQuery = session.createQuery("from Produit ");
        produitList = produitQuery.list();
        session.close();
        return produitList;
    }

    public void close(){
        sessionFactory.close();
    }




    //  2. Afficher la liste des produits dont le prix est supérieur à 100 euros
    public List<Produit> filterByPrice(double min) throws Exception {
        if(min > 0) {
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where prix >= :minprice");
            produitQuery.setParameter("minprice",min);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw  new Exception("erreur valeur min");
    }

    //  3. Afficher la liste des produits achetés entre deux dates.

    public List<Produit> filterByDate(Date min, Date max) throws Exception{
        if(min.before(max)){
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where dateAchat >= :datemin and dateAchat <= :datemax");
            produitQuery.setParameter("datemin",min);
            produitQuery.setParameter("datemax",max);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw  new Exception("erreur date");
    }

    //  2. retourner les numéros et reference des articles dont le stock est inférieur à une valeur lue au clavier.
    public List<Produit> filterByStockMax(int max) throws Exception {
        if(max > 0) {
            session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where stock < :stockmax");
            produitQuery.setParameter("stockmax",max);
            List<Produit> produitList = produitQuery.list();
            session.close();
            return produitList;
        }
        throw  new Exception("erreur valeur");
    }

    // Exo 4.1

    public double getTotalPrice(String marque){
        session = sessionFactory.openSession();
        Query<Double> produitQueryPrice = session.createQuery("SELECT SUM(prix*stock) from Produit as p where p.marque = :marque");
        produitQueryPrice.setParameter("marque",marque);
        Double produitsValue = produitQueryPrice.getSingleResult();
        session.close();
        return produitsValue;
    }

    //Exo 4.2

    public double getAveragePrice(){
        session = sessionFactory.openSession();
        Query<Double> produitQueryAveragePrice = session.createQuery("SELECT avg(prix) from Produit");

        Double produitsAverageValue = produitQueryAveragePrice.getSingleResult();
        session.close();
        return produitsAverageValue;
    }

    //Exo 4.3
    public List<Produit> getProductViaBrande(String marque){
        session = sessionFactory.openSession();
        Query<Produit> productFromBrand = session.createQuery("from Produit WHERE marque =:marque");

        productFromBrand.setParameter("marque",marque);



        List<Produit> produitsFromBrand = productFromBrand.list();
        session.close();
        return produitsFromBrand;
    }

    //Exo 4.4
    public int deleteProductsOfBrand(String marque){

        session = sessionFactory.openSession();
        Query<Produit> deleteProductFromBrand = session.createQuery("DELETE from Produit WHERE marque =:marque");
        deleteProductFromBrand.setParameter("marque",marque);
        session.getTransaction().begin();
        int success = deleteProductFromBrand.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return success;


    }

    //Exo 5.4

    public List<Produit> getWhereAvgEvalAboveFour(){
        session = sessionFactory.openSession();
        Query<Produit> getProductAbove = session.createQuery("select distinct c.produit from Commentaire as c where (c.Note)>4");

        List<Produit> produitsNotedAboveFour = getProductAbove.list();
        session.close();
        return produitsNotedAboveFour;
    }


}
