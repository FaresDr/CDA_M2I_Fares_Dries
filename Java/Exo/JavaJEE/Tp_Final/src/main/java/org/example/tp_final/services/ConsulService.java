package org.example.tp_final.services;

import org.example.tp_final.model.Consul;
import org.example.tp_final.model.Doctor;
import org.example.tp_final.model.Patient;
import org.example.tp_final.repository.ConsulRepository;
import org.example.tp_final.repository.DoctorRepository;
import org.example.tp_final.repository.PatientRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ConsulService {

    private ConsulRepository consulRepository;
    private SessionFactory _sessionFactory;

    private PatientRepository patientRepository;
    private Session session;

    public ConsulService(SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
    }



    public Consul getConsul(int id){
        Consul consul = null;
        session = _sessionFactory.openSession();
        consulRepository = new ConsulRepository(session);
        try {
            consul = consulRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return consul;
    }

    public boolean createConsul(String resume, int id ){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        consulRepository= new ConsulRepository(session);
        patientRepository = new PatientRepository(session);
        Patient p = patientRepository.findById(id);
        if(p!= null) {
            Consul consul = Consul.builder().patient(p).dateDeCreation(LocalDate.now()).resume(resume).build();
            try {
                consulRepository.create(consul);
                session.getTransaction().commit();
                result = true;
            } catch (Exception except) {
                try {
                    session.getTransaction().rollback();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } finally {
                session.close();
            }
            return result;
        }else {
            return result;
        }
    }
    public List<Consul> getUsers(){
        List<Consul> consuls = null;
        session = _sessionFactory.openSession();
        consulRepository = new ConsulRepository(session);
        try {
            consuls = consulRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
        return consuls;
    }

    public List<Consul> getConsulByParams(int id ){
        session = _sessionFactory.openSession();
        List<Consul> consulsToFind = null;
        Query<Consul> usersQuery = session.createQuery("from  Consul WHERE patient.id = :id ");
        usersQuery.setParameter("id",id);

        consulsToFind = usersQuery.list();
        session.close();
        return consulsToFind;

    }
}
