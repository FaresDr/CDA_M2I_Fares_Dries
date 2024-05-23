package org.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@SuperBuilder

public class Product_housing extends Product{

    private double height;

    private double width;

    public Product_housing() {super();
    }

    @Override
    public String toString() {
        return "Product_housing{" +
                "height=" + height +
                ", width=" + width +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
