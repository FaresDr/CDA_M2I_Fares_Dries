package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;

    //    @Embedded
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_identifiant")
    private Identifiant identifiant;

    @ManyToOne
    @JoinColumn(name = "processor_id")
    private Processor processor;

    @ManyToOne
    @JoinColumn(name = "os_id")
    private OS os;

    @ManyToMany(mappedBy = "computersP")
    private List<Peripherique> peripheriques = new ArrayList<>() ;

    public void add (Peripherique peripherique){
        peripheriques.add(peripherique);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", identifiant=" + identifiant +
                ", processor=" + processor +
                ", os=" + os +
//                ", peripheriques=" + peripheriques +
                '}';
    }
}
