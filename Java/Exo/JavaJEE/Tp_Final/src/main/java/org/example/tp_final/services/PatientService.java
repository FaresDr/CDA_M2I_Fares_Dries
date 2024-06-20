package org.example.tp_final.services;

import org.example.tp_final.model.Patient;
import org.example.tp_final.repository.PatientRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private PatientRepository patientRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public PatientService(SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
    }

    public Patient getPatient(int id){
        Patient patient = null;
        session = _sessionFactory.openSession();
        patientRepository = new PatientRepository(session);
        try {
            patient = patientRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return patient;
    }

    public boolean createPatient(String name,String prenom,String url, LocalDate birthdate){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        patientRepository= new PatientRepository(session);
        Patient patient = Patient.builder().nom(name).url(url).consultations(new ArrayList<>()).prenom(prenom).date_de_naissance(birthdate).build();
        try {
            patientRepository.create(patient);
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
    public List<Patient> getAllPatient(){
        List<Patient> patientList = null;
        session = _sessionFactory.openSession();
        patientRepository = new PatientRepository(session);
        try {
            patientList = patientRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
        return patientList;
    }

    public boolean Delete(int id){
        Patient o = getPatient(id);
        session = _sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
