package com.example.Tp_Final_Spring_JPA.services;

import com.example.Tp_Final_Spring_JPA.dao.UserRepository;
import com.example.Tp_Final_Spring_JPA.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByNameAndPassword(String name, String password) {
        return userRepository.findByUsernameAndPassword(name, password);
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User update(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
