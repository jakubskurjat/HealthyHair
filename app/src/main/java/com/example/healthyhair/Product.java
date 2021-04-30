package com.example.healthyhair;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Product {
    private String time;
    private String name;
    private String composition;
    private String productType;
    private String type;

    public Product(String time, String name, String composition, String productType, String type) {
        this.time = time;
        this.name = name;
        this.composition = composition;
        this.productType = productType;
        this.type = type;
    }

    public Product(String name, String composition, String productType, String type) {
        this.time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date());
        this.name = name;
        this.composition = composition;
        this.productType = productType;
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getComposition() {
        return composition;
    }

    public String getProductType() {
        return productType;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", composition='" + composition + '\'' +
                ", productType='" + productType + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
