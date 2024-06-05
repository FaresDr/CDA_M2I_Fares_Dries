package org.example;

import java.util.Arrays;
import java.util.List;

public class Shop {
    private List<Product> produits;

    public void update(Product product){
        if(product.getSellin()>50){
            product.setSellin(50);
        }
        if(product.getQuality()<0){
            product.setQuality(0);
        }
        if(product.getSellin()>0) {
            product.setSellin(product.getSellin() - 1);
        }
        if(product.getQuality()>0) {
            product.setQuality(product.getQuality() - 1);
        }
    }
}
