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
public class Product_Food extends Product {

    private String expiry_date;

    public Product_Food() {super();
    }

    @Override
    public String toString() {
        return "Product_Food{" +
                "expiry_date=" + expiry_date +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
