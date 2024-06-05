package org.example;

public class Product {
    private String type;
    private String name;
    private  int sellin;
    private int quality;

    public Product(String type, String name, int sellin, int quality) {
        this.type = type;
        this.name = name;
        this.sellin = sellin;
        this.quality = quality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellin() {
        return sellin;
    }

    public void setSellin(int sellin) {
        this.sellin = sellin;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
