package org.example.exo_5.Interface;

import java.util.List;

public interface Repository <T>{
    boolean create(T o);
    boolean update(T o);
    boolean delete(T o);

    T findById(int id);

    List<T> findAll();
}
