package com.example.demo.services;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentServices {

    private final Map<UUID, Student> students;

    public StudentServices() {
        students = new HashMap<>();
    }

    public List<Student> getAllStudents(){
        return students.values().stream().toList();
    }

    public Student getById(UUID id){ return students.get(id);}

    public List<Student> getByNameAndLastName(String name,String lastname){return students.values().stream().filter(c -> c.getName().equals(name) && c.getLastname().equals(lastname)).toList();}

    public void add (Student s){students.put(s.getId(),s);}

    public UUID deleteStudent(UUID id){
        students.remove(id);
        return id;
    }

    public UUID updateStudent(String name,String lastname,String email, UUID id){
        Student s = getById(id);
        if(name != ""){ s.setName(name);}
        if(lastname != ""){s.setLastname(lastname);}
        if (email != ""){s.setEmail(email);}
        return s.getId();
    }
}
