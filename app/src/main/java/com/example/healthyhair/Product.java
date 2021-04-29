package com.example.healthyhair;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Product {
    private String time;
    private String name;
    private String composition;

    public Product(String time, String name, String composition) {
        this.time = time;
        this.name = name;
        this.composition = composition;
    }

    public Product(String name, String composition) {
        this.time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date());
        this.name = name;
        this.composition = composition;
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

    @Override
    public String toString() {
        return "Product{" +
                "time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", composition='" + composition + '\'' +
                '}';
    }
}
