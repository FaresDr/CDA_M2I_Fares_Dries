package org.example.tp_final.repository;

import org.example.tp_final.model.Doctor;
import org.example.tp_final.model.Patient;
import org.hibernate.Session;

import java.util.List;

public class PatientRepository extends Repository<Patient>{

    public PatientRepository(Session session) {
        super(session);
    }

    @Override
   public Patient findById(int id) {
        return (Patient) _session.get(Patient.class,id);
    }

    @Override
   public List<Patient> findAll() {
        return _session.createQuery("from Patient ").list();
    }
}
