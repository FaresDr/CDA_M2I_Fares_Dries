package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Peripherique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peripherique_id")
    private  int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "peripherique_computer", joinColumns = @JoinColumn(name = "peripherique_id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Computer> computersP;

    public void add (Computer computer){
        computersP.add(computer);
    }

    @Override
    public String toString() {
        return "Peripherique{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", computers=" + computersP +
                '}';
    }
}
