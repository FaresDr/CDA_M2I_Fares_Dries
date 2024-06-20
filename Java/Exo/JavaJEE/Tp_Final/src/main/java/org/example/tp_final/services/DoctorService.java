package org.example.tp_final.services;

import org.example.tp_final.exception.UserAlreadyExists;
import org.example.tp_final.exception.WrongPasswordException;
import org.example.tp_final.model.Doctor;
import org.example.tp_final.repository.DoctorRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class DoctorService {
    private DoctorRepository doctorRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public DoctorService(SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
    }

    public Doctor getUser(int id){
        Doctor doctor = null;
        session = _sessionFactory.openSession();
        doctorRepository = new DoctorRepository(session);
        try {
            doctor = doctorRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return doctor;
    }

    public boolean createDoctor(String username, String password,String mail ){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        doctorRepository= new DoctorRepository(session);
        Doctor doctor = Doctor.builder().mail(mail).username(username).password(password).build();
        try {
            doctorRepository.create(doctor);
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
    public List<Doctor> getUsers(){
        List<Doctor> doctorList = null;
        session = _sessionFactory.openSession();
        doctorRepository = new DoctorRepository(session);
        try {
            doctorList = doctorRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
        return doctorList;
    }

    public Doctor getUserByParams(String username,String password,String mail){
        session = _sessionFactory.openSession();
        Doctor userToFind = null;
        Query<Doctor> usersQuery = session.createQuery("from  Doctor WHERE username = :username and password = :password and mail = :mail ");
        usersQuery.setParameter("username",username);
        usersQuery.setParameter("password",password);
        usersQuery.setParameter("mail",mail);
        userToFind = usersQuery.uniqueResult();
        session.close();
        return userToFind;

    }
}
