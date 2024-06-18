package org.example.exo_7.service;

import org.example.exo_7.model.Image;
import org.example.exo_7.repository.ImageRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class ImageService {

    private ImageRepository imageRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public ImageService(SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
    }

    public boolean createImage(String url){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        imageRepository= new ImageRepository(session);
        Image image = Image.builder().url(url).build();
        try {
            imageRepository.create(image);
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
    public List<Image> getImages(){
        List<Image> imageList = null;
        session = _sessionFactory.openSession();
        imageRepository = new ImageRepository(session);
        try {
            imageList = imageRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
        return imageList;
    }
}
