package org.example.tp_final.repository;

import org.example.tp_final.model.Doctor;
import org.hibernate.Session;

import java.util.List;

public class DoctorRepository extends Repository<Doctor>{

    public DoctorRepository(Session session) {
        super(session);
    }



    @Override
    public Doctor findById(int id) {
        return (Doctor) _session.get(Doctor.class,id);
    }

    @Override
    public List<Doctor> findAll() {
        return _session.createQuery("from Doctor ").list();
    }

}
