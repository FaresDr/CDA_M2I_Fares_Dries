package org.example.Entity;


import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Inheritance(strategy =  InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    protected String name;
    protected double price;

    public Product() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
