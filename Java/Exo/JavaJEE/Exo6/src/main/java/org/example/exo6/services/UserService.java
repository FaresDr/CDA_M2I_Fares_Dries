package org.example.exo6.services;

import org.example.exo6.model.Users;
import org.example.exo6.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class UserService {
    private UserRepository userRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public UserService(SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
    }

    public Users getUser(int id){
        Users user = null;
        session = _sessionFactory.openSession();
        userRepository = new UserRepository(session);
        try {
            user = userRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return user;
    }

    public boolean createUser(String username, String password,String mail ){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        userRepository= new UserRepository(session);
        Users user = Users.builder().mail(mail).username(username).password(password).build();
        try {
            userRepository.create(user);
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
    public List<Users> getUsers(){
        List<Users> usersList = null;
        session = _sessionFactory.openSession();
        userRepository = new UserRepository(session);
        try {
            usersList = userRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
        }
        return usersList;
    }

    public Users getUserByParams(String username,String password,String mail){
        session = _sessionFactory.openSession();
        Users userToFind = null;
        Query<Users> usersQuery = session.createQuery("from  Users WHERE username = :username and password = :password and mail = :mail ");
        usersQuery.setParameter("username",username);
        usersQuery.setParameter("password",password);
        usersQuery.setParameter("mail",mail);
        userToFind = usersQuery.uniqueResult();
        session.close();
        return userToFind;

    }
}
