package org.example.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder
public class Product_Electronic extends Product{

    private String batterie_duration;

    public Product_Electronic() {
        super();
    }

    @Override
    public String toString() {
        return "Product_Electronic{" +
                "batterie_duration='" + batterie_duration + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
