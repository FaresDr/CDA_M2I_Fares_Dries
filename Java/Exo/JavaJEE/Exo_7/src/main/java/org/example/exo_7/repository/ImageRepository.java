package org.example.exo_7.repository;

import org.example.exo_7.model.Image;
import org.hibernate.Session;

import java.util.List;

public class ImageRepository extends Repository<Image> {

    public ImageRepository(Session session) {
        super(session);
    }

    @Override
    public Image findById(int id) {
        return (Image) _session.get(Image.class,id);
    }

    @Override
    public List<Image> findAll() {
        return _session.createQuery("from Image ").list();
    }
}
